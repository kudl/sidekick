package com.kudl.sidekick.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties(AWSProperties.class)
@ConfigurationProperties(prefix = AWSProperties.PREFIX)
public class AWSProperties {
	static final String PREFIX = "cloud.aws";

	String sqsUrl;
	Credentials credentials;

	public String getSqsUrl() {
		return sqsUrl;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setSqsUrl(final String sqsUrl) {
		this.sqsUrl = sqsUrl;
	}

	public void setCredentials(final Credentials credentials) {
		this.credentials = credentials;
	}

	public static class Credentials {
		String accessKey;
		String secretKey;

		public String getAccessKey() {
			return accessKey;
		}

		public String getSecretKey() {
			return secretKey;
		}

		public void setAccessKey(final String accessKey) {
			this.accessKey = accessKey;
		}

		public void setSecretKey(final String secretKey) {
			this.secretKey = secretKey;
		}
	}
}
