package passbook.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import passbook.dto.PassBookDTO;
import passbook.model.Customer;
import passbook.model.PassBook;
import passbook.service.IPassBookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/passbook")
public class PassBookController {

    @Autowired
    IPassBookService iPassBookService;

    @GetMapping("")
    public ResponseEntity<Page<PassBook>> listPassBook(@PageableDefault(value = 2) Pageable pageable) {
        Page<PassBook> listPassBook = this.iPassBookService.findAll(pageable);
        return new ResponseEntity<>(listPassBook, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createPassBook(@Validated @RequestBody PassBookDTO passBookDTO, BindingResult bindingResult) {
        List<FieldError> err = null;
        passBookDTO.validate(passBookDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            err = bindingResult.getFieldErrors();
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }
        PassBook passBook = new PassBook();
        Customer customer = new Customer();

        BeanUtils.copyProperties(passBookDTO, passBook);
        BeanUtils.copyProperties(passBookDTO.getCustomerDTO(), customer);

        passBook.setCustomer(customer);

        this.iPassBookService.save(passBook);
        return new ResponseEntity<>(err, HttpStatus.OK);
    }

    @PutMapping ("/update")
    public ResponseEntity<List<FieldError>> updatePassBook(@Validated @RequestBody PassBookDTO passBookDTO , BindingResult bindingResult){
        List<FieldError> err = null;
        passBookDTO.validate(passBookDTO,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            err = bindingResult.getFieldErrors();
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }

        PassBook passBook = new PassBook();
        Customer customer = new Customer();

        BeanUtils.copyProperties(passBookDTO, passBook);
        BeanUtils.copyProperties(passBookDTO.getCustomerDTO(), customer);

        passBook.setCustomer(customer);
        passBook.setId(passBookDTO.getId());

        this.iPassBookService.save(passBook);

        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassBook(@PathVariable Integer id){
        if(this.iPassBookService.findById(id)==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iPassBookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
