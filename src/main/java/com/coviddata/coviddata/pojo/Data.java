package com.coviddata.coviddata.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Data {

    private Summary summary;
    private Regional[] regional;
}
