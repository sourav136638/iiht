package com.boot.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.springmvc.model.Book;
import com.boot.springmvc.model.BookRepository;
import com.boot.springmvc.model.Subject;
import com.boot.springmvc.model.SubjectRepository;

@Controller
public class AppController {
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	SubjectRepository subjectRepo;

	@GetMapping("/")
	public String greeting(Model model) {		
		@SuppressWarnings("unchecked")
		List<Book> listbooks = (List<Book>) bookRepo.findAll();
	    model.addAttribute("listbooks", listbooks);
	    model.addAttribute("book", new Book());
		return "greeting";
	}
	
	@GetMapping("/new")
	public String showNewBookPage(Model model) {
	    Book book = new Book();
	    model.addAttribute("book", book);	     
	    return "newBook";
	}
	@PostMapping(value = "/savebook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookRepo.save(book);	     
	    return "greeting";
	}
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable(name = "id") long id,Model model) {
		bookRepo.deleteById(id);	     
		List<Book> listbooks = (List<Book>) bookRepo.findAll();
	    model.addAttribute("listbooks", listbooks);
	    model.addAttribute("book", new Book());
		return "greeting";
	}
	@PostMapping(value = "/searchbook")
	public String searchBook(@ModelAttribute("book") Book book ,Model model) {
		Optional opt = bookRepo.findById(book.getBookId());
		List list = new ArrayList<Book>();
		list.add(opt.get());
		model.addAttribute("listbooks", list);
	    model.addAttribute("book", book);
	    return "greeting";
	}
	
	@PostMapping(value = "/searchsubject")
	public String searchSubject(@ModelAttribute("subject") Subject subject ,Model model) {
		Optional opt = bookRepo.findById(Long.valueOf(subject.getSubjectId()));
		List list = new ArrayList<Book>();
		list.add(opt.get());
		model.addAttribute("listSubject", list);
	    model.addAttribute("subject", subject);
	    return "greeting";
	}
	@GetMapping(value = "/deleteSubject/{id}")
	public String deleteSubject(@PathVariable(name = "id") long id,Model model) {
		subjectRepo.deleteById(id);	  		
		return "greeting";
	}
}
