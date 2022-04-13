package product_cart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_cart.model.Cart;
import product_cart.model.Product;
import product_cart.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }

        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }

        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        model.addAttribute("productObj", product.get());
        return "view-product";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseAmount(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.decreaseProduct(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id , @ModelAttribute Cart cart){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.removeProduct(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String payCart(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes){
        cart.clear();
        redirectAttributes.addFlashAttribute("message","pay success");
        return "redirect:/shop";
    }


}
