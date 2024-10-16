package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BunTest {

    private String name = "Название булки";
    private float price = 12.5f;

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
