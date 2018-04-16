package cz.etn.etnshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String list(Model myModel) {
		myModel.addAttribute("products", productService.getProducts());
		return "product/list";
	}
	
	@GetMapping("/showAddForm")
	public String add(Model myModel) {
		Product myProduct = new Product();
		myModel.addAttribute("product", myProduct);
		return "product/product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product myProduct) {
		
		productService.saveProduct(myProduct);		
		return "redirect:/product/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("productId") int theId, Model myModel) {
		
		Product myProduct = productService.getProduct(theId);
		myModel.addAttribute("product", myProduct);
		return "product/product-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
		productService.deleteProduct(theId);
		return "redirect:/product/list";
	}
	
	public Product getProduct(int theId) {
		return productService.getProduct(theId);
	}
}
