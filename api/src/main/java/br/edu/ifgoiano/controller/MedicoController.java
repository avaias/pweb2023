package br.edu.ifgoiano.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	@PostMapping
	public void cadastrar(String medico) {
		System.out.println(medico);
	}
}
