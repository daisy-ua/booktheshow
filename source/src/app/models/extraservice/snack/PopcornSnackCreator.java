package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.popcorn.*;
import app.models.extraservice.snack.item.cola.ColaType;

public class PopcornSnackCreator implements SnackCreator {

    @Override
    public Snack getPopcornSnack(PopcornType type) {

        switch (type) {

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

    @Override
    public Snack getColaSnack(ColaType type) {

        return null;
    }
}