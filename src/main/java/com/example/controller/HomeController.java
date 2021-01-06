package com.example.controller;

import com.example.models.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index(Model model){
        List<Book> bookList=bookService.listAllBooks();
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model, @Param("keyword")  String keyword ){
        List<Book> bookList=bookService.listAllBooks(keyword);
        model.addAttribute("bookList",bookList);
        model.addAttribute("keyword",keyword);
        return "index";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }
}
