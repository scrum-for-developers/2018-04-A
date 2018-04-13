package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.domain.Borrowing;
import de.codecentric.psd.worblehat.domain.BorrowingRepository;
import de.codecentric.psd.worblehat.web.formdata.BookBorrowFormData;
import de.codecentric.psd.worblehat.web.formdata.ReturnAllBooksFormData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Controller class for the book table result.
 */
@Controller
@RequestMapping("/showPersonalBookings")
public class PersonalBorrowedBooksController {

	private BookService bookService;
	

	@Autowired
	public PersonalBorrowedBooksController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap) {
		modelMap.put("returnAllBookFormData", new ReturnAllBooksFormData());
		return "enterMailForBorrowingOverview";
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("returnAllBookFormData")  @Valid ReturnAllBooksFormData formData,
			BindingResult result, RedirectAttributes attr, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "enterMailForBorrowingOverview";
		}
		
		String mailAdress = formData.getEmailAddress(); 
		
		List<Book> books = bookService.findAllBooksByBorrowDateAndMail(mailAdress, false);
		
		modelMap.put("books", books);
		
		return "personalBookListByReturnDate";
	
	}

	@ExceptionHandler(Exception.class)
	public String handleErrors(Exception ex, HttpServletRequest request) {
		return "home";
	}

}
