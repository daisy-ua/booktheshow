package app.models.extraservice.snack;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.cola.*;

public class ColaSnackCreator implements SnackCreator {

    @Override
    public <E extends Enum<E>> Snack getSnack(E item) {

        if(item instanceof ColaType) {

            switch ((ColaType)item) {
    
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

        return null;
    }
}