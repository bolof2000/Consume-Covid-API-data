package com.service;

import com.pojo.AlertStatus;
import com.pojo.Regional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {

    @Autowired
    private Covid19DataProvider covid19DataProvider;

    public AlertStatus GetAlertAboutRegion(String state){
        AlertStatus alertStatus = new AlertStatus();

        Regional regional = covid19DataProvider.getRegionalData(state);
        alertStatus.setRegional(regional);
        if(regional.getTotalConfirmed() < 1000){
            alertStatus.setAlertLevel("GREEN");
            alertStatus.setMeasureToBeTaken(Arrays.asList("EVERYTHING IS NORMAL ! ! "));
        }else if(regional.getTotalConfirmed() > 1000 && regional.getTotalConfirmed() < 10000){
            alertStatus.setAlertLevel("ORANGE");
            alertStatus.setMeasureToBeTaken(Arrays.asList("Only Essential services are allowed List of services that come under essential service"));
        }
        else{

            alertStatus.setAlertLevel("RED");
            alertStatus.setMeasureToBeTaken(Arrays.asList("Absolute lock-down Only Medical and food services are allowed here"));
        }

        return alertStatus;

    }

}
