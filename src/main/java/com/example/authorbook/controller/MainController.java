package com.example.authorbook.controller;

import com.example.authorbook.model.Book;
import com.example.authorbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String main(ModelMap map) {
        List<Book> all = bookRepository.findAll();
        map.addAttribute("books", all);
        return "index";
    }

}
