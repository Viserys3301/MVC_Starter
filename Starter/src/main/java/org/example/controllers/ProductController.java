package org.example.controllers;

import org.example.entities.Product;
import org.example.entities.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "index";
    }


    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable(value = "id") Long id){
        model.addAttribute("product",productRepository.findById(id));
        return "product";
    }

    @PostMapping("/product_update")
    public String updateProduct(Product product){
        productRepository.update(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model ){
        model.addAttribute("product",productRepository.add(new Product(null,null,null,null)));
        return "product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model ,@PathVariable(value = "id" ) Long id){
        productRepository.remove(id);
        return "redirect:/product";
    }
}
