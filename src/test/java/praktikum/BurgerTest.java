package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest{

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Test //Проверяет, что метод setBuns() устанавливает для экземпляра класса Burger соответствующее значение Bun
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test //Проверяет, что метод addIngredient() добавляет соответствующий ингридиент в список ingredients
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test //Проверяет, что метод removeIngredient() удаляет соответствующий ингридиент из списка ingredients
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(1);

        Assert.assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test //Проверяет, что метод moveIngredient() меняет индекс соответствующего ингридиента из списка ingredients на заданный
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test //Проверяет, что метод получения цены getPrice() считает цену бургера корректно
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(333.333f);
        when(ingredient.getPrice()).thenReturn(222.222f);
        when(ingredient1.getPrice()).thenReturn(111.111f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        Assert.assertEquals(999.999, burger.getPrice(), 0.001);
    }

    @Test //Проверяет, что метод получения чека на бургер выводится корректно
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Bun Name");
        when(bun.getPrice()).thenReturn(111.111f);

        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("Sauce Name");
        when(ingredient.getPrice()).thenReturn(222.222f);

        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("Filling Name");
        when(ingredient1.getPrice()).thenReturn(333.333f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        String expectedReceipt = String.format("(==== Bun Name ====)\r\n= sauce Sauce Name =\r\n= filling Filling Name =\r\n(==== Bun Name ====)\r\n\r\nPrice: 777,776978\r\n");

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}