package view.registerPanels;

import presenters.listeners.HomeRegisterListener;
import view.JFrameMain;

import javax.swing.*;
import java.awt.*;

public class JPanelHomeRegister extends JPanel {

    private HomeRegisterListener homeListener;
    private JLabel jLabelTitle;
    private JLabel jLabelTitleList;

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
        jLabelTitle = new JLabel("DATOS REGISTRO MASCOTAS", SwingConstants.CENTER);
        jLabelTitle.setBounds(20, 50, 415, 20);
        jLabelTitle.setFont(new Font("Cambria", 3, 18));
        jLabelTitle.setForeground(new Color(49, 153, 139));
        this.add(jLabelTitle);

        jLabelTitleList = new JLabel("Lista de mascotas", SwingConstants.CENTER);
        jLabelTitleList.setBounds(20, 100, 415, 30);
        jLabelTitleList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jLabelTitleList.setFont(new Font("Cambria", 3, 18));
        jLabelTitleList.setForeground(new Color(49, 153, 139));
        this.add(jLabelTitleList);

        jList = new JList();
        //reload(petManager.getListPets());
       //jList.addListSelectionListener(homeListener);
        jList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jList.setFont(new Font("Serif", 0, 16));
        jList.setForeground(Color.black);
        scrollPane = new JScrollPane(jList);
        scrollPane.setBounds(20, 130, 415, 410);
        this.add(scrollPane);

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

    public void showUserFind(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public JList getjList() {
        return jList;
    }

    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(".\\resources\\image\\fondo.jpg");
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}

