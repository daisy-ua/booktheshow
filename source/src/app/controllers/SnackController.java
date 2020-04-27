package app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import app.models.extraservice.snack.SnackCreator;
import app.models.extraservice.snack.SnackCreatorProducer;
import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.SnackType;
import app.models.extraservice.snack.item.cola.ColaType;
import app.models.extraservice.snack.item.popcorn.PopcornType;
import app.models.extraservice.snack.size.SizeType;
import app.views.SnackOrder;
import app.views.SnackPick;

public class SnackController { // TODO: addItemListener

    private SnackOrder snackOrderView;
    private SnackPick snackPickView;
    private Snack snack;

    public SnackController(SnackOrder snackOrderView) {

        this.snackOrderView = snackOrderView;
        this.snackPickView = snackOrderView.getSnackPick();
    }

    public void initController() {

        initDefaultSnackPickView();
        initSnackPickEvent();
    }

    private void initSnackPickEvent() {

        snackPickView.getSnackType().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox<String> type = (JComboBox<String>) e.getSource();
                String typeSelected = (String) type.getSelectedItem();
                reloadTasteCheckBox(SnackType.valueOf(typeSelected));
                loadPrice();
            }
        });

        snackPickView.getSnackTaste().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPrice();
            }
        });

        snackPickView.getSnackSize().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPrice();
            }
        });
    }

    private boolean isAllComboBoxSelected() {

        return ((snackPickView.getSnackType().getSelectedIndex() > -1)
                && (snackPickView.getSnackTaste().getSelectedIndex() > -1)
                && (snackPickView.getSnackSize().getSelectedIndex() > -1));
    }

    private void loadPrice() {

        if(isAllComboBoxSelected()) {

            setSnack();

            snackPickView.setPrice(Double.toString(snack.getTotalPrice()));
        }
    }

    private void reloadTasteCheckBox(SnackType type) {

        JComboBox<String> cbox = snackPickView.getSnackTaste();
        snackPickView.getSnackSize().setSelectedIndex(-1);
        snackPickView.setPrice("");

        switch (type) {
        case POPCORN:
            reloadCheckBoxModel(createOptions(PopcornType.values()), cbox);
            break;

        case COLA:
            reloadCheckBoxModel(createOptions(ColaType.values()), cbox);
            break;

        default:
            break;
        }
    }

    private void reloadCheckBoxModel(String[] options, JComboBox<String> cbox) {

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbox.getModel();

        model.removeAllElements();

        for (String option : options) {
            model.addElement(option);
        }
        cbox.setSelectedIndex(-1);
    }

    private void initDefaultSnackPickView() {

        snackPickView.setSnackType(initComboBox(SnackType.values()));
        snackPickView.setSnackTaste(initComboBox(PopcornType.values()));
        snackPickView.setSnackSize(initComboBox(SizeType.values()));
        initQuantityField();
    }

    private void setSnack() {

        SnackType type = SnackType.valueOf((String) snackPickView.getSnackType().getSelectedItem());
        SnackCreator snackCreator = SnackCreatorProducer.getSnackCreator(type);

        switch (type) {

        case POPCORN:
            getPopcornSnack(snackCreator);
            break;

        case COLA:
            getColaSnack(snackCreator);
            break;

        default:
            break;
        }

    }

    private void getPopcornSnack(SnackCreator snackCreator) {

        PopcornType taste = PopcornType.valueOf((String) snackPickView.getSnackTaste().getSelectedItem());

        snack = snackCreator.getPopcornSnack(taste);
        setSnackSize();
    }

    private void getColaSnack(SnackCreator snackCreator) {

        ColaType taste = ColaType.valueOf((String) snackPickView.getSnackTaste().getSelectedItem());

        snack = snackCreator.getColaSnack(taste);
        setSnackSize();
    }

    private void setSnackQuantity() {

        //TODO: init
    }
    private void setSnackSize() {

        SizeType size = SizeType.valueOf((String) snackPickView.getSnackSize().getSelectedItem());

        snack.setSize(size);
    }

    private void initQuantityField() {

        final int minValue = 1;
        final int maxValue = 10;
        final int step = 1;

        SpinnerModel model = new SpinnerNumberModel(minValue, minValue, maxValue, step);
        snackPickView.setSnackQuantity(new JSpinner(model));
    }

    private <E extends Enum<E>> JComboBox<String> initComboBox(E[] items) {

        String[] options = createOptions(items);

        JComboBox<String> types = new JComboBox<String>(options);
        types.setSelectedIndex(-1);
        return types;
    }

    private <E extends Enum<E>> String[] createOptions(E[] items) {

        List<String> options = new ArrayList<String>();

        for (E type : items) {

            options.add(type.name());
        }

        String[] optionStrings = new String[options.size()];

        return options.toArray(optionStrings);
    }
}