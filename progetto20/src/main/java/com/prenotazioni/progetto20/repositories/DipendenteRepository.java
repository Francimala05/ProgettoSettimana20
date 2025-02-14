package com.prenotazioni.progetto20.repositories;


import com.prenotazioni.progetto20.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends  JpaRepository<Dipendente, Long>{

}
