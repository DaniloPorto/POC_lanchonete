package br.com.gestac.gestac.produto.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.produto.estoque.domain.EstoqueProduto;
import br.com.gestac.gestac.produto.estoque.domain.EstoqueProdutoService;
import br.com.gestac.gestac.produto.tipo.domain.TipoProduto;
import br.com.gestac.gestac.produto.tipo.domain.TipoProdutoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @Autowired
    private EstoqueProdutoService estoqueProdutoService;

    @Transactional
    public Produto incluir(Produto produto) throws BusinessException {
        TipoProduto tipoProduto = tipoProdutoService.buscarTipoPorId(produto.getTipoProduto().getId());
        produto.setTipoProduto(tipoProduto);
        Produto novoProduto = produtoRepository.save(produto);

        List<EstoqueProduto> estoqueProdutoList = produto.getEstoqueProduto();
        estoqueProdutoList.stream().forEach(estoqueProduto -> estoqueProduto.setProduto(novoProduto));
        estoqueProdutoList = estoqueProdutoService.incluirLote(estoqueProdutoList);

        novoProduto.setEstoqueProduto(estoqueProdutoList);
        return novoProduto;
    }

    @Transactional
    public void excluirPorCodigo(String codigoProduto) throws BusinessException {
        buscarPorCodigo(codigoProduto);
        produtoRepository.deleteById(codigoProduto);
    }

    public Produto buscarPorCodigo(String codigoProduto) throws BusinessException {
        if (Strings.isEmpty(codigoProduto)) {
            throw new BusinessException("Código do Produto não pode ser nulo ou vazio");
        }

        Optional<Produto> produtoOptional = produtoRepository.findById(codigoProduto);
        if (produtoOptional.isEmpty()) {
            throw new BusinessException("Produto com o código " + codigoProduto + " não encontrado.");
        }
        return produtoOptional.get();
    }

    public Page<Produto> buscarTodosComPaginacao(Pageable paginacao) {
        return produtoRepository.findAll(paginacao);
    }
}
