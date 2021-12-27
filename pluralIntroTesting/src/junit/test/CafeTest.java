package junit.test;

import org.junit.Test;

import static junit.test.CoffeeType.Espresso;
import static junit.test.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    @Test
    public void canBrewEspresso() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);   // instead of MAGIC NUMBER 7, consider constant EXPRESSO_BEANS 

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        assertEquals(7, coffee.getBeans());
        assertEquals(0, coffee.getMilk());
        assertEquals(Espresso, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(0, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(227);

        // when
        Coffee coffee = cafe.brew(Latte);

        // then
        assertEquals(Latte, coffee.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockMilk(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockBeans(0);
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequireMilk() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        cafe.brew(Latte);
    }

}