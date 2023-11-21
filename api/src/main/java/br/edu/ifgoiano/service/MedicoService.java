package br.edu.ifgoiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifgoiano.entity.Medico;
import br.edu.ifgoiano.repository.MedicoRepository;

public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public void cadastrar(Medico medico) {
		this.medicoRepository.save(medico);
	}
	
	public List<Medico> listar(){
		return this.medicoRepository.findAll();
	}
	
	public void atualizar(Medico medico) {
		Medico medicoBase = this.medicoRepository.getReferenceById(medico.getId());
		
		if(medico.getNome() != null) {
			medicoBase.setNome(medico.getNome());
		}
		if(medico.getCrm() != null) {
			medicoBase.setCrm(medico.getCrm());
		}
		
		this.medicoRepository.save(medicoBase);
	}
	
	public void excluir(Long id) {
		this.medicoRepository.deleteById(id);
	}
}
