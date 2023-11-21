package br.edu.ifgoiano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.entity.Medico;
import br.edu.ifgoiano.repository.MedicoRepository;
import br.edu.ifgoiano.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@PostMapping
	public void cadastrar(@RequestBody Medico medico) {
		this.medicoService.cadastrar(medico);
	}
	
	@GetMapping
	public List<Medico> listar(){
		return this.medicoService.listar();
	}
	
	@PutMapping
	public void atualizar(@RequestBody Medico medico) {
		this.medicoService.atualizar(medico);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		this.medicoService.excluir(id);
	}
}
