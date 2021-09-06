package com.coviddata.coviddata.controller;

import com.coviddata.coviddata.pojo.AlertStatus;
import com.coviddata.coviddata.pojo.Data;
import com.coviddata.coviddata.service.AlertService;
import com.coviddata.coviddata.service.Covid19DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("india")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private Covid19DataProvider covid19DataProvider;



    @GetMapping("/{state}")
    public AlertStatus GetAlertAboutRegion(@PathVariable String state){

        return alertService.GetAlertAboutRegion(state);
    }

    @GetMapping("/all")
    public Data getAllData(){
    return  covid19DataProvider.getAllData();
    }

    @GetMapping("/")
    public Data getAllData2(){
        return  covid19DataProvider.getAllData();
    }
}

