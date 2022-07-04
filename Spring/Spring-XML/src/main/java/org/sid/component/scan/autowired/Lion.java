package org.sid.component.scan.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Lion implements FeralAnimal {

    private FoodService myFoodService;

    @Autowired
    public void doSomeMethodStuff(FoodService thisFortuneService){
        myFoodService = thisFortuneService;
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    @Override
    public String getTodaysFood() {
        return myFoodService.getFood();
    }


}



