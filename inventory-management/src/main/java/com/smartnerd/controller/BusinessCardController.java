package com.smartnerd.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.smartnerd.service.Service;
@Controller
public class BusinessCardController {
    @Autowired
    private Service BusinessCardService;
    @RequestMapping(value = "/generatebusinesscard", method = RequestMethod.GET)
    public ModelAndView businesscard(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("generatebusinesscard");
        return model;
    }
}