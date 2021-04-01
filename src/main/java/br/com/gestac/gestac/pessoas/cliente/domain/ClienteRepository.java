package br.com.gestac.gestac.pessoas.cliente.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
