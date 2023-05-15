
package com.portfolio.Agustina.repository;

import com.portfolio.Agustina.model.Texto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITextoRepository extends JpaRepository<Texto, Long>{
    
}