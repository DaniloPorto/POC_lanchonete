package br.com.gestac.gestac.produto.tipo.application;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.produto.tipo.domain.TipoProduto;
import br.com.gestac.gestac.produto.tipo.domain.TipoProdutoForm;
import br.com.gestac.gestac.produto.tipo.domain.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipoProduto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @PostMapping("/incluir")
    private ResponseEntity<BusinessResponseEntity> incluir(@RequestBody @Valid TipoProdutoForm tipoProdutoForm) throws BusinessException {
        tipoProdutoService.incluir(tipoProdutoForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Tipo de produto incluído com sucesso!");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<BusinessResponseEntity> atualizar(@RequestBody @Valid TipoProdutoForm tipoProdutoForm) throws BusinessException {
        TipoProduto tipoProduto = tipoProdutoService.atualizar(tipoProdutoForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess(tipoProduto, "Tipo de produto atualizado com sucesso!");
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<BusinessResponseEntity> excluirPorId(@RequestParam Long idTipoProduto) throws BusinessException {
        tipoProdutoService.excluirPorId(idTipoProduto);
        return BusinessResponseEntityFactory.getResponseSucess("Tipo de produto excluído com secusso!");
    }

    @GetMapping("/selecionar/todos")
    public ResponseEntity<BusinessResponseEntity> buscarTodos() {
        List<TipoProduto> listTipo = tipoProdutoService.buscarTodos();
        return BusinessResponseEntityFactory.getResponseSucess(listTipo);
    }

    @GetMapping("/selecionar")
    public ResponseEntity<BusinessResponseEntity> buscarPorId(@RequestParam Long idTipoProduto) throws BusinessException {
        TipoProduto tipoProduto = tipoProdutoService.buscarTipoPorId(idTipoProduto);
        return BusinessResponseEntityFactory.getResponseSucess(tipoProduto);
    }
}
