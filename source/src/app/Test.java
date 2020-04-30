package app;

import app.models.affiche.Movie;
import app.models.affiche.Session;
import app.models.extraservice.ExtraService;
import app.models.extraservice.snack.SnackCreator;
import app.models.extraservice.snack.SnackCreatorProducer;
import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.SnackType;
import app.models.extraservice.snack.item.cola.ColaType;
import app.models.extraservice.snack.item.popcorn.PopcornType;
import app.models.extraservice.snack.size.SizeType;
import app.models.order.ExtraServiceFeature;
import app.models.order.IOrder;
import app.models.order.Order;
import app.models.payment.PayByCard;
import app.models.payment.PayStrategy;
import app.models.theatre.*;
import app.models.seat.*;

public class Test {

    public static void test() {

        // firstLoad();
        // snackCreation();
        reservation();
    }

    public static void firstLoad() {

        try {
            Theatre theatre = TheatreCreator.getLavinaMultiplex();

            Movie movie = theatre.getAffiche().get(0);
            System.out.println(movie.getTitle() + "\n" + movie.getSessionsTime());

            int hallId = movie.getSessionDetails(0).getHallId();

            Seat[][] seats = theatre.getHallById(hallId).getSeats();

            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {

                    System.out.print(seats[i][j].getPrice() + "    ");
                }
                System.out.println();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void snackCreation() {

        try {           
            
            SnackCreator snackCreator = SnackCreatorProducer.getSnackCreator(SnackType.POPCORN);

            Snack bPopcorn = snackCreator.getPopcornSnack(PopcornType.BACON);

            System.out.println(bPopcorn.getDescription());

            bPopcorn.setSize(SizeType.SMALL);
            System.out.println(bPopcorn.getDescription());

            bPopcorn.setSize(SizeType.MEDIUM);
            System.out.println(bPopcorn.getDescription());

            snackCreator = SnackCreatorProducer.getSnackCreator(SnackType.COLA);
            Snack oCola = snackCreator.getColaSnack(ColaType.ORIGINAL);

            System.out.println(oCola.getDescription());

            oCola.setSize(SizeType.MEDIUM);
            System.out.println(oCola.getDescription());

            oCola = snackCreator.getColaSnack(ColaType.ZERO);
            System.out.println(oCola.getDescription());

            oCola.setSize(SizeType.MEDIUM);
            System.out.println(oCola.getDescription());

            oCola.setQuantity(2);
            System.out.println(oCola.getDescription());


            ExtraService service = new ExtraService();
            
            service.addSnack(bPopcorn);
            service.addSnack(oCola);

            System.out.println(service.getTotalPrice());
                

        }
        catch(Exception e) {

            e.printStackTrace();
        }

    }

    public static void reservation() {

        try {

            Theatre theatre = TheatreCreator.getLavinaMultiplex();

            Movie movie = theatre.getAffiche().get(0);

            Session session = movie.getSessionDetails(0);

            int hallId = session.getHallId();

            Seat[][] seats = theatre.getHallById(hallId).getSeats();

            IOrder order = new Order(movie, session, seats[0][0]);
            System.out.println(order.getTotalPrice());


            ExtraService service = new ExtraService();

            SnackCreator snackCreator = SnackCreatorProducer.getSnackCreator(SnackType.POPCORN);
            Snack bPopcorn = snackCreator.getPopcornSnack(PopcornType.BACON);

            snackCreator = SnackCreatorProducer.getSnackCreator(SnackType.COLA);
            Snack oCola = snackCreator.getColaSnack(ColaType.ORIGINAL);

            
            service.addSnack(bPopcorn);
            service.addSnack(oCola);

            System.out.println(service.getTotalPrice());

            IOrder extraOrder = new ExtraServiceFeature(order, service);
            System.out.println(extraOrder.getTotalPrice());
            System.out.println(extraOrder.getDescription());

            PayStrategy strategy = new PayByCard();
            System.out.println(strategy.makePayment(extraOrder.getTotalPrice()));


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}