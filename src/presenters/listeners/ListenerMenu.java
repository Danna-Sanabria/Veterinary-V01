package presenters.listeners;

import view.panels.JPanelCardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener {
    public static final String SHEDULE = "AGENDAR";
    public static final String SEARCH = "CONSULTAR";
    public static final String CANCEL = "CANCELAR";
    public static final String FOOTPRINTS = "HUELLITAS";
    private JPanelCardLayout jPanelCardLayout;

    public ListenerMenu(JPanelCardLayout jPanelCardLayout) {
        this.jPanelCardLayout = jPanelCardLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(SHEDULE)) {
            jPanelCardLayout.setjPanelScheduleAppointment();
        }
        if (action.equals(SEARCH)) {
            jPanelCardLayout.setjPanelSearchAppointment();
        }
        if (action.equals(CANCEL)) {
            jPanelCardLayout.setjPanelCancelAppointment();
        }
        if (action.equals(FOOTPRINTS)) {
            jPanelCardLayout.setJPanelHome();
        }
    }
}