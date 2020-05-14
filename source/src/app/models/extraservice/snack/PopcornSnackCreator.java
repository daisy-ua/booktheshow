package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.popcorn.*;

public class PopcornSnackCreator implements SnackCreator {

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