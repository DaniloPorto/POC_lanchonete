package br.com.gestac.gestac.produto.application;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.produto.domain.Produto;
import br.com.gestac.gestac.produto.domain.ProdutoForm;
import br.com.gestac.gestac.produto.domain.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody ProdutoForm produtoForm) throws BusinessException {
        produtoService.incluir(produtoForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess();
    }

    @DeleteMapping("/excluirPorCodigo")
    public ResponseEntity<BusinessResponseEntity> excluir(@RequestParam String codigoProduto) throws BusinessException {
        produtoService.excluirPorCodigo(codigoProduto);
        return BusinessResponseEntityFactory.getResponseSucess();
    }

    @GetMapping("/selecionar/codigo")
    public ResponseEntity<BusinessResponseEntity> buscarPorCodigo(@RequestParam String codigoProduto) throws BusinessException {
        Produto produto = produtoService.buscarPorCodigo(codigoProduto);
        return BusinessResponseEntityFactory.getResponseSucess(produto);
    }

    @GetMapping("/selecionar/todos")
    public ResponseEntity<BusinessResponseEntity> buscarTodos(@RequestParam int pagina, @RequestParam int qtdRegistros) {
        Page page = produtoService.buscarTodosComPaginacao(PageRequest.of(pagina, qtdRegistros));
        return BusinessResponseEntityFactory.getResponseSucess(page);
    }
}
