package com.kudl.sidekick.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.kudl.sidekick.config.AWSCustomProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SDKMessageSender implements MessageSender {

	private final AmazonSQS amazonSQS;
	private final AWSCustomProperties AWSCustomProperties;
	private final int DEFAULT_DELAY_SECONDS = 5;

	public SDKMessageSender(final AmazonSQS amazonSQS, final AWSCustomProperties AWSCustomProperties) {
		this.amazonSQS = amazonSQS;
		this.AWSCustomProperties = AWSCustomProperties;
	}

	@Override
	public List<Message> findAll() {
		return amazonSQS.receiveMessage(AWSCustomProperties.getSqsUrl()).getMessages();
	}

	@Override
	public SendMessageResult send(final String messageBody) {
		// Send Message to the queue
		final SendMessageRequest sendMessageRequest = new SendMessageRequest()
				.withQueueUrl(AWSCustomProperties.getSqsUrl())
				.withMessageBody(messageBody)
				.withDelaySeconds(DEFAULT_DELAY_SECONDS);
		return amazonSQS.sendMessage(sendMessageRequest);
	}

	@Override
	public DeleteMessageResult delete(final String receiptHandle) {
		return amazonSQS.deleteMessage(AWSCustomProperties.getSqsUrl(), receiptHandle);
	}
}
