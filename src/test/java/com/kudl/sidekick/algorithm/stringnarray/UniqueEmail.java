package com.kudl.sidekick.algorithm.stringnarray;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueEmail {

	public static void main(final String[] args) {
		final String[] emails = {
				"test.email+james@sample.com",
				"test.e.mail+toto@sample.com",
				"testemail+tom@sam.ple.com"
		};
		final int answer = 2; // "testemail@sample.com", "testemail@sam.ple.com"

		assertThat(new UniqueEmail().solution(emails)).isEqualTo(answer);
	}

	private int solution(final String[] emails) {
		final Set<String> uniqueEmail = new HashSet<>();

		for (final String email : emails) {
			final String localName = makeLocalName(email);
			final String domainName = makeDomainName(email);

			uniqueEmail.add(localName + "@" + domainName);
		}

		return uniqueEmail.size();
	}

	private String makeLocalName(final String email) {
		final var localName = new StringBuilder();

		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '.') {
				continue;
			}

			if (email.charAt(i) == '+' || email.charAt(i) == '@') {
				break;
			}

			localName.append(email.charAt(i));
		}

		return localName.toString();
	}

	private String makeDomainName(final String email) {
		return email.substring(email.indexOf('@') + 1);
	}
}
