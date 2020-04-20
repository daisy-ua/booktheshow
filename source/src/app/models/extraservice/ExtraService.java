package app.models.extraservice;

import java.util.ArrayList;
import java.util.List;

import app.models.extraservice.snack.item.Snack;

public class ExtraService {

    List<Snack> snacks;

    public ExtraService() {

        this.snacks = new ArrayList<Snack>();
    }

    public void addSnack(Snack snack) {

        this.snacks.add(snack);
    }

    public void removeSnack(Snack snack) {

        this.snacks.remove(snack);
    }

    public double getTotalPrice() {

        double amount = 0;

        for(Snack snack : snacks) {
            amount += snack.getTotalPrice();
        }

        return amount;
    }

}