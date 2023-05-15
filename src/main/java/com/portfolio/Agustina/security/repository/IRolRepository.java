
package com.portfolio.Agustina.security.repository;

import com.portfolio.Agustina.security.entity.Rol;
import com.portfolio.Agustina.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
