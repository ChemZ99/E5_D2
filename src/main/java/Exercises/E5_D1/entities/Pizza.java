package Exercises.E5_D1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    private final String base1 = "tomato";

    private final String base2 = "cheese";

    private String name;

    private int calories;

    private double price;

    private List<Topping> toppings = new ArrayList<>();
}
