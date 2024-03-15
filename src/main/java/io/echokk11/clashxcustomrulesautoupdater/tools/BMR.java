package io.echokk11.clashxcustomrulesautoupdater.tools;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BMR {
    private Double weight;
    private Integer height;
    private Integer age;

    public Double result() {
        return 66.0 + (13.7 * weight) + (5 * height) - (6.8 * age);
    }

}
