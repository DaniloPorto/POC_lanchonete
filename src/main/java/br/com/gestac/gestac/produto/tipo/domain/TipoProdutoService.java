package br.com.gestac.gestac.produto.tipo.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;
import java.util.List;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Transactional
    public TipoProduto incluir(TipoProduto tipoProduto) throws BusinessException {

        if (Objects.isNull(tipoProduto)) {
            throw new BusinessException("Objeto tipo produto não pode ser nulo.");
        }
        return tipoProdutoRepository.save(tipoProduto);
    }

    @Transactional
    public void excluirPorId(Long idTipoProduto) throws BusinessException {
        TipoProduto tipo = buscarTipoPorId(idTipoProduto);;
        tipoProdutoRepository.delete(tipo);
    }

    @Transactional
    public TipoProduto atualizar(TipoProduto tipoProduto) throws BusinessException {
        TipoProduto tipoProdutoOld = buscarTipoPorId(tipoProduto.getId());
        tipoProdutoOld.setDescricao(tipoProduto.getDescricao());
        tipoProdutoOld.setFlagPerecivel(tipoProduto.getFlagPerecivel());
        tipoProdutoOld.setFlagValidade(tipoProduto.getFlagValidade());

        return tipoProdutoOld;
    }

    public TipoProduto buscarTipoPorId(Long idTipoProduto) throws BusinessException {
        Optional<TipoProduto> tipoOptional = tipoProdutoRepository.findById(idTipoProduto);
        if (tipoOptional.isEmpty()) {
            throw new BusinessException("Não foi possível encontrar um tipo de produto com ID: " + idTipoProduto);
        }
        return tipoOptional.get();
    }

    public List<TipoProduto> buscarTodos() {
        return tipoProdutoRepository.findAll();
    }
}
