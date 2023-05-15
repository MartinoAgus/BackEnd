
package com.portfolio.Agustina.service;

import com.portfolio.Agustina.model.Cursos;
import com.portfolio.Agustina.repository.ICursosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CursosService {
    @Autowired
    ICursosRepository rCursos;
    
    public List<Cursos> list() {
        return rCursos.findAll();
    }
    
    public Optional<Cursos> getOne (int id) {
        return rCursos.findById(id);
    }
    
    public Optional<Cursos> getByNombreC (String nombreC) {
        return rCursos.findByNombreC (nombreC);
    }
    
    public void save(Cursos cursos) {
        rCursos.save(cursos);
    }
    
    public void delete (int id) {
        rCursos.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rCursos.existsById(id);
    }
    
    public boolean existsByNombreC(String nombreC) {
        return rCursos.existsByNombreC(nombreC);
    }
    
}