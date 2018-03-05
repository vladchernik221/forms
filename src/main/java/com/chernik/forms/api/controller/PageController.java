package com.chernik.forms.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/form/{formId}")
    public String getFormPage() {
        return "form";
    }

    @RequestMapping("/form/new")
    public String getNewFormPage() {
        return "form";
    }

    @RequestMapping("/form")
    public String getFormsPage() {
        return "form_list";
    }

    @RequestMapping("/quiz/{formId}")
    public String getQuizPage() {
        return "quiz";
    }
}
