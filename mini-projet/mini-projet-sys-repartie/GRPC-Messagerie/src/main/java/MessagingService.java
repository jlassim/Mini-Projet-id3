import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MessagingService extends MessagingServiceGrpc.MessagingServiceImplBase{
    private final Map<String, List<String>> userMessages = new HashMap<>();

    @Override
    public void sendMessage(Message.SendMessageRequest request,
                            StreamObserver<Message.SendMessageResponse> responseObserver)
    {
        String recipient = request.getRecipient();
        String message = request.getMessage();
        userMessages.computeIfAbsent(recipient, k -> new ArrayList<>()).add(message);
        responseObserver.onNext(Message.SendMessageResponse.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();

    }
    @Override
    public void getMessages(Message.GetMessagesRequest request,
                            StreamObserver<Message.GetMessagesResponse> responseObserver) {
        String user = request.getUser();
        List<String> messages = userMessages.getOrDefault(user, Collections.emptyList());
        responseObserver.onNext(Message.GetMessagesResponse.newBuilder().addAllMessages(messages).build());
        responseObserver.onCompleted();



    }
    public static void main(String [] args) throws IOException, InterruptedException
    {
        Server server = ServerBuilder.forPort(1001)
                .addService(new MessagingService())
                .build()
                .start();
        System.out.println("Server listening on port 1000...");
        server.awaitTermination();
    }
}