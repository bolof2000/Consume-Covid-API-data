package com.coviddata.coviddata.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Regional {
    private String loc;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int totalConfirmed;
}
