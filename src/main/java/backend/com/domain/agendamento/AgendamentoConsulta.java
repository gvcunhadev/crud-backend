package backend.com.domain.agendamento;

import backend.com.domain.valueObject.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;
    private String profissional;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private String endereco;
    private LocalDate data;
    private LocalTime hora;
}