package com.pojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Summary {
    private int total;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;

    private ZonedDateTime updateTime;
}
