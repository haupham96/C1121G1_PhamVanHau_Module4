package book_app.controller;

import book_app.model.Book;
import book_app.model.Borrow;
import book_app.service.IBookService;
import book_app.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

    @Autowired
    IBorrowService borrowService;

    @GetMapping("")
    public String listBook(Model model) {
        List<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "list-book";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBookForm(@PathVariable Integer id, Model model) {
        Book book = iBookService.findById(id);
        Borrow borrow = new Borrow();
        Integer borrowCode = (int) (Math.random() * 100000);
        borrow.setCode(borrowCode);
        model.addAttribute("book", book);
        model.addAttribute("borrow", borrow);
        return "borrow-book";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, @ModelAttribute Borrow borrow, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        borrow.setBook(book);
        borrowService.save(borrow);
        iBookService.borrowBook(book);
        redirectAttributes.addFlashAttribute("message", "borrow success");
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String returnForm(){
        return "return-book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer code,RedirectAttributes redirectAttributes){
        Borrow borrow = borrowService.findByCode(code);
        if(borrow != null){
            Book book = iBookService.findById(borrow.getBook().getId());
            iBookService.returnBook(book);
            borrowService.deleteById(borrow.getId());
            redirectAttributes.addFlashAttribute("message","return success");
            return "redirect:/book";
        } else {
            return "not-found-code";
        }
    }
}
