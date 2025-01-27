import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void testHasCity() {
        City city1 = new City("Halifax", "NS");
        City city2 = new City("Edmonton", "AB");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void testDeleteCity() {
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testCountCities() {
        assertEquals(0, list.countCities());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.countCities());
    }
}
