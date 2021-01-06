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
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/create")
    public String showAuthorAddFrom(Model model){
        Author author=new Author();
        model.addAttribute("author",author);
        return "create_author";
    }
    @RequestMapping("/create_confirm")
    public String createAuthor(@ModelAttribute("author") Author author){
        authorService.save(author);
        return "redirect:/";
    }
}
