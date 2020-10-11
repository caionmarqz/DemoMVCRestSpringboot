package com.agenda.agenda.services.impl;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.repository.AgendaRepository;
import com.agenda.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    AgendaRepository agendaRepository;
    
//    @Modifying
//    @Query(value = "UPDATE agenda_contatos SET nome = :nome, endereco = :endereco, telefone = :telefone, email :email where id = :id;", nativeQuery = true)
//    public void editcontactbyid(@Param("id") long id, @Param("nome") String nome, @Param("endereco") String endereco, @Param("telefone") String telefone, @Param("email") String email) {};

    @Override
    public void editcontactbyid(Contato ctt) {
        agendaRepository.save(ctt);
    }

    @Override
    public List<Contato> getAllContacts() { return agendaRepository.findAll(); }

    @Override
    public Contato getContactById(long id) {
        return agendaRepository.findById(id).get();
    }

    @Override
    public void saveContact(Contato contato) {
        agendaRepository.save(contato);
    }

    @Override
    public void deleteContactById(long id) { agendaRepository.deleteById(id);
    }

}
