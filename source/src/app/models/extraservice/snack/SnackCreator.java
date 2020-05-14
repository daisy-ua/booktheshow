package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;

public interface SnackCreator {

    public <E extends Enum<E>> Snack getSnack (E item);
}