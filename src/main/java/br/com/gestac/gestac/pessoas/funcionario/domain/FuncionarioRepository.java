package br.com.gestac.gestac.pessoas.funcionario.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
