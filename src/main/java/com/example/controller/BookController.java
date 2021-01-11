package com.example.controller;

import com.example.models.Author;
import com.example.models.Book;
import com.example.models.Publisher;
import com.example.service.AuthorService;
import com.example.service.BookService;
import com.example.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/formpage")
    public String showNewBookForm(Model model){
        Book book=new Book();
        List<Author> authors=authorService.listAll();
        List<Publisher> publishers=publisherService.listAll();
        model.addAttribute("book",book);
        model.addAttribute("authors",authors);
        model.addAttribute("publishers",publishers);

        return "book_form";
    }
    @RequestMapping("/formpage/{id}")
    public ModelAndView showBookEditForm(@PathVariable(name = "id") long id){
        List<Author> authors=authorService.listAll();
        List<Publisher> publishers=publisherService.listAll();
        ModelAndView mav=new ModelAndView("book_form");
        Book book=bookService.get(id);
        mav.addObject("book",book);
        mav.addObject("authors",authors);
        mav.addObject("publishers",publishers);
        return mav;
    }

    @RequestMapping("/formpage_confirm")
    public String edit_book(@ModelAttribute(value = "book") Book book){
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping("/details/{id}")
    public ModelAndView showDetailsPage(@PathVariable(name = "id") long id){
        ModelAndView mav=new ModelAndView("details");
        mav.addObject("book",bookService.get(id));
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") long id){
        bookService.delete(id);
        return "redirect:/";
    }
}
