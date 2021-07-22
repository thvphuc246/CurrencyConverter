package com.example.currencyconvertservice.service;

import com.example.currencyconvertservice.model.Constants;
import com.example.currencyconvertservice.model.ConversionRate;
import com.example.currencyconvertservice.model.ConverterModel;
import com.example.currencyconvertservice.model.ResponseModel;
import com.example.currencyconvertservice.model.Error;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RestController
public class ConverterServiceImpl implements ConverterService {

    @Override
    public ConverterModel getConverterModel() {
        ConverterModel cm = new ConverterModel();
        return cm;
    }

    @Override
    @RequestMapping(value = "/convert", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public ResponseModel getConvertedValue(
            @RequestParam(value = "source", defaultValue = "EUR") String source,
            @RequestParam(value = "target", defaultValue = "USD") String target,
            @RequestParam(value = "amount", defaultValue = "0.0") double amount) {
        ResponseModel rm = new ResponseModel();
        rm.setBaseCurrency(source);
        rm.setTargetCurrency(target);
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(Constants.API_BASE_URL);
        urlBuilder.queryParam("access_key", Constants.API_KEY);
        urlBuilder.queryParam("base", source);
        urlBuilder.queryParam("symbols", target);
        String endPoint = urlBuilder.build().encode().toUriString();
//        System.out.println(endPoint);
        RestTemplate restTemplate = new RestTemplate();
        ConversionRate rates = restTemplate.getForObject(endPoint, ConversionRate.class);

        if (!rates.getRates().isEmpty()) {
            String cRate = rates.getRates().get(target);
            double cVal = Double.valueOf(cRate) * amount;
            rm.setConvertedValue(cVal);
        } else {
            rm.setError(new Error("Unable to convert conrrency", "400"));
            rm.setConvertedValue(Double.MIN_VALUE);
        }

        return rm;

    }
}
