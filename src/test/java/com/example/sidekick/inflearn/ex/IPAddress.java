package com.example.sidekick.inflearn.ex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class IPAddress {

	public static void main(String[] args) {
		String[] ip_address = {"123.022.123.123", "1.000.1.12", "119.123.45.39", "127.0.0.1"};
		String[] registered_list = {"119.123.45.39"};
		String[] banned_list = {"1.1.1.12"};

//		String[] ip_address = {"115.86.56.15", "123.12.2.1.", "...", "255.255.1.256"};
//		String[] registered_list = {"115.86.56.15"};
//		String[] banned_list = {"123.12.2.1"};

		int[] a = new IPAddress().solution(ip_address, registered_list, banned_list);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}


	private int[] solution(String[] ip_address, String[] registered_list, String[] banned_list) {
		int[] answer = new int[ip_address.length];

		List<String> registeredGroup = Arrays.asList(registered_list);
		List<String> bannedGroup = Arrays.asList(banned_list);

		for (int i = 0; i < ip_address.length; i++) {
			if (!Pattern.matches("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}", ip_address[i])) {
				answer[i] = 1;
			} else if (registeredGroup.contains(ip_address[i])) {
				answer[i] = 0;
			} else if (bannedGroup.contains(ip_address[i])) {
				answer[i] = 3;
			} else {
				answer[i] = 2;
			}
		}

		return answer;
	}
}
