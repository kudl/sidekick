package com.kudl.sidekick.aws;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.kudl.sidekick.config.AWSProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SQSSdkTest {

	@Autowired
	AmazonSQS amazonSQS;

	@Autowired
	AWSProperties awsProperties;

	@Test
	public void send() {
		// Send Message to the queue
		final SendMessageRequest sendMessageRequest = new SendMessageRequest()
				.withQueueUrl(awsProperties.getSqsUrl())
				.withMessageBody("hello world123")
				.withDelaySeconds(5);
		final SendMessageResult message = amazonSQS.sendMessage(sendMessageRequest);

		assertThat(message.getSdkHttpMetadata().getHttpStatusCode()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void sendMultiple() {
		// Send multiple messages to the queue
		final SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
				.withQueueUrl(awsProperties.getSqsUrl())
				.withEntries(
						new SendMessageBatchRequestEntry(
								"msg_1", "Hello from message 1"),
						new SendMessageBatchRequestEntry(
								"msg_2", "Hello from message 2")
								.withDelaySeconds(10));
		final SendMessageBatchResult sendMessageBatchResult = amazonSQS.sendMessageBatch(send_batch_request);

		assertThat(sendMessageBatchResult.getSdkHttpMetadata().getHttpStatusCode()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void deleteMessage() {
		// receive messages from the queue
		final List<Message> messages = amazonSQS.receiveMessage(awsProperties.getSqsUrl()).getMessages();

		// delete messages from the queue
		for (final Message m : messages) {
			System.out.println(m);

			amazonSQS.deleteMessage(awsProperties.getSqsUrl(), m.getReceiptHandle());
		}
	}
}
