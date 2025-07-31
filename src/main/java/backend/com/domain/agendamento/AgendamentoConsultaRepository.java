package backend.com.domain.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgendamentoConsultaRepository extends JpaRepository<AgendamentoConsulta, Long> {
}