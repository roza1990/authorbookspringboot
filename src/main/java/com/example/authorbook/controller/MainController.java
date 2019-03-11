package com.example.authorbook.controller;

import com.example.authorbook.model.Book;
import com.example.authorbook.repository.AuthorRepository;
import com.example.authorbook.repository.BookRepository;
import com.example.authorbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @GetMapping("/")
    public String main(ModelMap map) {
        List<Book> all = bookRepository.findAll();
        map.addAttribute("books", all);
        map.addAttribute("authors", authorRepository.findAll());
        map.addAttribute("users", userRepository.findAll());
        return "index";
    }

}
