package br.com.lanchonete.pedido.domain;

import br.com.lanchonete.commons.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido incluir(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido alterar(Pedido pedido) throws BusinessException {
        Pedido pedidoOld = buscarPorId(pedido.getId());
        pedidoOld.setItensPedido(pedido.getItensPedido());
        pedidoOld.setDescricaoDaEntrega(pedido.getDescricaoDaEntrega());
        pedidoOld.setTipoDeEntrega(pedido.getTipoDeEntrega());
        return pedidoOld;
    }

    public Pedido buscarPorId(Long idPedido) throws BusinessException {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);
        if(pedidoOptional.isEmpty()) {
            throw new BusinessException("Não existe pedido castrado com id " + idPedido);
        }
        return pedidoOptional.get();
    }
}
