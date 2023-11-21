package br.edu.ifgoiano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.entity.Medico;
import br.edu.ifgoiano.repository.MedicoRepository;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@PostMapping
	public void cadastrar(@RequestBody Medico medico) {
		this.medicoRepository.save(medico);
	}
}
