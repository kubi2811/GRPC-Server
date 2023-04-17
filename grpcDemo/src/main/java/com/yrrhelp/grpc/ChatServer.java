package com.yrrhelp.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {
    private final int port;
    private final Server server;
    private final Map<String, StreamObserver<User.ChatMessage>> clients = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> messageLikes = new ConcurrentHashMap<>();

    public ChatServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new ChatServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("ChatServer started, listening on port " + port);
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }


    private class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
        @Override
        public void sendMessage(User.ChatMessage request, StreamObserver<User.ChatResponse> responseObserver) {
            String sender = request.getSender();

            // Broadcast the message to all connected clients

            if (!messageLikes.containsKey(sender)) {
                for (StreamObserver<User.ChatMessage> client : clients.values()) {
                    client.onNext(request);
                }
            } else {
                if (messageLikes.get(sender).intValue() >= 2) {
                    for (StreamObserver<User.ChatMessage> client : clients.values()) {
                        client.onNext(request);
                    }
                } else {
                    User.ChatResponse response = User.ChatResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Can't send message")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    return;
                }
            }

            // Add the message to the messageLikes map with initial like count of 0
            messageLikes.put(sender, new AtomicInteger(0));

            User.ChatResponse response = User.ChatResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Message sent successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void likeMessage(User.ChatMessage request, StreamObserver<User.ChatResponse> responseObserver) {
            String sender = request.getSender();
            String content = request.getContent();

            // Check if the message exists in the messageLikes map
            if (!messageLikes.containsKey(content)) {
                User.ChatResponse response = User.ChatResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Message not found")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            AtomicInteger likeCount = messageLikes.get(content);

            // Increase the like count by 1
            likeCount.incrementAndGet();

            // Check if the like count is greater than or equal to 2
            if (likeCount.get() >= 2) {
                // Remove the message from the messageLikes map
                messageLikes.remove(content);
            }

            User.ChatResponse response = User.ChatResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Message liked successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void receiveMessage(User.ChatMessage request, StreamObserver<User.ChatMessage> responseObserver) {
            String sender = request.getSender();

            // Add the client's observer to the clients map
            clients.put(sender, responseObserver);

            // Notify the client that it has successfully connected to the server
            User.ChatMessage connectMessage = User.ChatMessage.newBuilder()
                    .setSender("Server")
                    .setContent("Connected to ChatServer")
                    .build();
            responseObserver.onNext(connectMessage);

            // Continuously listen for incoming messages from the client
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 50051; // Default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ChatServer server = new ChatServer(port);
        server.start();

        // Wait for server to terminate
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        try {
            server.server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}