package com.agenda.agenda.services;

import com.agenda.agenda.model.Contato;

import java.util.List;

public interface AgendaService {

    void editcontactbyid(Contato ctt);
    List<Contato> getAllContacts();
    Contato getContactById(long id);
    void saveContact(Contato contato);
    void deleteContactById(long id);
}
