package it.nextdevs.mattina.Bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Scuola {

    private String nome;

    @Autowired
    @Qualifier("aula1")
    private Aula aula;

}
