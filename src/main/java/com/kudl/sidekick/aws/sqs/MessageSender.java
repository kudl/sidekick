package com.kudl.sidekick.aws.sqs;

import com.amazonaws.AmazonWebServiceResult;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;

public interface MessageSender<T extends AmazonWebServiceResult> {

	T send(String messageBody);

	T delete(String receiptHandle);

	List<Message> findAll();
}
