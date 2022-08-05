package view.registerPanels;

import presenters.listeners.HomeRegisterListener;
import view.JFrameMain;

import javax.swing.*;
import java.awt.*;

public class JPanelHomeRegister extends JPanel {

    private HomeRegisterListener homeListener;

    private JLabel jLabelSchedule;


    private JButton jButtonBack;
    private JButton jButtonRegister;

    private JList jList;
    private JScrollPane scrollPane;

    public JPanelHomeRegister(JFrameMain jFrameMain) {
        setLayout(null);
        homeListener = new HomeRegisterListener(this, jFrameMain);
        initComponents();
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {


        jButtonBack = new JButton("Volver");
        jButtonBack.setBounds(106, 558, 125, 40);
        jButtonBack.setBackground(new Color(49, 153, 139));
        jButtonBack.setFont(new Font("Cambria", 3, 18));
        jButtonBack.setForeground(Color.white);
        jButtonBack.addActionListener(homeListener);
        jButtonBack.setActionCommand("BACK");
        this.add(jButtonBack);

        jButtonRegister = new JButton("Registrar");
        jButtonRegister.setBounds(239, 558, 125, 40);
        jButtonRegister.setBackground(new Color(49, 153, 139));
        jButtonRegister.addActionListener(homeListener);
        jButtonRegister.setActionCommand("REGISTER");
        jButtonRegister.setFont(new Font("Cambria", 3, 18));
        jButtonRegister.setForeground(Color.white);
        this.add(jButtonRegister);
    }

    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(".\\resources\\image\\fondo.jpg");
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}

