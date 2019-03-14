package com.example.authorbook.controller;


import com.example.authorbook.model.Book;
import com.example.authorbook.model.User;
import com.example.authorbook.repository.BookRepository;
import com.example.authorbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/add")
    public String addAuthorView(ModelMap map ) {
        map.addAttribute("books", bookRepository.findAll());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        //userRepository.save(new User("Book 1","rtrt","trt"));
        return "redirect:/";
    }
}
