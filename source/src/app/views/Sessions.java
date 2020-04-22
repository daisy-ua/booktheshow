package app.views;

import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sessions extends JPanel {

    private JList<String> sessions;
    public int rowsVisible = 1;

    public Sessions(JList<String> sessions) {
        
        super();
        this.sessions = sessions;

        this.sessions.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.sessions.setVisibleRowCount(rowsVisible);
        
        add(this.sessions);
    }

    public JList<String> getSessions() {

        return this.sessions;
    }

}