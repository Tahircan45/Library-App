package com.example.controller;

import com.example.models.Author;
import com.example.models.Publisher;
import com.example.service.AuthorService;
import com.example.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("/create")
    public String showPublisherAddFrom(Model model){
        Publisher publisher=new Publisher();
        model.addAttribute("publisher",publisher);
        return "create_publisher";
    }
    @RequestMapping("/create_confirm")
    public String createPublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.save(publisher);
        return "redirect:/";
    }
}
