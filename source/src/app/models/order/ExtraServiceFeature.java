package app.models.order;

import app.models.extraservice.ExtraService;

public class ExtraServiceFeature extends OrderFeature {

    private ExtraService service;

    public ExtraServiceFeature(IOrder order) {

        super(order);
    }

    public ExtraServiceFeature(IOrder order, ExtraService service) {

        super(order);
        this.service = service;
    }

    @Override 
    public double getTotalPrice() {

        return order.getTotalPrice() + service.getTotalPrice();
    }

    @Override
    public String getDescription() {

        return order.getDescription() + "\n" + service.display();
    }


}