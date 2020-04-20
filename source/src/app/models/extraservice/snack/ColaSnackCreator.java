package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.cola.*;
import app.models.extraservice.snack.item.popcorn.PopcornType;

public class ColaSnackCreator implements SnackCreator {

    @Override
    public Snack getColaSnack(ColaType type) {

        switch (type) {

        case ORIGINAL:
            return new ColaOriginal();

        case VANILLA:
            return new ColaVanilla();

        case ZERO:
            return new ColaZero();

        default:
            return new ColaOriginal();
        }
    }

    @Override
    public Snack getPopcornSnack(PopcornType type) {

        return null;
    }
}