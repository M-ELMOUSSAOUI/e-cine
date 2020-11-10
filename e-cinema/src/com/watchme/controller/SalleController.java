package com.watchme.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.watchme.models.Salle;
import com.watchme.service.SalleService;

@Controller
@RequestMapping("salles")
public class SalleController {
	 private SalleService sallesService;

	    @Autowired
	    public void setCustomerService(SalleService salleService) {
	        this.sallesService = salleService;
	    }

	    @GetMapping
	    public String index() {
	        return "redirect:/salles/1";
	    }

	    @GetMapping(value = "/{pageNumber}")
	    public String list(@PathVariable Integer pageNumber, Model model) {
	        Page<Salle> page = sallesService.getList(pageNumber);

	        int current = page.getNumber() + 1;
	        int begin = Math.max(1, current - 5);
	        int end = Math.min(begin + 10, page.getTotalPages());

	        model.addAttribute("list", page);
	        model.addAttribute("beginIndex", begin);
	        model.addAttribute("endIndex", end);
	        model.addAttribute("currentIndex", current);

	        return "salles/list";

	    }

	    @GetMapping("/add")
	    public String add(Model model) {

	        model.addAttribute("salle", new Salle());
	        return "salles/form";

	    }

	    @GetMapping("/edit/{id}")
	    public String edit(@PathVariable Long id, Model model) {

	        model.addAttribute("salle", sallesService.get(id));
	        return "salles/form";

	    }

	    @PostMapping(value = "/save")
	    public String save(Salle customer, final RedirectAttributes ra) {

	        Salle save = sallesService.save(customer);
	        ra.addFlashAttribute("successFlash", "Salle a été bien ajouté.");
	        return "redirect:/salles";

	    }

	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable Long id) {

	        sallesService.delete(id);
	        return "redirect:/salles";

	    }

}
