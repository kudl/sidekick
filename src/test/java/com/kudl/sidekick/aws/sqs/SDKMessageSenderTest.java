package com.kudl.sidekick.aws.sqs;

import com.amazonaws.AmazonWebServiceResult;
import com.amazonaws.services.sqs.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SDKMessageSenderTest {

	@Autowired
	MessageSender messageSender;

	@Test
	void sendTest() {
		final String message = "hello world";

		final var sendMessageResult = messageSender.send(message);

		assertThat(sendMessageResult.getSdkHttpMetadata().getHttpStatusCode()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	void findAllThenDeleteTest() {
		// receive messages from the queue
		final List<Message> messages = messageSender.findAll();

		// delete messages from the queue
		for (final Message m : messages) {
			System.out.println(m);

			final AmazonWebServiceResult serviceResult = messageSender.delete(m.getReceiptHandle());
			assertThat(serviceResult.getSdkHttpMetadata().getHttpStatusCode()).isEqualTo(HttpStatus.OK.value());
		}
	}
}
