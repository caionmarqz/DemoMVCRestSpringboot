package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

}
