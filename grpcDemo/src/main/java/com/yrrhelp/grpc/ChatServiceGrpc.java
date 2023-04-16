package com.yrrhelp.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: user.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.yrrhelp.grpc.User.ChatMessage.class,
      responseType = com.yrrhelp.grpc.User.ChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatResponse> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatService", "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("SendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatResponse> getLikeMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LikeMessage",
      requestType = com.yrrhelp.grpc.User.ChatMessage.class,
      responseType = com.yrrhelp.grpc.User.ChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatResponse> getLikeMessageMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatResponse> getLikeMessageMethod;
    if ((getLikeMessageMethod = ChatServiceGrpc.getLikeMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getLikeMessageMethod = ChatServiceGrpc.getLikeMessageMethod) == null) {
          ChatServiceGrpc.getLikeMessageMethod = getLikeMessageMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatService", "LikeMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("LikeMessage"))
                  .build();
          }
        }
     }
     return getLikeMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatMessage> getReceiveMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveMessage",
      requestType = com.yrrhelp.grpc.User.ChatMessage.class,
      responseType = com.yrrhelp.grpc.User.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage,
      com.yrrhelp.grpc.User.ChatMessage> getReceiveMessageMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatMessage> getReceiveMessageMethod;
    if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
          ChatServiceGrpc.getReceiveMessageMethod = getReceiveMessageMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.grpc.User.ChatMessage, com.yrrhelp.grpc.User.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatService", "ReceiveMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.grpc.User.ChatMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("ReceiveMessage"))
                  .build();
          }
        }
     }
     return getReceiveMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    return new ChatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void likeMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLikeMessageMethod(), responseObserver);
    }

    /**
     */
    public void receiveMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yrrhelp.grpc.User.ChatMessage,
                com.yrrhelp.grpc.User.ChatResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getLikeMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yrrhelp.grpc.User.ChatMessage,
                com.yrrhelp.grpc.User.ChatResponse>(
                  this, METHODID_LIKE_MESSAGE)))
          .addMethod(
            getReceiveMessageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.yrrhelp.grpc.User.ChatMessage,
                com.yrrhelp.grpc.User.ChatMessage>(
                  this, METHODID_RECEIVE_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void likeMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLikeMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveMessage(com.yrrhelp.grpc.User.ChatMessage request,
        io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yrrhelp.grpc.User.ChatResponse sendMessage(com.yrrhelp.grpc.User.ChatMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.yrrhelp.grpc.User.ChatResponse likeMessage(com.yrrhelp.grpc.User.ChatMessage request) {
      return blockingUnaryCall(
          getChannel(), getLikeMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.yrrhelp.grpc.User.ChatMessage> receiveMessage(
        com.yrrhelp.grpc.User.ChatMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getReceiveMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yrrhelp.grpc.User.ChatResponse> sendMessage(
        com.yrrhelp.grpc.User.ChatMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yrrhelp.grpc.User.ChatResponse> likeMessage(
        com.yrrhelp.grpc.User.ChatMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getLikeMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_LIKE_MESSAGE = 1;
  private static final int METHODID_RECEIVE_MESSAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.yrrhelp.grpc.User.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse>) responseObserver);
          break;
        case METHODID_LIKE_MESSAGE:
          serviceImpl.likeMessage((com.yrrhelp.grpc.User.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatResponse>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGE:
          serviceImpl.receiveMessage((com.yrrhelp.grpc.User.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.grpc.User.ChatMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yrrhelp.grpc.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getLikeMessageMethod())
              .addMethod(getReceiveMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
