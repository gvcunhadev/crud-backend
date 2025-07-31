package backend.com.infraestructure.api;

import backend.com.application.AgendamentoConsultaService;
import backend.com.domain.agendamento.AgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoConsultaController {

    private final AgendamentoConsultaService service;

    @Autowired
    public AgendamentoConsultaController(AgendamentoConsultaService service) {
        this.service = service;
    }


    @PostMapping
    public AgendamentoConsulta criarAgendamento(@RequestBody AgendamentoConsulta agendamento) {
        return service.criar(agendamento);
    }


    @GetMapping
    public List<AgendamentoConsulta> buscarTodos() {
        return service.buscarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoConsulta> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoConsulta> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoConsulta agendamentoAtualizado) {
        try {
            AgendamentoConsulta agendamento = service.atualizar(id, agendamentoAtualizado);
            return ResponseEntity.ok(agendamento);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

