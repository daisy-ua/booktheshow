package app.models.extraservice.snack;

import java.util.Map;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.popcorn.*;

public class PopcornSnackCreator implements SnackCreator {

    public static void setPrices(Map<String, Double> popcorns) {

        for(Map.Entry<String, Double> popcorn : popcorns.entrySet()) {

            switch(PopcornType.valueOf(popcorn.getKey())) {

                case BACON:
                    BaconPopcorn.setPrice(popcorn.getValue());
                    break;

                case CHEESE:
                    CheesePopcorn.setPrice(popcorn.getValue());
                    break;

                case CARAMEL:
                    CaramelPopcorn.setPrice(popcorn.getValue());
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public <E extends Enum<E>> Snack getSnack(E item) {

        if (item instanceof PopcornType) {

            switch ((PopcornType) item) {

                case BACON:
                    return new BaconPopcorn();

                case CHEESE:
                    return new CheesePopcorn();

                case CARAMEL:
                    return new CaramelPopcorn();

                default:
                    return new BaconPopcorn();
            }
        }

        return null;
    }
}