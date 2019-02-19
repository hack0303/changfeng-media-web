package com.creating.www.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/x")
public class AController {
@GetMapping("/x")
public ResponseEntity<String> get() {
	//return ResponseEntity.ok().eTag("Content-Type:text/html;charset=UTF-8").body("呵呵");
	return ResponseEntity.ok().contentType(MediaType.valueOf("text/html;charset=UTF-8")).body("呵呵");
}
}
