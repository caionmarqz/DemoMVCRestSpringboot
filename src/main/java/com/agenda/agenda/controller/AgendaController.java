package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contato;
import com.agenda.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/contatos";
    }

    @RequestMapping("/cadastrafunc")
    public String cadastrafunc() {
        return "cadastrafunc.html";
    }

    @RequestMapping("/contatos/edit/{id}")
    public String edit() {
        return "edit.html";
    }

    @RequestMapping(value = "/contatos", method = RequestMethod.GET)
    public ModelAndView getContatos() {
        ModelAndView mvc = new ModelAndView("contatos");
        List<Contato> contatos = agendaService.getAllContacts();
        mvc.addObject("contatos", contatos);
        return mvc;
    }


    @RequestMapping(value = "contatos/cadastrafunc", method = RequestMethod.POST)
    public String newContato(@RequestParam("nome")  String nome, @RequestParam("endereco") String endereco, @RequestParam("telefone") String telefone, @RequestParam("email") String email)
    {
        Contato ctt = new Contato();
        ctt.setNome(nome);
        ctt.setEndereco(endereco);
        ctt.setEmail(email);
        ctt.setTelefone(telefone);


        agendaService.saveContact(ctt);
        return "redirect:/contatos";
    }

    @RequestMapping(value = "/contatos/delete/{id}", method = RequestMethod.GET)
    public String deleteContato(@PathVariable("id") long id) {
        agendaService.deleteContactById(id);
        return "redirect:/contatos";
    }

    @RequestMapping(value = "/contatos/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getContato(@PathVariable("id") long id) {
        ModelAndView mvc = new ModelAndView("edit");
        Contato contato = agendaService.getContactById(id);
        mvc.addObject("contato", contato);
        return mvc;
    }

    @RequestMapping(value = "/contatos/edit", method = RequestMethod.POST)
    public String getContatoedit(@RequestParam("id") long id, @RequestParam("nome")  String nome, @RequestParam("endereco") String endereco, @RequestParam("telefone") String telefone, @RequestParam("email") String email)
    {
        Contato ctt = new Contato();

        ctt.setId(id);
        ctt.setNome(nome);
        ctt.setEndereco(endereco);
        ctt.setEmail(email);
        ctt.setTelefone(telefone);

    //    agendaService.editcontactbyid(id, nome, endereco, email, telefone);
        agendaService.editcontactbyid(ctt);

        return "redirect:/contatos";
    }




}
