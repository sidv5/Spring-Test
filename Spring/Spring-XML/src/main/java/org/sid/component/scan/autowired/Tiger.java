package org.sid.component.scan.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tiger implements FeralAnimal {

    private FoodService myFoodService;

    // Constructor Autowired annotation is optional after Spring 4.3
    @Autowired
    public Tiger(FoodService foodService){
        myFoodService = foodService;
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }

    @Override
    public String getTodaysFood() {
        return myFoodService.getFood();
    }


}



