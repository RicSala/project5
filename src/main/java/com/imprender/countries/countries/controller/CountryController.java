package com.imprender.countries.countries.controller;


import com.imprender.countries.countries.model.SeveralMatchesException;
import com.imprender.countries.countries.repository.CountryRepository;
import com.imprender.countries.countries.model.Country;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CountryController {


    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("countries", countryRepository.getAllCountries());
        return "index";
    }

    @RequestMapping("index.html")
    public String indexRedirect() {
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String reorder(WebRequest request) {
        if (request.getParameter("typeOfOrder").equals("byPupolation")) {
            countryRepository.sortByPopulation();
        } else {
            countryRepository.sortByName();
        }
        return "redirect:/";
    }

    @RequestMapping("details/{name}")
    public String details(@PathVariable String name, ModelMap modelMap) {
        Country country = null;
        try {
            country = countryRepository.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        modelMap.put("country", country);
        return "details";
    }


}
