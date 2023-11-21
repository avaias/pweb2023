package br.edu.ifgoiano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoiano.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
