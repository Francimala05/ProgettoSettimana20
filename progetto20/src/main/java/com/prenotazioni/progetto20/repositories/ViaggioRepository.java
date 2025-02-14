package com.prenotazioni.progetto20.repositories;

import com.prenotazioni.progetto20.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

}
