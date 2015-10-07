package com.univision.deportes.services.sqs;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.univision.deportes.AlertMessage;

import java.util.List;

/**
 * Created by jbjohn on 10/7/15.
 */
public class QueueService {
    /**
     * write to queue
     * check pending items in queue
     * priority settings
     * read from queue
     */

    private static AmazonSQS sqs;
    private BasicAWSCredentials credentials;
    private String queueUrl = "https://sqs.us-east-1.amazonaws.com/627758403665/sports-uvn-notification-push-api";

    QueueService() {
        this.credentials = new BasicAWSCredentials("accessKey", "secretKey");
        this.sqs = new AmazonSQSClient(this.credentials);
    }

    public void process() {
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setTitle("test");
        System.out.println(this.sqs.sendMessage(queueUrl, alertMessage.toString()));
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> messageList = this.sqs.receiveMessage(receiveMessageRequest).getMessages();
        System.out.println(messageList);
        for (Message message : messageList) {
            System.out.println(message);
            String messageRecieptHandle = message.getReceiptHandle();
            DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest(queueUrl, messageRecieptHandle);
            this.sqs.deleteMessage(deleteMessageRequest);
        }
    }
}
