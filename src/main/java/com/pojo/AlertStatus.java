package com.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class AlertStatus {
    private String alertLevel;
    private List<String> measureToBeTaken;
    private Regional regional;
}
