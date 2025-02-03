package com.develop.designpattern.decorator.decoratorClient;

import com.develop.designpattern.decorator.BasicCoffee;
import com.develop.designpattern.decorator.Coffee;
import com.develop.designpattern.decorator.MilkCoffee;
import com.develop.designpattern.decorator.SugarCoffee;

public class DecoratorClient {
    public static void main(String[] args) {
        Coffee basicCoffee = new BasicCoffee();
        Coffee milkCoffee = new MilkCoffee(basicCoffee);
        Coffee sugarCoffee = new SugarCoffee(milkCoffee);
        System.out.println(sugarCoffee.getCost());
        System.out.println(sugarCoffee.getDescription());
    }
}
