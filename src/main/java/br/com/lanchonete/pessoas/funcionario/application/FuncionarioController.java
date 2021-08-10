package br.com.lanchonete.pessoas.funcionario.application;

import br.com.lanchonete.commons.business.BusinessResponseEntity;
import br.com.lanchonete.commons.business.BusinessResponseEntityFactory;
import br.com.lanchonete.commons.business.exception.BusinessException;
import br.com.lanchonete.pessoas.funcionario.domain.Funcionario;
import br.com.lanchonete.pessoas.funcionario.domain.FuncionarioForm;
import br.com.lanchonete.pessoas.funcionario.domain.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody FuncionarioForm funcionarioForm) throws BusinessException {
        funcionarioService.incluir(funcionarioForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Funcionario incluído com sucesso!");
    }

    @DeleteMapping("/excluir/{idFuncionario}")
    public ResponseEntity<BusinessResponseEntity> excluir(@PathVariable Long idFuncionario) throws BusinessException {
        funcionarioService.excluirPorId(idFuncionario);
        return BusinessResponseEntityFactory.getResponseSucess("Funcionario exclído com sucesso!");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<BusinessResponseEntity> atualizar(@RequestBody FuncionarioForm funcionarioForm) throws BusinessException {
        Funcionario funcionario = funcionarioService.atualizar(funcionarioForm);
        return BusinessResponseEntityFactory.getResponseSucess(funcionario, "Funcionario atualizado com sucesso!");
    }

    @GetMapping("/ID/{idFuncionario}")
    public ResponseEntity<BusinessResponseEntity> buscarPorId(@PathVariable Long idFuncionario) throws BusinessException {
        Funcionario funcionario = funcionarioService.buscarPorId(idFuncionario);
        return BusinessResponseEntityFactory.getResponseSucess(funcionario);
    }

    @GetMapping("/todos")
    public ResponseEntity<BusinessResponseEntity> buscarTodos() {
        List<Funcionario> funcionarios = funcionarioService.buscarTodos();
        return BusinessResponseEntityFactory.getResponseSucess(funcionarios);
    }
}
