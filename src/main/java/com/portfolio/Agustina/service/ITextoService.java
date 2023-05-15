package com.portfolio.Agustina.service;

import com.portfolio.Agustina.model.Texto;
import java.util.List;


public interface ITextoService {
    
    public List<Texto> getTexto();
    
    public void saveTexto(Texto texto);
    
    public void deleteTexto(Long id);
    
    public Texto findTexto(Long id);
    
}