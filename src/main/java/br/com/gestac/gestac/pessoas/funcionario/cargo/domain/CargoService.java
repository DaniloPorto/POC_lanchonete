package br.com.gestac.gestac.pessoas.funcionario.cargo.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CargoService {

    private CargoRepository cargoRepository;

    @Transactional
    public Cargo incluir(Cargo cargo) throws BusinessException {
        try {
            Validation().valid();
            return cargoRepository.save(cargo);
        }catch(Exception e) {
            throw new BusinessException("Erro ao tentar incluir um cargo", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    public void excluirPorId(Long IdCargo) {
        cargoRepository.deleteById(IdCargo);
    }
}
