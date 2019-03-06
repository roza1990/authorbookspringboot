package com.example.authorbook.controller;

import com.example.authorbook.model.Book;
import com.example.authorbook.repository.AuthorRepository;
import com.example.authorbook.repository.BookRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Value("${image.upload.dir}")
    private String imageUploadDir;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/add")
    public String addBookView(ModelMap map) {
        map.addAttribute("authors", authorRepository.findAll());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("picture") MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File(imageUploadDir + File.separator + fileName);
        file.transferTo(picture);
        book.setPicUrl(fileName);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id) {
        Optional<Book> one = bookRepository.findById(id);
        if (one.isPresent()) {
            bookRepository.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping("/getImage")
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("picUrl") String picUrl) throws IOException {
        InputStream in = new FileInputStream(imageUploadDir + File.separator + picUrl);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}
