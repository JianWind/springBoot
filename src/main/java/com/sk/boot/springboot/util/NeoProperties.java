package com.sk.boot.springboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {
	@Value("${com.sk.title}")
	private String title;
	@Value("${com.sk.description}")
	private String description;

	//省略getter settet方法

	}