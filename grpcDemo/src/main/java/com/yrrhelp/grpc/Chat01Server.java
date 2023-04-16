package com.yrrhelp.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Chat01Server {
    private final int port;
    private final Server server;
    private final Map<String, StreamObserver<User.ChatMessage>> clients = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> messageLikes = new ConcurrentHashMap<>();

    public Chat01Server(int port) {
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
            String content = request.getContent();

            // Broadcast the message to all connected clients
            for (StreamObserver<User.ChatMessage> client : clients.values()) {
                client.onNext(request);
            }

            //
            // Add the message to the messageLikes map with initial like count of 0
            messageLikes.put(sender + content, new AtomicInteger(0));

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
            String key = content;

            // Check if the message exists in the messageLikes map
            if (!messageLikes.containsKey(key)) {
                User.ChatResponse response = User.ChatResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Message not found")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            AtomicInteger likeCount = messageLikes.get(key);

            // Increase the like count by 1
            likeCount.incrementAndGet();

            // Check if the like count is greater than or equal to 2
            if (likeCount.get() <= 2) {
                // Broadcast the liked message to all connected clients
                for (StreamObserver<User.ChatMessage> client : clients.values()) {
                    client.onNext(request);
                }

                // Remove the message from the messageLikes map
                messageLikes.remove(key);
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

        Chat01Server server = new Chat01Server(port);
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