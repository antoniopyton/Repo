package it.nextdevs.mattina.service;

import it.nextdevs.mattina.Bean.Computer;
import it.nextdevs.mattina.Bean.Dispositivo;
import it.nextdevs.mattina.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void inserisciDispositivo(Dispositivo dispositivo) {
        dispositivoRepository.save(dispositivo);
    }

    public Dispositivo getDispositivo(Integer id) {
        return dispositivoRepository.findById(id).get();
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }

    public void eliminaDispositivo(Integer id) {
        dispositivoRepository.deleteById(id);
    }

    public List<Computer> getComputerByRamLessThan(int ram){
        return dispositivoRepository.findByRamLessThan(ram);
    }

    public List<Dispositivo> getDispositiviOrderByNome(){
        return dispositivoRepository.findAllOrderByNomeDesc();
    }


}
