package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.domain.Borrowing;
import de.codecentric.psd.worblehat.domain.BorrowingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Controller class for the book table result.
 */
@Controller
@RequestMapping("/bookListByReturnDate")
public class BookByReturnDateListController {

	private BookService bookService;
	

	@Autowired
	public BookByReturnDateListController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap) {
		List<Book> books = bookService.findAllBooksByBorrowDate();
		modelMap.addAttribute("books", books);
		return "bookListByReturnDate";
	}

}
