package br.com.gestac.gestac.pessoas.funcionario.cargo.domain;

import br.com.gestac.gestac.pessoas.funcionario.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
