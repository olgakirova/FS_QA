package ru.cft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
public class CafeDemo {

    Cafe cafe = null;

    @BeforeEach
    public void before_each() {
        System.out.println("create cafe");
        cafe = new Cafe();
    }



    @Test
    public void testRestock() {

        cafe.restockBeans(10);
        cafe.restockBeans(10);

        cafe.restockMilk(4);
        cafe.restockMilk(4);

        Assertions.assertEquals(20, cafe.getBeansInStock());
        Assertions.assertEquals(8, cafe.getMilkInStock());
    }

    @Test
    public void canBrewEspresso() {

        cafe.restockBeans(7);

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assertions.assertNotEquals(coffee, null);
        Assertions.assertEquals(coffee.getType(), CoffeeType.Espresso);
    }
    @Test
    public void canBrewEspresso2() {

        cafe.restockBeans(20);

        Coffee coffee = cafe.brew(CoffeeType.Espresso, 2);

        Assertions.assertNotEquals(coffee, null);
        Assertions.assertEquals(6, cafe.getBeansInStock());
    }

    @Test
    public void testEspressoGood() {

        cafe.restockBeans(7);

        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        Assertions.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void testEspressoGood2() {

        cafe.restockBeans(7);

        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        assertThat(7).isEqualTo(coffee.getBeans());
    }


    @Test
    public void spent() {

        int beans_start = 20;
        int milk_start = 500;
        CoffeeType type = CoffeeType.Latte;

        cafe.restockBeans(beans_start);
        cafe.restockMilk(milk_start);

        Coffee coffee = cafe.brew(type);

        int beans_left = beans_start - type.getRequiredBeans();
        int milk_left = milk_start - type.getRequiredMilk();
        Assertions.assertEquals(beans_left, cafe.getBeansInStock());
        Assertions.assertTrue(beans_left == cafe.getBeansInStock());
        Assertions.assertEquals(milk_left, cafe.getMilkInStock());
    }

    @Test
    public void canBrewLatte() {

        cafe.restockBeans(7);

        Coffee coffee = null;

        try {
            coffee = cafe.brew(CoffeeType.Latte);
        } catch (Exception e) {
            coffee = null;
            System.out.println("Exception thrown");
        }

        Assertions.assertNotNull(coffee);
    }

    @Test
    public void testFile() {

        String content = null;

        try {
            content = new Scanner(new File("src/files/file.txt")).next();
        } catch (Exception e) {
            Assertions.assertNotNull(null);
        }

        System.out.println("file content: " + content);


        cafe.restockBeans(7);


        CoffeeType type = CoffeeType.Latte;
        if (content.equals("Espresso")) {
            type = CoffeeType.Espresso;
        }

        System.out.println("type: " + type.getRequiredBeans() + ", " + type.getRequiredMilk());
        Coffee coffee = cafe.brew(type);

        Assertions.assertEquals(type, coffee.getType());
    }
}
