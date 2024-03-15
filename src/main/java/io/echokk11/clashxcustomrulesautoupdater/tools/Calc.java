package io.echokk11.clashxcustomrulesautoupdater.tools;

import io.echokk11.clashxcustomrulesautoupdater.tools.unit.ActivityCoefficient;
import lombok.Data;

import static io.echokk11.clashxcustomrulesautoupdater.tools.unit.Kcal.*;

@Data
public class Calc {

    //碳水大约是每公斤重摄入1~3g碳水每天，低碳1g，高碳3g
    public static final double PER_LOW_CARBOHYDRATE = 1;    //低碳
    public static final double PER_HIGH_CARBOHYDRATE = 3;   //高碳
    //蛋白质每日平均摄入量大概是2g~2.5g
    public static final double PER_PROTEIN = 2;
    //人体正常所需的脂肪量大约为每天每公斤需要0.6~0.8g
//    public static final double PER_FAT = 0.8;

    public static void main(String[] args) {
        Double weight = 78.0;
        Integer height = 178;
        Integer age = 28;

        Double caloricDeficit = 600.0;  //热量缺口

        Double bmr = new BMR(weight, height, age).result();
        System.out.printf("基础代谢:\t%s\n", bmr);
        Double total = bmr * ActivityCoefficient.Moderate;
        System.out.printf("每日总消耗:\t%s\n", total);
        Double total_in = total - caloricDeficit;
        System.out.printf("热量缺口:\t%s\n", caloricDeficit);
        System.out.printf("每日总摄入:\t%s\n", total_in);

        System.out.println("---------------低碳日---------------");
        System.out.printf("碳水摄入:\t%s\n", weight * PER_LOW_CARBOHYDRATE);
        System.out.printf("蛋白质摄入:\t%s\n", weight * PER_PROTEIN);
        System.out.printf("脂肪摄入:\t%s\n", (total_in - (weight * PER_LOW_CARBOHYDRATE * CARBOHYDRATE + weight * PER_PROTEIN * PROTEIN)) / FAT);

        System.out.println("---------------高碳日---------------");
        System.out.printf("碳水摄入:\t%s\n", weight * PER_HIGH_CARBOHYDRATE);
        System.out.printf("蛋白质摄入:\t%s\n", weight * PER_PROTEIN);
        System.out.printf("脂肪摄入:\t%s\n", (total_in - (weight * PER_HIGH_CARBOHYDRATE * CARBOHYDRATE + weight * PER_PROTEIN * PROTEIN)) / FAT);


    }
}
