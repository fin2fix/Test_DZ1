package shop;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/*
  1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
  2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
  3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
  */

public class ShopTest {
    Product prod1;
    Product prod2;
    Product prod3;
    Product prod4;
    Product prod5;
    Shop newShop;

    @BeforeEach
    void setUp() {
        prod1 = new Product(100, "milk");
        prod2 = new Product(40, "bread");
        prod3 = new Product(120, "eggs");
        prod4 = new Product(650, "meat");
        prod5 = new Product(350, "chicken");
        newShop = new Shop(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
    }

    @AfterEach
    void tearDown() {
        prod1 = null;
        prod2 = null;
        prod3 = null;
        prod4 = null;
        prod5 = null;
        newShop = null;
    }

    @Test
    @DisplayName("Проверка сортировки листа с продуктами")
    void sortProductsByPrice() {
        List<Product> expected = Arrays.asList(prod2, prod1, prod3, prod5, prod4);
        List<Product> actual = newShop.sortProductsByPrice();
        boolean flag = false;
        if (expected.size() == actual.size()) {
            for (int i = 0; i < expected.size(); i++) {
                if (!(expected.get(i).equals(actual.get(i)))) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        assertThat(flag).isEqualTo(true);}

    @Test
    @DisplayName("Проверка поиска самого дорогого продукта")
    void getMostExpensiveProduct() {
        assertEquals(prod4, newShop.getMostExpensiveProduct());
        // assertThat(newShop.getMostExpensiveProduct()).isEqualTo(prod4); // второй вариант решения
    }
}