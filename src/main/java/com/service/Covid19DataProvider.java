package com.service;

import com.pojo.CovidData;
import com.pojo.Data;
import com.pojo.Regional;
import com.pojo.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class Covid19DataProvider {

    public final String url = "https://api.rootnet.in/covid19-in/stats/latest";

    @Autowired
    private RestTemplate restTemplate;


    public Regional getRegionalData(String state){
        CovidData covidData = restTemplate.getForObject(url,CovidData.class);
        return Arrays.stream(covidData.getData().getRegional())
                .filter(e->e.getLoc().equalsIgnoreCase(state))
                .findAny().orElse(new Regional());

    }

    private Summary getAllSummary(){
        CovidData covidData = restTemplate.getForObject(url,CovidData.class);
        Summary summary = covidData.getData().getSummary();
        summary.setUpdateTime(covidData.getLastRefreshed());
        return summary;
    }

    public Data getAllData(){
        CovidData covidData = restTemplate.getForObject(url,CovidData.class);
        Data data = covidData.getData();
        return data;
    }


}
