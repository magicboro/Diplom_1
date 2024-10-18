package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BunTest {

    private String expectedName = "Название булки";
    private float expectedPrice = 12.5f;

    @Test //Проверяет, что метод getName() возвращает name установленное для объекта класса Bun
    public void getNameBunTest() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
    }

    @Test //Проверяет, что метод getPrice() возвращает price установленное для объекта класса Bun
    public void getPriceBunTest() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }
}
