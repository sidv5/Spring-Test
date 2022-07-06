package org.sid.component.scan.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wolf implements FeralAnimal {

    private FoodService myFoodService;

    @Autowired
    public void setFortuneService(FoodService thisFortuneService){
        myFoodService = thisFortuneService;
    }

    @Override
    public String makeSound() {
        return "Howl!";
    }

    @Override
    public String getTodaysFood() {
        return myFoodService.getFood();
    }


}



