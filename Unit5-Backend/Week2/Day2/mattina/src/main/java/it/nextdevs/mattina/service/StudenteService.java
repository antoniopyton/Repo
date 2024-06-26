package it.nextdevs.mattina.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.mattina.DTO.StudenteDto;
import it.nextdevs.mattina.exceptions.AulaNonTrovataException;
import it.nextdevs.mattina.exceptions.StudenteNonTrovatoException;
import it.nextdevs.mattina.model.Aula;
import it.nextdevs.mattina.model.Studente;
import it.nextdevs.mattina.repository.AulaRepository;
import it.nextdevs.mattina.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private StudenteRepository studenteRepository;

    public String saveStudente(StudenteDto studenteDto) {
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());
        studente.setEmail(studenteDto.getEmail());

        Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());

        if (aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            //Serve per inviare la mail
            sendMail((studente.getEmail()));
            return "Studente salvato con successo con matricola: " + studente.getMatricola();

        } else {
            throw new AulaNonTrovataException("Aula non trovata con id: " + studenteDto.getAulaId());
        }

//        aulaRepository.findById(studenteDto.getAulaId()).ifPresent(aula -> studente.setAula(aula));
//        studenteRepository.save(studente);
//        return "Studente salvato con successo con matricola: " + studente.getMatricola();
    }

    public Page<Studente> getAllStudenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }

    public Optional<Studente> getStudenteByMatricola(int matricola) {
        return studenteRepository.findById(matricola);
    }

    public Studente updateStudente(int matricola, StudenteDto studenteDto){
        Optional<Studente> studenteOptional = getStudenteByMatricola(matricola);

        if(studenteOptional.isPresent()){
            Studente studente = studenteOptional.get();

            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());
            studente.setEmail(studenteDto.getEmail());

            Optional<Aula> aulaOptional=aulaRepository.findById(studenteDto.getAulaId());

            if(aulaOptional.isPresent()){
                Aula aula = aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);
                return studente;
            }
            else{
                throw new AulaNonTrovataException("Aula con id=" + studenteDto.getAulaId() + " non trovata");
            }
        }
        else{
            throw new StudenteNonTrovatoException("Studente con matricola=" + matricola + " non trovato");
        }
    }

    public String deleteStudente(int matricola)  {
        Optional<Studente> studenteOptional = studenteRepository.findById(matricola);

        if (studenteOptional.isPresent()) {
            studenteRepository.delete(studenteOptional.get());
            return "Studente eliminato con successo con matricola: " + matricola;
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato con matricola: " + matricola);
        }
    }

    public String patchFotoStudente(int matricola, MultipartFile foto) throws IOException {
        Optional<Studente> studenteOptional = studenteRepository.findById(matricola);

        if (studenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Studente studente = studenteOptional.get();
            studente.setFoto(url);
            studenteRepository.save(studente);
            return "Studente aggiornato correttamente e foto inviata con matricola: " + matricola;
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato con matricola: " + matricola);
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
