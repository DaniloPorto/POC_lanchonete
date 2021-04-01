package br.com.gestac.gestac.pessoas.cliente.application;

import br.com.gestac.gestac.pessoas.cliente.domain.Cliente;
import br.com.gestac.gestac.pessoas.cliente.domain.ClienteService;
import br.com.gestac.gestac.util.business.exception.BusinessException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<?> incluir(@RequestBody Cliente cliente) throws BusinessException {
        Cliente clienteResponse = clienteService.incluir(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = clienteService.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPorId(@PathVariable Long id) throws BusinessException {
        clienteService.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
