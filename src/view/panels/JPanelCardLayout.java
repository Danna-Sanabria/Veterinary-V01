package view.panels;

import javax.swing.*;
import java.awt.*;

public class JPanelCardLayout extends JPanel {

    private static final String HOME = "HOME";
    private static final String SCHEDULE = "SHEDULE";
    private static final String SEARCH = "CONSULT";
    private static final String CANCEL = "CANCEL";
    private CardLayout cardLayout;

    public JPanelCardLayout(JPanelHome jPanelHome, JPanelScheduleAppointment jPanelScheduleAppointment, JPanelSearchAppointment jPanelSearchAppointment, JPanelCancelAppointment jPanelCancelAppointment) {
        cardLayout = new CardLayout();

        cardLayout.addLayoutComponent(jPanelHome, HOME);
        cardLayout.addLayoutComponent(jPanelScheduleAppointment, SCHEDULE);
        cardLayout.addLayoutComponent(jPanelSearchAppointment, SEARCH);
        cardLayout.addLayoutComponent (jPanelCancelAppointment, CANCEL);

        this.add(jPanelHome);
        this.add(jPanelScheduleAppointment);
        this.add(jPanelSearchAppointment);
        this.add(jPanelCancelAppointment);

        this.setLayout(cardLayout);
        cardLayout.show(this, HOME);
    }

    public void setJPanelHome() {
        cardLayout.show(this, HOME);
    }

    public void setjPanelScheduleAppointment() {
        cardLayout.show(this, SCHEDULE);
    }

    public void setjPanelSearchAppointment() {
        cardLayout.show(this, SEARCH);
    }

    public void setjPanelCancelAppointment() {
        cardLayout.show(this, CANCEL);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}
