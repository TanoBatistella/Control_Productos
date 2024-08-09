package com.example.product_management.controller;

   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Controller;
   import org.springframework.ui.Model;
   import org.springframework.web.bind.annotation.*;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;

   @Controller
   @RequestMapping("/products")
   public class ProductController {

       @Autowired
       private ProductService productService;

       @GetMapping
       public String listProducts(Model model) {
           model.addAttribute("products", productService.getAllProducts());
           return "products";
       }

       @GetMapping("/new")
       public String newProductForm(Model model) {
           model.addAttribute("product", new Product());
           return "new-product";
       }

       @PostMapping
       public String saveProduct(@ModelAttribute Product product) {
           productService.saveProduct(product);
           return "redirect:/products";
       }

       @GetMapping("/edit/{id}")
       public String editProductForm(@PathVariable Long id, Model model) {
           model.addAttribute("product", productService.getProductById(id).orElseThrow());
           return "edit-product";
       }

       @PostMapping("/update")
       public String updateProduct(@ModelAttribute Product product) {
           productService.saveProduct(product);
           return "redirect:/products";
       }

       @GetMapping("/delete/{id}")
       public String deleteProduct(@PathVariable Long id) {
           productService.deleteProduct(id);
           return "redirect:/products";
       }
   }