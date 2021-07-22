package com.example.currencyconvertservice.ui;

import com.example.currencyconvertservice.model.Constants;
import com.example.currencyconvertservice.model.ConverterModel;
import com.example.currencyconvertservice.model.ResponseModel;
import com.example.currencyconvertservice.service.ConverterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    ConverterServiceImpl converterService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", Constants.TITLE);
        model.addAttribute("welcome", Constants.WELCOME);
        model.addAttribute("appDescription", Constants.DESCRIPTION);
        return "index";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST, produces="text/html")
    public String doConvert(@ModelAttribute ConverterModel cModel, Model model,
                            HttpServletRequest request) {
        HttpStatus status = HttpStatus.OK;
        model.addAttribute("converterModel", cModel);
        model.addAttribute("title", Constants.TITLE);
        ResponseModel responseModel = converterService.getConvertedValue(cModel.getBaseCurrency(), cModel.getTargetCurrency(),
                cModel.getSrcAmount());
        cModel.setTargetAmount(responseModel.getConvertedValue());
        cModel.setBaseCurrency(responseModel.getBaseCurrency());
        cModel.setTargetCurrency(responseModel.getTargetCurrency());
        return "convert";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.GET, produces="text/html")
    public String doConvert(Model model) {
        ConverterModel cModel = converterService.getConverterModel();
        model.addAttribute("converterModel", cModel);
        model.addAttribute("title", Constants.TITLE);
        return "convert";
    }
}
