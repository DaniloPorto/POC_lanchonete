package br.com.lanchonete.pedido.application;

import br.com.lanchonete.commons.business.BusinessResponseEntity;
import br.com.lanchonete.commons.business.BusinessResponseEntityFactory;
import br.com.lanchonete.commons.business.exception.BusinessException;
import br.com.lanchonete.pedido.domain.PedidoForm;
import br.com.lanchonete.pedido.domain.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody @Valid PedidoForm pedidoForm) {
        pedidoService.incluir(pedidoForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Pedido incluído com sucesso !");
    }

    @PutMapping("/alterar")
    public ResponseEntity<BusinessResponseEntity> alterar(@RequestBody @Valid PedidoForm pedidoForm) throws BusinessException {
        pedidoService.alterar(pedidoForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Pedido alterado com sucesso!");
    }
}
