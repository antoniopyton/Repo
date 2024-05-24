package it.nextdevs.progettoSettimanale.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.progettoSettimanale.DTO.DispositivoDto;
import it.nextdevs.progettoSettimanale.enums.StatoDispositivo;
import it.nextdevs.progettoSettimanale.exceptions.DipendenteNonTrovatoException;
import it.nextdevs.progettoSettimanale.exceptions.DispositivoNonTrovatoException;
import it.nextdevs.progettoSettimanale.model.*;
import it.nextdevs.progettoSettimanale.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private TabletRepository tabletRepository;

    @Autowired
    private SmartphoneRepository smartphoneRepository;



//    public String salvaComputer(DispositivoDto dispositivoDto) throws  DipendenteNonTrovatoException {
//        Computer computer = new Computer();
//        computer.setNome(dispositivoDto.getNome());
//        computer.setMarca(dispositivoDto.getMarca());
//        computer.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
//
//        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {
//
//            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
//            if (dipendenteOptional.isPresent()) {
//                Dipendente dipendente = dipendenteOptional.get();
//                computer.setDipendente(dipendente);
//                dispositivoRepository.save(computer);
//                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
//            } else {
//                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
//            }
//        } else {
//            dispositivoRepository.save(computer);
//            return "Dispositivo salvato con successo";
//        }
//    }
//
//    public String salvaTablet(DispositivoDto dispositivoDto) throws  DipendenteNonTrovatoException {
//        Tablet tablet = new Tablet();
//        tablet.setNome(dispositivoDto.getNome());
//        tablet.setMarca(dispositivoDto.getMarca());
//        tablet.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
//
//        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {
//
//            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
//            if (dipendenteOptional.isPresent()) {
//                Dipendente dipendente = dipendenteOptional.get();
//                tablet.setDipendente(dipendente);
//                dispositivoRepository.save(tablet);
//                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
//            } else {
//                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
//            }
//        } else {
//            dispositivoRepository.save(tablet);
//            return "Dispositivo salvato con successo";
//        }
//    }
//
//    public String salvaSmartphone(DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
//        Smartphone smartphone = new Smartphone();
//        smartphone.setNome(dispositivoDto.getNome());
//        smartphone.setMarca(dispositivoDto.getMarca());
//        smartphone.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
//
//        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {
//
//            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
//            if (dipendenteOptional.isPresent()) {
//                Dipendente dipendente = dipendenteOptional.get();
//                smartphone.setDipendente(dipendente);
//                dispositivoRepository.save(smartphone);
//                return "Dispositivo salvato con successo e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() ;
//            } else {
//                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
//            }
//        } else {
//            dispositivoRepository.save(smartphone);
//            return "Dispositivo salvato con successo";
//        }
//    }
//
//    public Optional<Dispositivo> getDispositivoById(int id) {
//        return dispositivoRepository.findById(id);
//    }
//
//    public List<Dispositivo> getDispositivi() {
//        return dispositivoRepository.findAll();
//    }
//
//    public Computer updateComputer(int id, DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
//        Optional<Computer> computerOptional = computerRepository.findById(id);
//        if (computerOptional.isPresent()) {
//            Computer computer = computerOptional.get();
//            computer.setNome(dispositivoDto.getNome());
//            computer.setMarca(dispositivoDto.getMarca());
//            return dispositivoRepository.save(computer);
//
//        } else {
//            throw new DispositivoNonTrovatoException("Post non trovato con id: " + id);
//        }
//    }


    public String salvaComputer(DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
        Computer computer = new Computer();
        return salvaDispositivo(computer, dispositivoDto);
    }

    public String salvaTablet(DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
        Tablet tablet = new Tablet();
        return salvaDispositivo(tablet, dispositivoDto);
    }

    public String salvaSmartphone(DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
        Smartphone smartphone = new Smartphone();
        return salvaDispositivo(smartphone, dispositivoDto);
    }

    private <T extends Dispositivo> String salvaDispositivo(T dispositivo, DispositivoDto dispositivoDto) throws DipendenteNonTrovatoException {
        dispositivo.setNome(dispositivoDto.getNome());
        dispositivo.setMarca(dispositivoDto.getMarca());
        dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());

        if (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO) {
            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dispositivoDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                dispositivo.setDipendente(dipendente);
            } else {
                throw new DipendenteNonTrovatoException("Dipendente non trovato con ID: " + dispositivoDto.getDipendenteId());
            }
        }

        dispositivoRepository.save(dispositivo);
        return "Dispositivo salvato con successo" + (dispositivoDto.getStatoDispositivo() == StatoDispositivo.ASSEGNATO ? " e assegnato a dipendente con id: " + dispositivoDto.getDipendenteId() : "");
    }

    public Optional<Dispositivo> getDispositivoById(int id) {
        return dispositivoRepository.findById(id);
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }

    public List<Computer> getComputers() {
        return computerRepository.findAll();
    }

    public List<Tablet> getTablets() {
        return tabletRepository.findAll();
    }

    public List<Smartphone> getSmartphones() {
        return smartphoneRepository.findAll();
    }

    public Computer updateComputer(int id, DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
        return updateDispositivo(computerRepository, id, dispositivoDto);
    }

    public Tablet updateTablet(int id, DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
        return updateDispositivo(tabletRepository, id, dispositivoDto);
    }

    public Smartphone updateSmartphone(int id, DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
        return updateDispositivo(smartphoneRepository, id, dispositivoDto);
    }

    private <T extends Dispositivo> T updateDispositivo(JpaRepository<T, Integer> repository, int id, DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
        Optional<T> dispositivoOptional = repository.findById(id);
        if (dispositivoOptional.isPresent()) {
            T dispositivo = dispositivoOptional.get();
            dispositivo.setNome(dispositivoDto.getNome());
            dispositivo.setMarca(dispositivoDto.getMarca());

            return repository.save(dispositivo);
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato con id: " + id);
        }
    }

    public String eliminaDispositivo(int id) throws DispositivoNonTrovatoException {
        Optional<Dispositivo> dispositivoOptional = getDispositivoById(id);

        if (dispositivoOptional.isPresent()) {
            dispositivoRepository.delete(dispositivoOptional.get());
            return "Dispositivo eliminato con successo con id: " + id;
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato con id: " + id);
        }
    }

    public Dispositivo assegnaDispositivo(Integer id, Dipendente dipendente) throws DispositivoNonTrovatoException {
        Optional<Dispositivo> dispositivoOpt = getDispositivoById(id);

        if (dispositivoOpt.isPresent()) {
            Dispositivo dispositivo = dispositivoOpt.get();
            dispositivo.setDipendente(dipendente);
            dispositivo.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
            return dispositivoRepository.save(dispositivo);
        }else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato");}
    }


}

