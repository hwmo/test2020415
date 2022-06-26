package com.hwmo.test.设计模式.strategy;

import javax.sound.midi.Track;

/**
 * 策略模式:求一个有序数组的平均值
 */
public class StrategyTest {

    private Strategy strategy;
    //定义自身的引用
    private static StrategyTest test;

    public StrategyTest(Strategy strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        //有序的数据
        double []scores = {80, 82, 90, 95, 100};
        StrategyOne one = new StrategyOne();

        test = new StrategyTest(one);
        double value = test.getScore(scores);
        System.out.println(value);

        StrategyTwo tow = new StrategyTwo();
        test = new StrategyTest(tow);
        value = test.getScore(scores);
        System.out.println(value);

        StrategyThree three = new StrategyThree();
        test = new StrategyTest(three);
        value = test.getScore(scores);
        System.out.println(value);

    }

    public double getScore(double[] scores){
        return strategy.compute(scores);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

interface Strategy{
    public double compute(double[] scores);
}

class StrategyOne implements Strategy{
    @Override
    public double compute(double[] scores) {//策略一：算平均分

        double sum = 0;
        double result = 0;
        for(int i = 0; i < scores.length; i++){
            sum += scores[i];
        }
        result = sum / scores.length;
        return result;
    }
}

class StrategyTwo implements Strategy{


    @Override
    public double compute(double[] scores) {//策略二：算几何平均值

        double multi = 1;
        double result = 0;
        for(int i = 0; i < scores.length; i++){
            multi = multi * scores[i];
        }
        result = Math.pow(multi, 1.0 / scores.length);


        return result;
    }


}

class StrategyThree implements Strategy{

    @Override
    public double compute(double[] scores) {//策略三：去掉最大最小值再求平均值
        double sum = 0;
        double result = 0;
        for(int i = 1; i < scores.length - 1; i++){
            sum += scores[i];
        }
        result = sum / (scores.length - 2);
        return result;
    }
}



