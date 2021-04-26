package br.com.gestac.gestac.pessoas.funcionario.application;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.pessoas.funcionario.domain.FuncionarioForm;
import br.com.gestac.gestac.pessoas.funcionario.domain.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody FuncionarioForm  funcionarioForm) throws BusinessException {
        funcionarioService.incluir(funcionarioForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Funcionario incluído com sucesso!");
    }
}
