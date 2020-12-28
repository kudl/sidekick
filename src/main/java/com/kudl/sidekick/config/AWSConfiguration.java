package com.kudl.sidekick.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {

	private final AWSProperties awsProperties;

	public AWSConfiguration(final AWSProperties awsProperties) {
		this.awsProperties = awsProperties;
	}

	@Bean
	public AmazonSQS amazonSQS() {
		return AmazonSQSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(
										awsProperties.getCredentials().getAccessKey(),
										awsProperties.getCredentials().getSecretKey())
						)
				)
				.withRegion(Regions.AP_NORTHEAST_2)
				.build();
	}
}
