import core.Line;
import core.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationIndexTest {
    List<Station> route;
    ArrayList<Object> connectionStation;
    StationIndex testStationIndex;


    @BeforeEach
    void setUp() {
        route = new ArrayList<>();
        connectionStation = new ArrayList<>();
        testStationIndex = new StationIndex();


        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        route.add(new Station("Первая", line1));
        route.add(new Station("Вторая", line1));
        route.add(new Station("Третья", line2));
        route.add(new Station("Четвертая", line2));
        route.add(new Station("Пятая", line3));
        route.add(new Station("Шестая", line3));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStation() {

    }

    @Test
    void addLine() {
    }

    @Test
    void addConnection() {
    }

    @Test
    void getLine() {
    }

    @Test
    void getStation() {
    }

    @Test
    void getConnectedStations() {
    }
}