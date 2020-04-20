package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.cola.ColaType;
import app.models.extraservice.snack.item.popcorn.PopcornType;

public interface SnackCreator {

    public Snack getPopcornSnack(PopcornType type);
    public Snack getColaSnack(ColaType type);
}