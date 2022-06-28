package org.sid.component.scan;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component("myComponentAnimal")
public class Dog implements Animal {

	@Override
	public String makeSound() {
		return "Bark!";
	}
}
