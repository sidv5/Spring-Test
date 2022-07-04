package org.sid.component.scan.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fox implements FeralAnimal {

    @Autowired
    private FoodService myFoodService;

    @Override
    public String makeSound() {
        return "Scream!";
    }

    @Override
    public String getTodaysFood() {
        return myFoodService.getFood();
    }


}



