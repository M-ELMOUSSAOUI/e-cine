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

import com.watchme.models.Programme;
import com.watchme.service.ProgrammeService;

@Controller
@RequestMapping("programmes")
public class ProgrammeController {

	 private ProgrammeService programmesService;

	    @Autowired
	    public void setCustomerService(ProgrammeService programmeService) {
	        this.programmesService = programmeService;
	    }

	    @GetMapping
	    public String index() {
	        return "redirect:/programmes/1";
	    }

	    @GetMapping(value = "/{pageNumber}")
	    public String list(@PathVariable Integer pageNumber, Model model) {
	        Page<Programme> page = programmesService.getList(pageNumber);

	        int current = page.getNumber() + 1;
	        int begin = Math.max(1, current - 5);
	        int end = Math.min(begin + 10, page.getTotalPages());

	        model.addAttribute("list", page);
	        model.addAttribute("beginIndex", begin);
	        model.addAttribute("endIndex", end);
	        model.addAttribute("currentIndex", current);

	        return "programmes/list";

	    }

	    @GetMapping("/add")
	    public String add(Model model) {

	        model.addAttribute("salle", new Programme());
	        return "programme/form";

	    }

	    @GetMapping("/edit/{id}")
	    public String edit(@PathVariable Long id, Model model) {

	        model.addAttribute("salle", programmesService.get(id));
	        return "programmes/form";

	    }

	    @PostMapping(value = "/save")
	    public String save(Programme programme, final RedirectAttributes ra) {

	        Programme save = programmesService.save(programme);
	        ra.addFlashAttribute("successFlash", "Le programme a été bien ajouté.");
	        return "redirect:/programmes";

	    }

	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable Long id) {

	      programmesService.delete(id);
	        return "redirect:/programmes";

	    }
}
