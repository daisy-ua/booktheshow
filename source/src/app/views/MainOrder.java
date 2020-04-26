package app.views;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import mdlaf.utils.MaterialColors;

@SuppressWarnings("serial")
public class MainOrder extends JPanel {

    private JLabel titleMovieTitle;
    private JLabel titleSession;
    private JLabel titleHallId;
    private JLabel titleRow;
    private JLabel titleColumn;
    private JLabel titlePrice;

    private JLabel movieTitle;
    private JLabel session;
    private JLabel hallId;
    private JLabel row;
    private JLabel column;
    private JLabel price;
    private JLabel seatType;

    public MainOrder() {

        super();

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        setLayout(layout);

        initFields();
        initLayout(layout);
    }

    private void initLayout(GroupLayout layout) {

        initHorizontalLayout(layout);
        initVerticalLayout(layout);
    }

    private void initHorizontalLayout(GroupLayout layout) {

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(titleMovieTitle)
                .addComponent(titleSession)
                .addComponent(titleHallId)
                .addComponent(titlePrice)
            )
            .addGroup(layout.createParallelGroup()
                .addComponent(movieTitle)
                .addComponent(session)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(hallId)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(titleRow)
                    .addComponent(row)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(titleColumn)
                    .addComponent(column)
                )
            )
        );
    }

    private void initVerticalLayout(GroupLayout layout) {

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
                .addComponent(titleMovieTitle)
                .addComponent(movieTitle)
            )
            .addGroup(layout.createParallelGroup()
                .addComponent(titleSession)
                .addComponent(session)
            )
            .addGroup(layout.createParallelGroup()
                .addComponent(titleHallId)
                .addComponent(hallId)
                .addComponent(titleRow)
                .addComponent(row)
                .addComponent(titleColumn)
                .addComponent(column)
            )
            .addComponent(titlePrice)
        );
    }

    private void initFields() {

        initTitles();
        initTitlesColor();
        initDataFields();
    }

    private void initTitles() {

        titleMovieTitle = new JLabel("Movie:");
        titleSession = new JLabel("Session:");
        titleHallId = new JLabel("Hall:");
        titleRow = new JLabel("Row:");
        titleColumn = new JLabel("Column:");
        titlePrice = new JLabel("Price:");
    }

    private void initTitlesColor() {

        titleMovieTitle.setForeground(MaterialColors.RED_700);
        titleSession.setForeground(MaterialColors.RED_700);
        titleHallId.setForeground(MaterialColors.RED_700);
        titleRow.setForeground(MaterialColors.RED_700);
        titleColumn.setForeground(MaterialColors.RED_700);
        titlePrice.setForeground(MaterialColors.RED_700);
    }

    private void initDataFields() {

        movieTitle = new JLabel();
        session = new JLabel();
        hallId = new JLabel();
        row = new JLabel();
        column = new JLabel();
        price = new JLabel();
        seatType = new JLabel();
    }

    public JLabel getMovieTitle() {

        return movieTitle;
    }

    public JLabel getSession() {

        return session;
    }

    public JLabel getHallId() {

        return hallId;
    }

    public JLabel getRow() {

        return row;
    }

    public JLabel getColumn() {

        return column;
    }

    public JLabel getPrice() {

        return price;
    }
    public JLabel getSeatType() {

        return seatType;
    }
}