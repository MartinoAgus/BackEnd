
package com.portfolio.Agustina.repository;

import com.portfolio.Agustina.model.Cursos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursosRepository extends JpaRepository<Cursos, Integer> {
    public Optional<Cursos> findByNombreC(String nombreC);
    public boolean existsByNombreC(String nombreC);
}
