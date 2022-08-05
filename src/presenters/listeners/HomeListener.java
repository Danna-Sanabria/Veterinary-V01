package presenters.listeners;

import view.panels.JPanelCardLayout;
import view.panels.JPanelHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeListener implements ActionListener {

    private JPanelHome jPanelHome;
    private JPanelCardLayout jPanelCardLayout;
    private int count = 0;
    private int aux = 1;

    public HomeListener(JPanelHome jPanelHome) {
        this.jPanelHome = jPanelHome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton back = jPanelHome.getjButtonBack();
        JButton next = jPanelHome.getjButtonNext();

        if (e.getSource() == next) {
            if (aux >= 4) {
                aux = 1;
            } else {
                aux++;
            }
        }

        if (e.getSource() == back) {
            if (aux <= 1) {
                aux = 4;
            } else {
                aux--;
            }
        }

        ImageIcon icon = new ImageIcon(".\\resources\\image\\" + aux + ".png");
        jPanelHome.getjLabelImage().setIcon(new ImageIcon(icon.getImage().getScaledInstance(jPanelHome.getjLabelImage().getWidth(),
                jPanelHome.getjLabelImage().getHeight(), Image.SCALE_SMOOTH)));
    }
}

