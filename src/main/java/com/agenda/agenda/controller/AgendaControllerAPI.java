package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AgendaControllerAPI {


        @Autowired
        AgendaService agendaService;

        @RequestMapping(value = "/api/contatos", method = RequestMethod.GET)
        public List<Contato> getContatos() {
            List<Contato> contatos = agendaService.getAllContacts();
            return contatos;
        }

        @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
        public Contato getContatos(@PathVariable("id") long id) {
            Contato contato = agendaService.getContactById(id);
            return contato;
        }
}
