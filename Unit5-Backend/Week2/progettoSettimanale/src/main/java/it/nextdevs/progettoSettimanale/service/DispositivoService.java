package it.nextdevs.progettoSettimanale.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.progettoSettimanale.DTO.DispositivoDto;
import it.nextdevs.progettoSettimanale.enums.StatoDispositivo;
import it.nextdevs.progettoSettimanale.exceptions.DipendenteNonTrovatoException;
import it.nextdevs.progettoSettimanale.exceptions.DispositivoNonTrovatoException;
import it.nextdevs.progettoSettimanale.model.Computer;
import it.nextdevs.progettoSettimanale.model.Dipendente;
import it.nextdevs.progettoSettimanale.model.Smartphone;
import it.nextdevs.progettoSettimanale.model.Tablet;
import it.nextdevs.progettoSettimanale.repository.DipendenteRepository;
import it.nextdevs.progettoSettimanale.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String salvaComputer(DispositivoDto dispositivoDto) throws  DipendenteNonTrovatoException {
        Computer computer = new Computer();
        computer.setNome(dispositivoDto.getNome());
        computer.setMarca(dispositivoDto.getMarca());
        computer.setStatoDispositivo(dispositivoDto.getStatoDispositivo());

        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {

            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                computer.setDipendente(dipendente);
                dispositivoRepository.save(computer);
                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
            } else {
                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
            }
        } else {
            dispositivoRepository.save(computer);
            return "Dispositivo salvato con successo";
        }
    }

    public String salvaTablet(DispositivoDto dispositivoDto) throws  DipendenteNonTrovatoException {
        Tablet tablet = new Tablet();
        tablet.setNome(dispositivoDto.getNome());
        tablet.setMarca(dispositivoDto.getMarca());
        tablet.setStatoDispositivo(dispositivoDto.getStatoDispositivo());

        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {

            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                tablet.setDipendente(dipendente);
                dispositivoRepository.save(tablet);
                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
            } else {
                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
            }
        } else {
            dispositivoRepository.save(tablet);
            return "Dispositivo salvato con successo";
        }
    }

    public String salvaSmartphone(DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome(dispositivoDto.getNome());
        smartphone.setMarca(dispositivoDto.getMarca());
        smartphone.setStatoDispositivo(dispositivoDto.getStatoDispositivo());

        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {

            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                smartphone.setDipendente(dipendente);
                dispositivoRepository.save(smartphone);
                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
            } else {
                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
            }
        } else {
            dispositivoRepository.save(smartphone);
            return "Dispositivo salvato con successo";
        }
    }

    


}

