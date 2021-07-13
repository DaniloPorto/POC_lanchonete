package br.com.gestac.gestac.produto.estoque.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.produto.domain.Produto;
import br.com.gestac.gestac.produto.domain.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;

@Service
public class EstoqueProdutoService {

    @Autowired
    private EstoqueProdutoRepository estoqueProdutoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public EstoqueProduto incluir(EstoqueProduto estoqueProduto) {
        return estoqueProdutoRepository.save(estoqueProduto);
    }

    @Transactional
    public List<EstoqueProduto> incluirLote(List<EstoqueProduto> estoqueProdutos) {
        return estoqueProdutoRepository.saveAll(estoqueProdutos);
    }

    @Transactional
    public EstoqueProduto atualizar(EstoqueProduto estoqueProduto) throws BusinessException {
        EstoqueProduto estoqueProdutoOld = buscarEstoquePorId(estoqueProduto.getId());

        estoqueProdutoOld.setProduto(estoqueProduto.getProduto());
        estoqueProdutoOld.setDataCompra(estoqueProduto.getDataCompra());
        estoqueProdutoOld.setDataVencimento(estoqueProduto.getDataVencimento());
        estoqueProdutoOld.setNumeroLote(estoqueProduto.getNumeroLote());
        estoqueProdutoOld.setPrecoCompra(estoqueProduto.getPrecoCompra());

        return estoqueProdutoOld;
    }

    @Transactional
    public void excluirPorId(Long idEstoque) throws BusinessException {
        EstoqueProduto estoqueProduto = buscarEstoquePorId(idEstoque);
        estoqueProdutoRepository.deleteById(idEstoque);
    }

    public EstoqueProduto buscarEstoquePorId(Long idEstoque) throws BusinessException {
        if (null == idEstoque || idEstoque == 0) {
            throw new BusinessException("O ID do estoque não pode ser nulo");
        }
        Optional<EstoqueProduto> estoqueOptional = estoqueProdutoRepository.findById(idEstoque);
        if (estoqueOptional.isEmpty()) {
            throw new BusinessException("Não foi possível encontrar um estoque com ID " + idEstoque);
        }
        return estoqueOptional.get();
    }

    public List<EstoqueProduto> buscarPorCodigoProduto(String codigoProduto) throws BusinessException {
        Produto produto = produtoService.buscarPorCodigo(codigoProduto);
        List<EstoqueProduto> estoqueProdutoList = estoqueProdutoRepository.buscarEstoquePorIdProduto(produto.getCodigo());

        if (null == estoqueProdutoList || estoqueProdutoList.isEmpty()) {
            throw new BusinessException("Não existe estoque cadastrado para o produto " + produto.getDescricao() + " código " + produto.getCodigo());
        }

        return estoqueProdutoList;
    }
}
