package io.echokk11.clashxcustomrulesautoupdater.calories;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class MortgageCalculator {

    private static double fee = 2770068.43;  //贷款总额
    private static double pre_fee = 800000.0;  //提前还款总额
    private static double rate = 0.042D; //贷款利率
//  private static double rate = 0.0489D; //贷款利率

    private static int totalMonth = 360; //贷款期限
    private static int payMonth = 49; //已还期数
    private static int month = totalMonth - payMonth; //剩余期数
    public static void main(String[] args) {
        System.out.println("剩余本金：" + toScaledBigDecimal(fee));
        System.out.println("提前还款金额：" + toScaledBigDecimal(pre_fee));
        fee = fee - pre_fee;
        System.out.println("剩余还款本金：" + toScaledBigDecimal(fee));
        double monthRate = rate / 12;
        double monthPay = fee * monthRate * Math.pow(1 + monthRate, month) / (Math.pow(1 + monthRate, month) - 1);
        double total = monthPay * month;
        System.out.println("还款总额：" + toScaledBigDecimal(total));
        double totalInterest = total - fee;
        System.out.println("总利息：" + toScaledBigDecimal(totalInterest));
        double totalInterestRate = totalInterest / fee;
        System.out.println("总利率：" + toScaledBigDecimal(totalInterestRate).multiply(BigDecimal.valueOf(100)) + "%");
        System.out.println("每月还款额：" + toScaledBigDecimal(monthPay));
    }

    static BigDecimal toScaledBigDecimal(double in) {
        return BigDecimal.valueOf(in).setScale(2, RoundingMode.FLOOR);
    }
}
