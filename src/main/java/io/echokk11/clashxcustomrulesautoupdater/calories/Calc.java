package io.echokk11.clashxcustomrulesautoupdater.calories;

import lombok.Data;

@Data
public class Calc {

    //人体正常所需要的碳水大约是每公斤重摄入2~3g碳水每天
    public static final double PER_CARBOHYDRATE = 2;
    //蛋白质每日平均摄入量大概是1.2g~1.5g
    public static final double PER_PROTEIN = 1.5;
    //人体正常所需的脂肪量大约为每天每公斤需要0.6~0.8g
    public static final double PER_FAT = 0.8;

    public static final int KCAL_CARBOHYDRATE = 4;   //碳水1g=4Kcal
    public static final int KCAL_PROTEIN = 4;    //蛋白质1g=4Kcal
    public static final int KCAL_FAT = 9;    //脂肪=9Kcal

    private final double weight;

    public Calc(double weight) {
        this.weight = weight;
    }

    public void run() {
        int c = Double.valueOf(weight * PER_CARBOHYDRATE).intValue();
        int p = Double.valueOf(weight * PER_PROTEIN).intValue();
        int f = Double.valueOf(weight * PER_FAT).intValue();
        System.out.printf("每天需要摄入%dg碳水，%dg蛋白质，%dg脂肪%n", c, p, f);
        int per_day_kcal = c * KCAL_CARBOHYDRATE + p * KCAL_PROTEIN + f * KCAL_FAT;
        System.out.printf("每天的热量摄入约为%d大卡%n", per_day_kcal);
    }

    public static void main(String[] args) {
        new Calc(85.0).run();
    }
}
