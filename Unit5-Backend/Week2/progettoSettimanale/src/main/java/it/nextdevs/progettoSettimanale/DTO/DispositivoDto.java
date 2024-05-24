package it.nextdevs.progettoSettimanale.DTO;

import it.nextdevs.progettoSettimanale.enums.StatoDispositivo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DispositivoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    private StatoDispositivo statoDispositivo;

    private int dipendenteId;
}
