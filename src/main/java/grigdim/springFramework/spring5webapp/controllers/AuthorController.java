package grigdim.springFramework.spring5webapp.controllers;

import grigdim.springFramework.spring5webapp.repos.AuthorRepo;
import grigdim.springFramework.spring5webapp.repos.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepo.findAll());

        return "authors/list";
    }
}