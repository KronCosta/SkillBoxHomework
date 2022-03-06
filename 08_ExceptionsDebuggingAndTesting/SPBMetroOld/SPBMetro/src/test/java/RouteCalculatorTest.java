import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class RouteCalculatorTest {
    private StationIndex stationIndex;
    private RouteCalculator calculator;

    @Before
    public void setUp() {
        String[] lineNames = {"Первая", "Вторая", "Третья"};
        String[] stationNames = {"Петровская", "Арбузная", "Морковная", "Яблочная", "Тыквенная", "Огуречная"};
        int stationOnLines = 2;

        stationIndex = new StationIndex();
        Line lineTemp = null; //для возможности использования внутри цикла
        for (int i = 0, lineNum = 0; i < stationNames.length; i++) {
            if (i % stationOnLines == 0) {   //один раз за N итераций создаем линию
                lineTemp = new Line(lineNum + 1, lineNames[lineNum]);
                stationIndex.addLine(lineTemp);
                lineNum++;
            }
            Station temp = new Station(stationNames[i], lineTemp);
            lineTemp.addStation(temp);
            stationIndex.addStation(temp);
        }
        calculator = new RouteCalculator(stationIndex);
        //------------------------Пересадки---------------------------------
        stationIndex.addConnection(getList("Арбузная", "Морковная"));
        stationIndex.addConnection(getList("Яблочная", "Тыквенная"));
    }

    private List<Station> getList(String... temp) {
        return Stream.of(temp).map(stationIndex::getStation).collect(Collectors.toList());
    }

    @Test
    public void calculateDuration() {
        double actual = RouteCalculator.calculateDuration(
                getList("Петровская", "Арбузная", "Морковная", "Яблочная", "Тыквенная", "Огуречная"));
        double expected = 14.5;
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getShortestRoute2() {
        List<Station> shortestRoute = calculator.getShortestRoute(
                stationIndex.getStation("Петровская"),
                stationIndex.getStation("Огуречная"));
        List<Station> exp = getList("Петровская", "Арбузная", "Морковная", "Яблочная", "Тыквенная", "Огуречная");
        assertEquals(exp, shortestRoute);
    }
    @Test
    public void getShortestRoute() {
        List<Station> shortestRoute = calculator.getShortestRoute(
                stationIndex.getStation("Петровская"),
                stationIndex.getStation("Арбузная"));
        List<Station> exp = getList("Петровская", "Арбузная");
        assertEquals(exp, shortestRoute);
    }
    @Test
    public void getShortestRoute1() {
        List<Station> shortestRoute = calculator.getShortestRoute(
                stationIndex.getStation("Петровская"),
                stationIndex.getStation("Яблочная"));
        List<Station> exp = getList("Петровская", "Арбузная", "Морковная", "Яблочная");
        assertEquals(exp, shortestRoute);
    }
}