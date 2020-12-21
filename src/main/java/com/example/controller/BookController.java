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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
    @RequestMapping("/new_book")
    public String showNewBookForm(Model model){
        Book book=new Book();
        List<Author> authors=authorService.listAll();
        List<Publisher> publishers=publisherService.listAll();
        model.addAttribute("book",book);
        model.addAttribute("authors",authors);
        model.addAttribute("publishers",publishers);

        return "create_book";
    }
    @RequestMapping(value = "/create_book",method = RequestMethod.POST)
    public String createBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/";
    }
    @RequestMapping("/edit_book_page/{id}")
    public ModelAndView showBookEditForm(@PathVariable(name = "id") long id){
        List<Author> authors=authorService.listAll();
        List<Publisher> publishers=publisherService.listAll();
        ModelAndView mav=new ModelAndView("edit_book");
        Book book=bookService.get(id);
        mav.addObject("book",book);
        mav.addObject("authors",authors);
        mav.addObject("publishers",publishers);
        return mav;
    }
    @RequestMapping("/edit_book")
    public String edit_book(@ModelAttribute(value = "book") Book book){
        bookService.save(book);
        return "redirect:/";
    }
    @RequestMapping("/delete_book/{id}")
    public String deleteBook(@PathVariable(name = "id") long id){
        bookService.delete(id);
        return "redirect:/";
    }
}