package com.portfolio.Agustina.controller;

import com.portfolio.Agustina.model.Texto;
import com.portfolio.Agustina.service.ITextoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TextoController {

    @Autowired
    ITextoService itextoService;

    @GetMapping("texto/traer")
    public List<Texto> getTexto() {
        return itextoService.getTexto();
    }


    @PostMapping("/texto/crear")
    public String createTexto(@RequestBody Texto texto) {
        itextoService.saveTexto(texto);
        return "El texto fue guardado correctamente";
    }

    @DeleteMapping("/texto/borrar/{id}")
    public String deleteTexto(@PathVariable Long id) {
        itextoService.deleteTexto(id);
        return "El texto fue eliminado correctamente";
    }

    @PutMapping("texto/editar/{id}")
    public Texto editTexto(@PathVariable Long id,
            @RequestParam("texto") String nuevoTexto) {
        Texto texto = itextoService.findTexto(id);
        texto.setTexto(nuevoTexto);

        itextoService.saveTexto(texto);
        return texto;
    }

    @GetMapping("texto/traer/texto")
    public Texto findTexto() {
        return itextoService.findTexto((long) 1);
    }
}
