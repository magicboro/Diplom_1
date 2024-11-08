package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private String expectedName = "Название ингридиента";
    private float expectedPrice = 12.5f;
    IngredientType expectedType = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

    @Test //Проверяет, что метод getName() возвращает name установленное для объекта класса Ingredient
    public void getNameIngredientTest() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test //Проверяет, что метод getPrice() возвращает price установленное для объекта класса Ingredient
    public void getPriceIngredientTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test //Проверяет, что метод getType() возвращает IngredientType установленный для объекта класса Ingredient
    public void getTypeIngredientTest() {
        assertEquals(expectedType, ingredient.getType());
    }

}
