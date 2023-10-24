package br.edu.ifgoiano.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.entity.Medico;


@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@PostMapping
	public void cadastrar(@RequestBody Medico medico) {
		System.out.println(medico.getNome());
	}
}
