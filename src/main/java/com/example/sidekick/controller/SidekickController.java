package com.example.sidekick.controller;

import com.example.sidekick.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SidekickController {

	private final AppProperties.App appProperties;

	public SidekickController(AppProperties.App appProperties) {
		this.appProperties = appProperties;
	}

	@GetMapping
	public String getProperties() {
		return String.format("Name : " + appProperties.getName() + " ReadTimeout : " + appProperties.getReadTimeout());
	}
}
