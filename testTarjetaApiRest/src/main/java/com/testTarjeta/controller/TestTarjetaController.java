package com.testTarjeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestTarjetaController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/mostarTarjeta")
	public String mostarTarjeta() {
		return "mostarTarjeta";
	}
}
