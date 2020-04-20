package app.models.extraservice.snack;

import app.models.extraservice.snack.item.SnackType;

public class SnackCreatorProducer {

    public static SnackCreator getSnackCreator(SnackType type) {

        switch (type) {

        case POPCORN:
            return new PopcornSnackCreator();
        case COLA:
            return new ColaSnackCreator();
        default:
            return null;
        }
    }
}