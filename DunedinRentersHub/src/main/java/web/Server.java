/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.BookingJdbcDAO;
import dao.LandlordJdbcDAO;
import dao.PropertyJdbcDAO;
import dao.RenterJdbcDAO;
import dao.ServicesJdbcDAO;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

/**
 *
 * @author zotta
 */
public class Server extends Jooby {

    BookingJdbcDAO bookingDao = new BookingJdbcDAO();
    LandlordJdbcDAO landlordDao = new LandlordJdbcDAO();
    PropertyJdbcDAO propertyDao = new PropertyJdbcDAO();
    RenterJdbcDAO renterDao = new RenterJdbcDAO();
    ServicesJdbcDAO servicesDao = new ServicesJdbcDAO();

    public Server() {
        port(8080);
        use(new Gzon());
        use(new BookingModule(bookingDao));
        use(new LandlordModule(landlordDao));
        use(new PropertyModule(propertyDao));
        use(new RenterModule(renterDao));
        use(new ServicesModule(servicesDao));
        use(new AssetModule());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");

        Server server = new Server();

        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }

}
