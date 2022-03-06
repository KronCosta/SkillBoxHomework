import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RouteCalculatorTest {
    public List<Station> route;
    private StationIndex stationIndex;
    private Line line1, line2, line3;

    @Before
    public void setUp() {
        stationIndex = new StationIndex();
        route = new ArrayList<>();

        line1 = getLine(1, "Первая", "Петровская", "Арбузная");
        line2 = getLine(2, "Вторая", "Морковная", "Яблочная");
        line3 = getLine(3, "Третья", "Тыквенная", "Огуречная");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.add(line1.getStations().get(0));
        route.add(line1.getStations().get(1));
        route.add(line2.getStations().get(0));
        route.add(line2.getStations().get(1));

        stationIndex.addStations(line1.getStations());
        stationIndex.addStations(line1.getStations());
        stationIndex.addStations(line1.getStations());
        stationIndex.addConnection(Arrays.asList(line1.getStations().get(1), line2.getStations().get(0)));
        stationIndex.addConnection(Arrays.asList(line2.getStations().get(1), line3.getStations().get(0)));
    }

    @Test
    public void calculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getShortestRoute2() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> shortestRoute = routeCalculator.getShortestRoute(line1.getStations().get(0), line3.getStations().get(1));
        List<Object> exp = Arrays.asList(
                line1.getStations().get(0),
                line1.getStations().get(1),
                line2.getStations().get(0),
                line2.getStations().get(1),
                line3.getStations().get(0),
                line3.getStations().get(1)
        );
        assertEquals(exp,shortestRoute);
    }

    @Test
    public void getShortestRoute1() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> shortestRoute = routeCalculator.getShortestRoute(line1.getStations().get(0), line2.getStations().get(1));
        List<Object> exp = Arrays.asList(
                line1.getStations().get(0),
                line1.getStations().get(1),
                line2.getStations().get(0),
                line2.getStations().get(1)

        );
        assertEquals(exp,shortestRoute);
    }

    @Test
    public void getShortestRoute0() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> shortestRoute = routeCalculator.getShortestRoute(line1.getStations().get(0), line1.getStations().get(1));
        List<Object> exp = Arrays.asList(
                line1.getStations().get(0),
                line1.getStations().get(1)

        );
        assertEquals(exp,shortestRoute);
    }



    private Line getLine(int number, String name, String... stationNames) {
        Line line = new Line(number, name);
        Arrays.stream(stationNames)
                .map(n -> new Station(n, line))
                .forEach(line::addStation);
        return line;
    }
}
