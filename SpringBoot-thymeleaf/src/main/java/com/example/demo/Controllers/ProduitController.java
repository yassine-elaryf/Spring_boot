package com.example.demo.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Produit> produits = produitRepository.chercher("%" + mc + "%", PageRequest.of(p, s));
		model.addAttribute("ListProduits", produits.getContent());
		System.out.println(produits);
		int[] pages = new int[produits.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "produits";
	}

	@GetMapping(value = "delete")
	public String delete(Long id, String motCle, int page, int size) {
		produitRepository.deleteById(id);
		;
		return "redirect:/index?page=" + page + "&size=" + size + "&motCle=" + motCle;

	}

	@GetMapping(value = "/form")
	public String formProduit(Model model) {
		model.addAttribute("produit", new Produit());
		return "FormProduit";

	}

	@PostMapping(value = "/save")
	public String save(Model model, @Valid Produit produit, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormProduit";
		produitRepository.save(produit);
		return "Confirmațion";
	}
	@GetMapping(value = "/edit")
	public String edit(Model model, Long id){
	    Produit p=produitRepository.findById(id).get();
	   model.addAttribute("produit", p);
	    return "EditProduit";
}
}