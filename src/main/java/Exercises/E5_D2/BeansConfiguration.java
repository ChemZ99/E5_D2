package Exercises.E5_D2;

import Exercises.E5_D2.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfiguration {
    @Bean
    Topping getCheese() {
        return new Topping("cheese",92,0.69);
    }
    @Bean
    Topping getHam() {
        return new Topping("ham",35,0.99);
    }
    @Bean
    Topping getOnions() {
        return new Topping("Onions",22,0.69);
    }
    @Bean
    Topping getPineapple() {
        return new Topping("pineapple",24,0.79);
    }
    @Bean
    Topping getSalami() {
        return new Topping("salami",86,0.99);
    }
    @Bean
    Pizza getMargherita() {
        return new Pizza("margherita",1104,4.99, new ArrayList<Topping>());
    }
    @Bean
    Pizza getHawaaiana() {
        List<Topping> ingredients = new ArrayList<Topping>();
        ingredients.add(getHam());
        ingredients.add(getPineapple());
        return new Pizza("hawaaian",1024,6.49,ingredients);
    }
    @Bean
    Pizza getSalamiPizza() {
        List<Topping> ingredients = new ArrayList<Topping>();
        ingredients.add(getSalami());
        return new Pizza("salami",1160,5.99,ingredients);
    }
    @Bean
    Drink getLemonade() {
        return new Drink("Lemonade","0.33l",128,1.29);
    }
    @Bean
    Drink getWater() {
        return new Drink("Water","0,5l",0,1.29);
    }
    @Bean
    Drink getWine() {
        return new Drink("Wine","0,75l, 13%",607,7.49);
    }
    /*@Bean
    void menu() {
        System.out.println("PIZZAS");
        System.out.println(getMargherita().toString());
        System.out.println(getHawaaiana().toString());
        System.out.println(getSalamiPizza().toString());
        System.out.println("TOPPINGS");
        System.out.println(getCheese().toString());
        System.out.println(getHam().toString());
        System.out.println(getOnions().toString());
        System.out.println(getPineapple().toString());
        System.out.println(getSalami().toString());
        System.out.println("DRINKS");
        System.out.println(getLemonade().toString());
        System.out.println(getWater().toString());
        System.out.println(getWine().toString());
    }*/
    @Bean
    Menu fullMenu() {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(getMargherita());
        pizzaList.add(getHawaaiana());
        pizzaList.add(getSalamiPizza());
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(getCheese());
        toppingList.add(getHam());
        toppingList.add(getOnions());
        toppingList.add(getPineapple());
        toppingList.add(getSalami());
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(getWater());
        drinkList.add(getLemonade());
        drinkList.add(getWine());
        return new Menu(pizzaList,toppingList,drinkList);
    }
    @Bean
    Tavolo getTavolo1(@Value("${E5D2Application.coperto}") double costoCoperto) {
        return new Tavolo(1,12,costoCoperto,StatoTavolo.LIBERO);
    }
    @Bean
    Ordine getExampleOrder(@Value("${E5D2Application.coperto}") double costoCoperto) {
        List<Pizza> pizze = new ArrayList<>();
        pizze.add(getMargherita());

        List<Drink> bere = new ArrayList<>();
        bere.add(getWater());

        return new Ordine(1,pizze,bere,StatoOrdine.IN_CORSO,costoCoperto,11,LocalDateTime.now());
    }
}
