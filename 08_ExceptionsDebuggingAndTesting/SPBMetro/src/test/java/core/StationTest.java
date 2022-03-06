package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    Station station;
    Line first = new Line(1, "Зеленая");

    @BeforeEach
    void setUp(){
        station = new Station("Диванная", first);
    }
    @Test
    void getLine() {
        String actual = station.getLine().toString();
        String expected = first.toString();
        assertEquals(expected, actual);
    }
    @Test
    void getName() {
        String actual = station.getName();
        String expected = "Диванная";
        assertEquals(expected, actual);
    }
    @AfterEach
    void tearDown() {
    }
}