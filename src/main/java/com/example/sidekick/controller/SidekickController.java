package com.example.sidekick.controller;

import com.example.sidekick.common.SidekickConstant;
import com.example.sidekick.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.sidekick.common.SidekickConstant.URL.SIDEKIQ;

@RestController
@RequestMapping(SidekickConstant.URL.BASE)
public class SidekickController {

	private final AppProperties.App appProperties;

	public SidekickController(AppProperties.App appProperties) {
		this.appProperties = appProperties;
	}

	@GetMapping
	public String getProperties() {
		return String.format("Name : " + appProperties.getName() + " ReadTimeout : " + appProperties.getReadTimeout());
	}

	@GetMapping(value = SIDEKIQ)
	public String getSidekiq() {
		return "Get Sidekiq";
	}

	@PostMapping(value = SIDEKIQ)
	public String createSidekiq() {
		return "Created Sidekiq";
	}
}
