
package com.portfolio.Agustina.controller;

import com.portfolio.Agustina.dto.DtoCursos;
import com.portfolio.Agustina.model.Cursos;
import com.portfolio.Agustina.security.controller.Mensaje;
import com.portfolio.Agustina.service.CursosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CursosController {
    @Autowired
    CursosService cursosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list() {
        List<Cursos> list = cursosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id) {
        if (!cursosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = cursosService.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!cursosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        cursosService.delete(id);
        return new ResponseEntity(new Mensaje("Curso eliminado correctamente"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoCursos dtoCursos) {
        if(StringUtils.isBlank(dtoCursos.getNombreC()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
        if(cursosService.existsByNombreC(dtoCursos.getNombreC())) 
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
      
        Cursos cursos = new Cursos (
        dtoCursos.getNombreC(), dtoCursos.getDescripcionC());
        cursosService.save(cursos);
            return new ResponseEntity (new Mensaje("Educación creada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoCursos dtoCursos) {
        if(!cursosService.existsById(id)) {
            return new ResponseEntity (new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(cursosService.existsByNombreC(dtoCursos.getNombreC()) 
                                        && cursosService.getByNombreC(
                                        dtoCursos.getNombreC())
                                        .get()
                                        .getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoCursos.getNombreC())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = cursosService.getOne(id).get();
        cursos.setNombreC(dtoCursos.getNombreC());
        cursos.setDescripcionC(dtoCursos.getDescripcionC());
        cursosService.save(cursos);
        
        return new ResponseEntity(new Mensaje("Curso actualizado"), HttpStatus.OK);
    }
    
}
