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
    boolean ld=true;
    @RequestMapping("/")
    public String index(Model model){
        if(ld){
            loadData();
            ld=false;
        }
        List<Book> bookList=bookService.listAllBooks();
        model.addAttribute("bookList",bookList);
        return "index";
    }
    @RequestMapping("/search")
    public String search(Model model, @Param("keyword")  String keyword ){
        if(ld){
            loadData();
            ld=false;
        }
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
    public  void loadData(){
        Author a1=new Author("Frank Herbert","1920 Amerika");
        Author a2=new Author("Yuah Noah Harari","1976 İsrail");
        Author a3=new Author("George Orwell","1903 Hindistan");
        Author a4=new Author("Emrah Safa GÜRKAN","1981 Türkiye");
        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);
        authorService.save(a4);


        Publisher p1= new Publisher("İthaki Yayınları","Kadıköy-İstanbul");
        Publisher p2= new Publisher("Kolektif Kitap","Beyoğlu-İstanbul");
        Publisher p3= new Publisher("Can Sanat Yayınları","Galatasaray-İstanbul");
        Publisher p4= new Publisher("Kronik Kitap","Levent-İstanbul");
        publisherService.save(p1);
        publisherService.save(p2);
        publisherService.save(p3);
        publisherService.save(p4);

        Book b1=new Book("Dune","978-605-375-479-4","");
        Book b2=new Book("Dune Mesihi","978-605-375-531-9","");
        Book b3=new Book("Sapiens","978-605-5029-35-7","İnsan Türünün Kısa Bir Tarihi");
        Book b4=new Book("Hayvan Çiftliği","978-975-07-1938-7","Bir Peri Masalı");
        Book b5=new Book("Bunu Herkes Bilir","978-605-7635-40-2","Tarihteki Yanlış Sorulara Doğru Cevaplar");
        b5.setSerName("test");
        b5.setDescription("descr test");
        b1.setAuthor(a1);
        b1.setPublisher(p1);

        b2.setAuthor(a1);
        b2.setPublisher(p1);

        b3.setPublisher(p2);
        b3.setAuthor(a2);

        b4.setPublisher(p3);
        b4.setAuthor(a3);

        b5.setPublisher(p4);
        b5.setAuthor(a4);

        bookService.save(b1);
        bookService.save(b2);
        bookService.save(b3);
        bookService.save(b4);
        bookService.save(b5);
    }
}
