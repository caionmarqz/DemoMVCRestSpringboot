package com.agenda.agenda.repository;

import com.agenda.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AgendaRepository extends JpaRepository<Contato, Long> {
    }

