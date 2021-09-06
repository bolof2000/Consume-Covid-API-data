package com.coviddata.coviddata.pojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Summary {
    private int total;
    private int intconfirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;
}
