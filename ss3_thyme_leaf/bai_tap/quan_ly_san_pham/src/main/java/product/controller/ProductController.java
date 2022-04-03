package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import product.model.Product;
import product.service.IProductService;


import java.util.List;

@Controller
@RequestMapping(value = "/product")

public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "")
    public String listProduct(Model model) {
        List<Product> listProduct = productService.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "list";
    }

    @GetMapping("/create")
    public String showCreatForm(Model model) {
        List<String> nhaSX = productService.getAllManufacturer();
        model.addAttribute("product", new Product());
        model.addAttribute("nhaSanXuat", nhaSX);
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        List<Product> listProduct = productService.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        List<String> nhaSX = productService.getAllManufacturer();
        model.addAttribute("product", product);
        model.addAttribute("nhaSanXuat", nhaSX);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@ModelAttribute Product product, @PathVariable Integer id, Model model) {
        productService.editProduct(id, product);
        List<Product> listProduct = productService.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "list";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("searchName") String searchName, Model model) {
        List<Product> productList = productService.findByName(searchName);
        model.addAttribute("listProduct", productList);
        return "search";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer idDelete, Model model) {
        System.out.println(idDelete);
        productService.deleteById(idDelete);
        List<Product> listProduct = productService.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("pro",product);
        return "view";
    }
}
