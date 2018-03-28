package com.hbrnt.controllers;

import com.hbrnt.models.Contact;
import com.hbrnt.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "contacts")
    public String listContacts(Model model){
        model.addAttribute("contact", new Contact());
        model.addAttribute("listContacts", contactService.getAllContacts());
        return "contacts";
    }

    @RequestMapping(value = "contacts/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("contact") Contact contact) {
        if (contact.getId() == 0) {
            contactService.saveContact(contact);
        } else {
            System.out.println();
        }
        return "redirect:/contacts";
    }

    @RequestMapping(value = "contacts/orderAscFirstName")
    public String orderAscFirstName(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("listContacts", contactService.orderAscFirstName());
        return "contacts";
    }

    @RequestMapping(value = "contacts/orderDescLastName")
    public String orderDescLastName(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("listContacts", contactService.orderDescLastName());
        return "contacts";
    }

    @RequestMapping(value = "contacts/gtVersion")
    public String gtVersion(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("listContacts", contactService.gtVersion());
        return "contacts";
    }

}
