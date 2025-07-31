package backend.com.application;
import backend.com.domain.agendamento.AgendamentoConsulta;
import backend.com.domain.agendamento.AgendamentoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoConsultaService {

    private final AgendamentoConsultaRepository repository;

    @Autowired
    public AgendamentoConsultaService(AgendamentoConsultaRepository repository) {
        this.repository = repository;
    }


    public AgendamentoConsulta criar(AgendamentoConsulta novoAgendamento) {
        return repository.save(novoAgendamento);
    }


    public Optional<AgendamentoConsulta> buscarPorId(Long id) {
        return repository.findById(id);
    }


    public List<AgendamentoConsulta> buscarTodos() {
        return repository.findAll();
    }


    public AgendamentoConsulta atualizar(Long id, AgendamentoConsulta agendamentoAtualizado) {
        return repository.findById(id)
                .map(agendamento -> {
                    agendamento.setMotivo(agendamentoAtualizado.getMotivo());
                    agendamento.setProfissional(agendamentoAtualizado.getProfissional());
                    agendamento.setEspecialidade(agendamentoAtualizado.getEspecialidade());
                    agendamento.setEndereco(agendamentoAtualizado.getEndereco());
                    agendamento.setData(agendamentoAtualizado.getData());
                    agendamento.setHora(agendamentoAtualizado.getHora());
                    return repository.save(agendamento);
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }
}