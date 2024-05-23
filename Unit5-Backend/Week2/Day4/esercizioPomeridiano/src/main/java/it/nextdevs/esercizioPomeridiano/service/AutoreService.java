package it.nextdevs.esercizioPomeridiano.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.esercizioPomeridiano.DTO.AutoreDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.repository.AutoreRepository;
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
public class AutoreService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setDataNascita(autoreDto.getDataNascita());
        autore.setEmail(autoreDto.getEmail());
        sendMail(autore.getEmail());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome());

       autoreRepository.save(autore);
       return "Autore salvato con successo con id: " + autore.getId();
    }

    public List<Autore> getAutori() {
        return autoreRepository.findAll();
    }

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }

    public Autore updateAutore(int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataNascita(autoreDto.getDataNascita());
            return autoreRepository.save(autore);
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + id);
        }
    }

    public String patchAvatarAutore(int id, MultipartFile foto) throws IOException, AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = autoreRepository.findById(id);

        if (autoreOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOptional.get();
            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Autore aggiornato correttamente e Avatar inviata con matricola: " + id;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con matricola: " + id);
        }
    }

    public String eliminaAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return "Autore eliminato con successo con id: " + id;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + id);
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");
        message.setText("Registrazione al servizio rest avvenuta con successo");

        javaMailSender.send(message);
    }

}
