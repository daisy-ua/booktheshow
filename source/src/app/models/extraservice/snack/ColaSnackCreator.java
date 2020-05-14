package app.models.extraservice.snack;

import java.util.Map;

import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.cola.*;

public class ColaSnackCreator implements SnackCreator {

    public static void setPrices(Map<String, Double> colas) {

        for (Map.Entry<String, Double> cola : colas.entrySet()) {

            switch (ColaType.valueOf(cola.getKey())) {

                case ORIGINAL:
                    ColaOriginal.setPrice(cola.getValue());
                    break;

                case VANILLA:
                    ColaVanilla.setPrice(cola.getValue());
                    break;

                case ZERO:
                    ColaZero.setPrice(cola.getValue());
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public <E extends Enum<E>> Snack getSnack(E item) {

        if (item instanceof ColaType) {

            switch ((ColaType) item) {

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