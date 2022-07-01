package org.sid.component.scan.autowired;

import org.springframework.stereotype.Component;

@Component
public class FavouriteFoodService implements FoodService {
    @Override
    public String getFood() {
        return "Meat";
    }
}
