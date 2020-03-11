package com.example.demo.provider;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home", "form", new Form());
    }

    @RequestMapping("/submitForm")
    public String submitForm(
        final @Valid @ModelAttribute Form form,
        final BindingResult bindingResult,
        final Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("form", form);
        } else {
            model.addAttribute("result", demoService.calculateSubsetsFromForm(form));
        }
            
        return "home";
    }
}