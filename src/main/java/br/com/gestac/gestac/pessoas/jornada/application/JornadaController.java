package br.com.gestac.gestac.pessoas.jornada.application;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.pessoas.jornada.domain.Jornada;
import br.com.gestac.gestac.pessoas.jornada.domain.JornadaForm;
import br.com.gestac.gestac.pessoas.jornada.domain.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("jornada")
public class JornadaController {

    @Autowired
    private JornadaService jornadaService;

    @PostMapping("/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@RequestBody @Valid JornadaForm jornadaForm) throws BusinessException {
        jornadaService.incluir(jornadaForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess("Jornada incluída com sucesso!");
    }

    @DeleteMapping("/excluir/{idJornada}")
    public ResponseEntity<BusinessResponseEntity> excluir(@PathVariable Long idJornada) throws BusinessException {
        jornadaService.excluirPorId(idJornada);
        return BusinessResponseEntityFactory.getResponseSucess("Jornada excluída com sucesso!");
    }

    @GetMapping("/todas")
    public ResponseEntity<BusinessResponseEntity> buscarTodos() {
        List<Jornada> jornadas = jornadaService.buscarTodas();
        return BusinessResponseEntityFactory.getResponseSucess(jornadas);
    }
}
