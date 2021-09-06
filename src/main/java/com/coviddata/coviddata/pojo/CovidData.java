package com.coviddata.coviddata.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class CovidData {

    // model for the external api to be called

    //todo define attributes for the covidData api

    private boolean success;
    private Data data;
    private ZonedDateTime lastRefreshed;
    private ZonedDateTime lastOriginUpdate;
}
