package com.creating.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/x")
public class AController {
@GetMapping("/x")
@ResponseBody
public String get() {
	return "xyz";
}
}
