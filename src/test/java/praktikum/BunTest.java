package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                {"white bun", 0},
                {"black bun", 900},
                {"", 800.123f},
        };
    }

    @Test //Проверяет, что метод getName() возвращает name установленное для объекта класса Bun
    public void getNameBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test //Проверяет, что метод getPrice() возвращает price установленное для объекта класса Bun
    public void getPriceBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.001);
    }
}
