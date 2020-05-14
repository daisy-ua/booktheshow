package app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.models.extraservice.ExtraService;
import app.models.extraservice.snack.SnackCreator;
import app.models.extraservice.snack.SnackCreatorProducer;
import app.models.extraservice.snack.item.Snack;
import app.models.extraservice.snack.item.SnackType;
import app.models.extraservice.snack.item.cola.ColaType;
import app.models.extraservice.snack.item.popcorn.PopcornType;
import app.models.extraservice.snack.size.SizeType;
import app.models.order.IOrder;
import app.views.SnackOrder;
import app.views.SnackOrderList;
import app.views.SnackPick;

public class SnackController {

    private SnackPick snackPickView;
    private SnackOrderList snackOrderView;
    private Snack snack;
    private ExtraService order;

    public SnackController(SnackOrder snackOrderView, IOrder mainOrder) {

        this.snackOrderView = snackOrderView.getSnackOrder();
        this.snackPickView = snackOrderView.getSnackPick();
    }

    public void initController() {

        initDefaultSnackPickView();
        initSnackPickEvents();
        order = new ExtraService();
    }

    public ExtraService getExtraService() {

        return order;
    }

    private void initSnackPickEvents() {

        initSnackPickTypeEvent();
        initSnackPickTasteEvent();
        initSnackPickSizeEvent();
        initSnackPickQuantityEvent();
        initSnackPickAddButtonEvent();
        initSnackPickDeleteButtonEvent();
    }

    private void initSnackPickTypeEvent() {

        snackPickView.getSnackType().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox<String> type = (JComboBox<String>) e.getSource();
                String typeSelected = (String) type.getSelectedItem();
                reloadTasteCheckBox(SnackType.valueOf(typeSelected));
                loadPickViewPrice();
            }
        });
    }

    private void initSnackPickTasteEvent() {

        snackPickView.getSnackTaste().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPickViewPrice();
            }
        });
    }

    private void initSnackPickSizeEvent() {

        snackPickView.getSnackSize().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadPickViewPrice();
            }
        });
    }

    private void initSnackPickQuantityEvent() {

        snackPickView.getSnackQuantity().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                loadPickViewPrice();
            }
        });
    }

    private void initSnackPickAddButtonEvent() {

        snackPickView.getAddButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(isAllComboBoxSelected()) {

                    JList<String> list = snackOrderView.getOrderList();

                    DefaultListModel<String> model = (DefaultListModel<String>)list.getModel(); 
                    model.addElement(snack.getDescription());
                    order.addSnack(snack);
                    loadOrderPrice();
                }
            }
        });
    }
    
    private void initSnackPickDeleteButtonEvent() {
        
        JList<String> list = snackOrderView.getOrderList();

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultListModel<String> model = (DefaultListModel<String>)list.getModel(); 
                order.removeSnackById(list.getSelectedIndex());       
                model.removeElementAt(list.getSelectedIndex()); 
                loadOrderPrice();
            }
        });

    }
    
    private boolean isAllComboBoxSelected() {

        return ((snackPickView.getSnackType().getSelectedIndex() > -1)
                && (snackPickView.getSnackTaste().getSelectedIndex() > -1)
                && (snackPickView.getSnackSize().getSelectedIndex() > -1));
    }

    private void loadPickViewPrice() {

        if (isAllComboBoxSelected()) {

            setSnack();

            snackPickView.setPriceValue(Double.toString(snack.getTotalPrice()));
        }
    }

    private void loadOrderPrice() {

        snackOrderView.getPrice().setText(Double.toString(order.getTotalPrice()));
    }

    private void reloadTasteCheckBox(SnackType type) {

        JComboBox<String> cbox = snackPickView.getSnackTaste();
        snackPickView.getSnackSize().setSelectedIndex(-1);
        snackPickView.setPriceValue("");

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

        snackPickView.setAddButton(new JButton("Add"));
        snackPickView.setSnackType(initComboBox(SnackType.values()));
        snackPickView.setSnackTaste(initComboBox(PopcornType.values()));
        snackPickView.setSnackSize(initComboBox(SizeType.values()));
        initQuantityField();
        snackPickView.setPrice(new JLabel());
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

        snack = snackCreator.getSnack(taste);

        setSnackSize();
        setSnackQuantity();
    }

    private void getColaSnack(SnackCreator snackCreator) {

        ColaType taste = ColaType.valueOf((String) snackPickView.getSnackTaste().getSelectedItem());

        snack = snackCreator.getSnack(taste);

        setSnackSize();
        setSnackQuantity();
    }

    private void setSnackSize() {

        SizeType size = SizeType.valueOf((String) snackPickView.getSnackSize().getSelectedItem());

        snack.setSize(size);
    }

    private void setSnackQuantity() {

        int quantity = (int) snackPickView.getSnackQuantity().getValue();

        snack.setQuantity(quantity);
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