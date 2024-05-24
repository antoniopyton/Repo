package it.nextdevs.progettoSettimanale.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.progettoSettimanale.DTO.DipendenteDto;
import it.nextdevs.progettoSettimanale.exceptions.DipendenteNonTrovatoException;
import it.nextdevs.progettoSettimanale.model.Dipendente;
import it.nextdevs.progettoSettimanale.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setEmail(dipendenteDto.getEmail());
        sendMail(dipendente.getEmail());

        dipendenteRepository.save(dipendente);
        return "Autore salvato con successo con id: " + dipendente.getId();
    }

    public List<Dipendente> getDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> getDipendenteById(int id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);
        if (dipendenteOpt.isPresent()) {
            Dipendente dipendente = dipendenteOpt.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setUsername(dipendenteDto.getUsername());
            return dipendenteRepository.save(dipendente);
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato con id: " + id);
        }
    }

    public String patchImmagineDipendente(int id, MultipartFile foto) throws IOException, DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(id);

        if (dipendenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setImmagineProfilo(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente aggiornato correttamente e Immagine profilo inviata con id: " + id;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato con matricola: " + id);
        }
    }

    public String eliminaDipendente(int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);

        if (dipendenteOpt.isPresent()) {
            dipendenteRepository.delete(dipendenteOpt.get());
            return "Dipendente eliminato con successo con id: " + id;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato con id: " + id);
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Dipendente rest");
        message.setText("Registrazione Dipendente avvenuta con successo");

        javaMailSender.send(message);
    }

}
