package view.panels;

import presenters.listeners.ListenerMenu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class JPanelMenu extends JPanel {

    private static final String FOOTPRINTS = "HUELLITAS";
    private static final String ROUTE_LOGO = ".\\resources\\image\\Logo.png";
    private static final String SHEDULE = "AGENDAR";
    private static final String SEARCH = "CONSULTAR";
    private static final String CANCEL = "CANCELAR";
    private static final String TEXT_BUTTON_CANCEL = "<html><center>CANCELAR<html>";

    private Color color;
    public JPanelMenu(JPanelCardLayout jPanelCardLayout) {
        ListenerMenu listenerMenu = new ListenerMenu(jPanelCardLayout);
        setLayout(new GridLayout(1, 9, 3, 3));
        color = new Color(216, 117, 228);

        this.setBackground(new Color(216, 117, 228));
        this.setPreferredSize(new Dimension(this.getWidth(), 66));

        JButton jButtonReturnHome = new JButton();
        jButtonReturnHome.setSize(570, 66);
        repaint();
        setComponentButton(jButtonReturnHome, FOOTPRINTS, FOOTPRINTS, listenerMenu);
        jButtonReturnHome.setBorder(null);
        ImageIcon icon = new ImageIcon(ROUTE_LOGO);
        jButtonReturnHome.setIcon(new ImageIcon(icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jButtonReturnHome.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonReturnHome.setVerticalTextPosition(SwingConstants.CENTER);

        JLabel jlabelLogo = new JLabel();
        this.add(jlabelLogo);

        JButton jButtonAdop = new JButton();
        setComponentButton(jButtonAdop, SHEDULE, SHEDULE, listenerMenu);

        JButton jButtonMedicalAppointments = new JButton();
        setComponentButton(jButtonMedicalAppointments, SEARCH, SEARCH, listenerMenu);

        JButton jButtonOurs = new JButton();
        setComponentButton(jButtonOurs, TEXT_BUTTON_CANCEL, CANCEL, listenerMenu);
    }

    public void setComponentButton(JButton jButton, String text, String command, ListenerMenu listenerMenu) {
        jButton.setText(text);
        jButton.setBackground(color);
        jButton.setFont(new Font("Serif", Font.BOLD, 18));
        jButton.setBorder(new LineBorder(Color.black));
        jButton.setActionCommand(command);
        jButton.addActionListener(listenerMenu);
        this.add(jButton);
    }
}

