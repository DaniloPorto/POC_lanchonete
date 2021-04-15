package br.com.gestac.gestac.pessoas.funcionario.cargo.application;

import br.com.gestac.gestac.pessoas.funcionario.cargo.domain.Cargo;
import br.com.gestac.gestac.pessoas.funcionario.cargo.domain.CargoService;
import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping("/")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody Cargo cargo) throws BusinessException {
        cargoService.incluir(cargo);
        return BusinessResponseEntityFactory.getResponseSucess();
    }

}
