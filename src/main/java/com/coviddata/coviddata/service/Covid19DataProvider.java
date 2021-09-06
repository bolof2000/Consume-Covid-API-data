package com.coviddata.coviddata.service;

import com.coviddata.coviddata.pojo.CovidData;
import com.coviddata.coviddata.pojo.Regional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class Covid19DataProvider {

    public final String url = "https://api.rootnet.in/covid19-in/stats/latest";

    @Autowired
    RestTemplate restTemplate;

    public Regional getRegionalData(String state){


        CovidData covidData = restTemplate.getForObject(url,CovidData.class);

        return Arrays.stream(covidData.getData().getRegional())
                .filter(e->e.getLoc().equalsIgnoreCase(state))
                .findAny()
                .orElse(new Regional());


    }
}
