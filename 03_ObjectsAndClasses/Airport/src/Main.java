import com.skillbox.airport.Airport;

import java.util.Date;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {//add lIb

    public static final long HOUR = 3600 * 1000;

    public static void main(String[] args) {


        Airport airport = Airport.getInstance();

//       System.out.println(airport.getAllAircrafts());
//        System.out.println("Кол-во самолетов: " + airport.getAllAircrafts().size());
        Date now = new Date();

        airport.getTerminals()
                .stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getDate().after(now))
                .filter(flight -> flight.getDate().getTime() <= (now.getTime() + HOUR * 2))
                .filter(flight -> flight.getType().equals(DEPARTURE))
                .forEach(System.out::println);


    }
}

