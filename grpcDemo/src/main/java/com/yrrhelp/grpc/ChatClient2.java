package com.yrrhelp.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChatClient2 {
    private final String name;
    private final String serverAddress;
    private final int serverPort;
    private ManagedChannel channel;
    private ChatServiceGrpc.ChatServiceStub asyncStub;
    private StreamObserver<User.ChatMessage> responseObserver;
    private ChatServiceGrpc.ChatServiceBlockingStub blockingStub;
    private boolean isRunning;

    public ChatClient2(String name, String serverAddress, int serverPort) {
        this.name = name;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;

        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        // Create an async stub for the ChatService
        asyncStub = ChatServiceGrpc.newStub(channel);
        blockingStub = ChatServiceGrpc.newBlockingStub(channel);
        isRunning = true;
    }

    public void connect() {
        // Create a stream observer to receive messages from the server
        responseObserver = new StreamObserver<User.ChatMessage>() {
            @Override
            public void onNext(User.ChatMessage message) {
                String sender = message.getSender();
                String content = message.getContent();
                System.out.println(sender + ": " + content);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server disconnected");
            }
        };

        // Send a connection request to the server
        User.ChatMessage connectMessage = User.ChatMessage.newBuilder()
                .setSender(name)
                .setContent("Connect to ChatServer")
                .build();
        asyncStub.receiveMessage(connectMessage, responseObserver);
    }

    public void sendMessage(String content) {
        // Send a message to the server
        User.ChatMessage message = User.ChatMessage.newBuilder()
                .setSender(name)
                .setContent(content)
                .build();
        asyncStub.sendMessage(message, new StreamObserver<User.ChatResponse>() {
            @Override
            public void onNext(User.ChatResponse response) {
                boolean success = response.getSuccess();
                String message = response.getMessage();
                System.out.println("Sent: " + message);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Do nothing
            }
        });
    }

    public void likeMessage(String content) {
        // Send a like request to the server
        User.ChatMessage message = User.ChatMessage.newBuilder()
                .setSender(name)
                .setContent(content)
                .build();
        asyncStub.likeMessage(message, new StreamObserver<User.ChatResponse>() {
            @Override
            public void onNext(User.ChatResponse response) {
                boolean success = response.getSuccess();
                String message = response.getMessage();
                System.out.println("Liked: " + message);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Do nothing
            }
        });
    }

    public void disconnect() {
        // Send a disconnect request to the server
        User.ChatMessage disconnectMessage = User.ChatMessage.newBuilder()
                .setSender(name)
                .setContent("Disconnect from ChatServer")
                .build();
        asyncStub.sendMessage(disconnectMessage, new StreamObserver<User.ChatResponse>() {
            @Override
            public void onNext(User.ChatResponse response) {
                boolean success = response.getSuccess();
                String message = response.getMessage();
                System.out.println("Sent: " + message);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Do nothing
            }
        });
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error occurred while shutting down the channel: " + e.getMessage());
        }
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter server address: ");
        String serverAddress = scanner.nextLine();

        System.out.print("Enter server port: ");
        int serverPort = scanner.nextInt();

        ChatClient2 client = new ChatClient2(name, serverAddress, serverPort);
        client.connect();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Send message");
            System.out.println("2. Like message");
            System.out.println("3. Disconnect");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    client.sendMessage(content);
                    break;
                case 2:
                    System.out.print("Enter message content to like: ");
                    String likeContent = scanner.nextLine();
                    client.likeMessage(likeContent);
                    break;
                case 3:
                    client.disconnect();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close the scanner and disconnect from the server
        scanner.close();
        client.shutdown();
    }
}