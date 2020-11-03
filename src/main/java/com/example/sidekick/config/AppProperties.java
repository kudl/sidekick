package com.example.sidekick.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(AppProperties.App.class)
public class AppProperties {

	@ConfigurationProperties(prefix = "app")
	public static class App {
		private String name;
		private String description;
		private String uploadDir;
		private Duration connectTimeout = Duration.ofMillis(1000);
		@DurationUnit(ChronoUnit.SECONDS)
		private Duration readTimeout = Duration.ofSeconds(30);
		private final Security security = new Security();

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getUploadDir() {
			return uploadDir;
		}

		public Duration getConnectTimeout() {
			return connectTimeout;
		}

		public Duration getReadTimeout() {
			return readTimeout;
		}

		public Security getSecurity() {
			return security;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setUploadDir(String uploadDir) {
			this.uploadDir = uploadDir;
		}

		public void setConnectTimeout(Duration connectTimeout) {
			this.connectTimeout = connectTimeout;
		}

		public void setReadTimeout(Duration readTimeout) {
			this.readTimeout = readTimeout;
		}

		public static class Security {
			private String username;
			private String password;
			private List<String> roles = new ArrayList<>();
			private boolean enabled;
			private Map<String, String> permissions = new HashMap<>();

			public String getUsername() {
				return username;
			}

			public String getPassword() {
				return password;
			}

			public List<String> getRoles() {
				return roles;
			}

			public boolean isEnabled() {
				return enabled;
			}

			public Map<String, String> getPermissions() {
				return permissions;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public void setRoles(List<String> roles) {
				this.roles = roles;
			}

			public void setEnabled(boolean enabled) {
				this.enabled = enabled;
			}

			public void setPermissions(Map<String, String> permissions) {
				this.permissions = permissions;
			}
		}
	}
}