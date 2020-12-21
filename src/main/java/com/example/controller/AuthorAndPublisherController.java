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
public class AuthorAndPublisherController {
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
    @RequestMapping("/new_author")
    public String showAuthorAddFrom(Model model){
        Author author=new Author();
        model.addAttribute("author",author);
        return "create_author";
    }
    @RequestMapping("/create_author")
    public String createAuthor(@ModelAttribute("author") Author author){
        authorService.save(author);
        return "redirect:/";
    }
    @RequestMapping("/new_publisher")
    public String showPublisherAddFrom(Model model){
        Publisher publisher=new Publisher();
        model.addAttribute("publisher",publisher);
        return "create_publisher";
    }
    @RequestMapping("/create_publisher")
    public String createPublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.save(publisher);
        return "redirect:/";
    }
}
