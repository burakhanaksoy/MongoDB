package ba.springMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("burakhan",8,false)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                230,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("Mahmut",8,false)
                )
        );

        hotelRepository.deleteAll();
//        List<Hotel> hotels = Arrays.asList(marriot,ibis);
        hotelRepository.save(marriot);
        hotelRepository.save(ibis);

    }

}
