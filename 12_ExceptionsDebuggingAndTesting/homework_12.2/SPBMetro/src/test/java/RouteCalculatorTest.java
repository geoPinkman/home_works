import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex testIndex;
    RouteCalculator testCalculator;
    Line red, blue, green;
    @Before
    protected void setUp() {
        route = new ArrayList<>();
        testIndex = new StationIndex();
        testCalculator = new RouteCalculator(testIndex);
        red = new Line(1, "red");
        blue = new Line(2, "blue");
        green = new Line(3, "green");

        Station chernish = new Station("Чернышевская", red);
        Station vostaSqr = new Station("Площадь востания", red);
        Station vladimir = new Station("Владимирская", red);
        Station pushkins = new Station("Пушкинская", red);
        Station techIns1 = new Station("Технологический институт 1", red);
        Station baltiysk = new Station("Балтийская", red);

        Station gorkovsk = new Station("Горьковская", blue);
        Station nevskPrp = new Station("Невский проспект", blue);
        Station sennySqr = new Station("Сенная площадь", blue);
        Station frunzenc = new Station("Фрунзенская", blue);

        Station primorsk = new Station("Приморская", green);
        Station vasiliyO = new Station("Василийостровская", green);
        Station aNevSqr1 = new Station("Площадь Александра Невского 1", green);
        Station elizarov = new Station("Елизаровская", green);

        red.addStation(chernish);
        red.addStation(vostaSqr); //green line connect
        red.addStation(vladimir);
        red.addStation(pushkins);
        red.addStation(techIns1); //blue line connect
        red.addStation(baltiysk);

        blue.addStation(gorkovsk);
        blue.addStation(nevskPrp); //green line connect
        blue.addStation(sennySqr);
        blue.addStation(techIns1); //red line connect
        blue.addStation(frunzenc);

        green.addStation(primorsk);
        green.addStation(vasiliyO);
        green.addStation(nevskPrp); //blue line connect
        green.addStation(vostaSqr); //red line connect
        green.addStation(aNevSqr1);
        green.addStation(elizarov);

        testIndex.addLine(red);
        testIndex.addLine(green);
        testIndex.addLine(blue);

        testIndex.addConnection(green.getStations());
        testIndex.addConnection(blue.getStations());

    }
    @Test
    public void testCalculateDurationSingleLine() {
        Station leninSqr = new Station("Площадь Ленина", red);
        Station chernish = new Station("Чернышевская", red);
        Station vostaSqr = new Station("Площадь востания", red);

        route.add(leninSqr);
        route.add(chernish);
        route.add(vostaSqr);
        assertEquals("Время в пути без пересадок", 5.0, RouteCalculator.calculateDuration(route));
    }
    @Test
    public void testCalculateDurationTwoLines() {

        Station leninSqr = new Station("Площадь Ленина", red);
        Station chernish = new Station("Чернышевская", red);
        Station vostaSqr = new Station("Площадь востания", red);
        Station gostDvor = new Station("Гостинный двор", green);

        route.add(leninSqr);
        route.add(chernish);
        route.add(vostaSqr);
        route.add(gostDvor);

        assertEquals("Время в пути с одной пересадкой", 8.5, RouteCalculator.calculateDuration(route));
    }
    @Test
    public void testCalculateDurationFreeLines() {

        Station leninSqr = new Station("Площадь Ленина", red);
        Station chernish = new Station("Чернышевская", red);
        Station vostaSqr = new Station("Площадь востания", red);
        Station gostDvor = new Station("Гостинный двор", green);
        Station sennySqr = new Station("Сенная площадь", blue);
        Station techIns2 = new Station("Технологический институт 2", blue);

        route.add(leninSqr);
        route.add(chernish);
        route.add(vostaSqr);
        route.add(gostDvor);
        route.add(sennySqr);
        route.add(techIns2);

        assertEquals("Время в пути с двумя пересадками", 14.5, RouteCalculator.calculateDuration(route));
    }
    @Test
    public void testGetShortestRouteWithoutConnections() {
        Station chernish = new Station("Чернышевская", red);
        Station vostaSqr = new Station("Площадь востания", red);
        Station vladimir = new Station("Владимирская", red);
        Station pushkins = new Station("Пушкинская", red);

        List<Station> expected = new ArrayList<>();
        expected.add(chernish);
        expected.add(vostaSqr);
        expected.add(vladimir);
        expected.add(pushkins);

        List<Station> actual = testCalculator.getShortestRoute(chernish, pushkins);

        assertEquals("Кратчайший путь без пересадок", expected, actual);
    }
    @Test
    public void testGetShortestRouteWithOneConnection() {

        Station pushkins = new Station("Пушкинская", red);
        Station techIns = new Station("Технологический институт 1", red);
        Station frunzenc = new Station("Фрунзенская", blue);

        List<Station> expected = new ArrayList<>();

        expected.add(pushkins);
        expected.add(techIns);
        expected.add(frunzenc);

        List<Station> actual = testCalculator.getShortestRoute(pushkins, frunzenc);
        assertEquals("Кратчайший путь с одной пересадкой", expected, actual);
    }

    public void testGetShortestRouteWithTwoConnection() {
        Station gorkovsk = new Station("Горьковская", blue);
        Station nevskPrp = new Station("Невский проспект", blue);
        Station vostaSqr = new Station("Площадь востания", green);
        Station vladimir = new Station("Владимирская", red);
        Station pushkins = new Station("Пушкинская", red);

        List<Station> expected = new ArrayList<>();
        expected.add(gorkovsk);
        expected.add(nevskPrp);
        expected.add(vostaSqr);
        expected.add(vladimir);
        expected.add(pushkins);

        List<Station> actual = testCalculator.getShortestRoute(gorkovsk, pushkins);

        assertEquals("Кратчайший путь с двумя пересадками", expected, actual);

    }

}
