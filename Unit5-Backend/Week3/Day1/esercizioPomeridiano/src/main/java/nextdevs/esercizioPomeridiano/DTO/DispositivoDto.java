package nextdevs.esercizioPomeridiano.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import nextdevs.esercizioPomeridiano.enums.StatoDispositivo;

@Data
public class DispositivoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    private StatoDispositivo statoDispositivo;

    private int dipendenteId;
}
