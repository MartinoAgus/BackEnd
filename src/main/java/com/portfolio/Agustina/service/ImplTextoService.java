
package com.portfolio.Agustina.service;

import com.portfolio.Agustina.model.Texto;
import com.portfolio.Agustina.repository.ITextoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplTextoService implements ITextoService {
    @Autowired ITextoRepository itextoRepository;
    
    @Override
    public List<Texto> getTexto() {
        List<Texto> texto = itextoRepository.findAll();
        return texto;
    }
    
    @Override
    public void saveTexto(Texto texto) {
        itextoRepository.save(texto);
    }

    @Override
    public void deleteTexto(Long id) {
        itextoRepository.deleteById(id);
    }

    @Override
    public Texto findTexto(Long id) {
        Texto texto = itextoRepository.findById(id).orElse(null);
        return texto;
    }
    
}