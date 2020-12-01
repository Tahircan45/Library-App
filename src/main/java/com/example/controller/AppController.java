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
public class AppController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
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
    @RequestMapping("/details/{id}")
    public ModelAndView showDetailsPage(@PathVariable(name = "id") long id){
        ModelAndView mav=new ModelAndView("details");
        mav.addObject("book",bookService.get(id));
        return mav;
    }
    @GetMapping("/403")
    public String error403(){
        return "403";
    }
}
