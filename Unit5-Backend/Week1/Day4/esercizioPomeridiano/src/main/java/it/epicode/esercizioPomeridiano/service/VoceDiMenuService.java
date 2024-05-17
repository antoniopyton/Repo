package it.epicode.esercizioPomeridiano.service;

import it.epicode.esercizioPomeridiano.bean.VoceDiMenu;
import it.epicode.esercizioPomeridiano.repository.VoceDiMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoceDiMenuService {

    @Autowired
    private VoceDiMenuRepository voceDiMenuRepository;

    public void salvaVoceDiMenu(VoceDiMenu voceDiMenu) {
        voceDiMenuRepository.save(voceDiMenu);
    }
}
