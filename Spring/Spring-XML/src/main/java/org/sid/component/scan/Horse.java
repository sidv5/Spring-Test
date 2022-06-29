package org.sid.component.scan;

import org.springframework.stereotype.Component;

@Component
public class Horse implements Animal{
    @Override
    public String makeSound() {
        return "Neigh!";
    }
}
