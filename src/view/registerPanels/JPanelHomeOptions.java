package view.registerPanels;

import presenters.Presenter;
import presenters.listeners.MainListeners;
import view.JFrameMain;

import javax.swing.*;
import java.awt.*;

public class JPanelHomeOptions extends JPanel{

    public static final String USUARIO = "USUARIO";
    public static final String ROUTE_BACKGROUND = ".\\resources\\image\\fondo.jpg";
    public static final String ROUTE_ICON = ".\\resources\\image\\gp.png";
    private static final String MEDICO = "MEDICO";
    private JButton jButtonUser;
    private JButton jButtonMedical;

    public  JPanelHomeOptions (JFrameMain jFrameMain, Presenter presenter) {
        MainListeners mainListener = new MainListeners(jFrameMain, presenter);
        setLayout(null);
        setBackground(new Color(24, 104, 128, 255));
        initComponents(mainListener);
    }

    private void initComponents(MainListeners mainListener) {
        jButtonUser = new JButton(USUARIO);
        jButtonUser.setBounds(135, 200, 190, 70);
        jButtonUser.setBackground(new Color(49, 153, 139));
        jButtonUser.addActionListener(mainListener);
        jButtonUser.setActionCommand(USUARIO);
        jButtonUser.setFont(new Font("Cambria", 3, 18));
        jButtonUser.setForeground(Color.white);
        this.add(jButtonUser);

        jButtonMedical = new JButton(MEDICO);
        jButtonMedical.setBounds(135, 350, 190, 70);
        jButtonMedical.setBackground(new Color(49, 153, 139));
        jButtonMedical.addActionListener(mainListener);
        jButtonMedical.setActionCommand(MEDICO);
        jButtonMedical.setFont(new Font("Cambria", 3, 18));
        jButtonMedical.setForeground(Color.white);
        this.add(jButtonMedical);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(ROUTE_BACKGROUND);
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        ImageIcon icon2 = new ImageIcon(ROUTE_ICON);
        Image image2 = new ImageIcon(icon2.getImage()).getImage();
        g.drawImage(image2, 0, 47, getWidth(), 495, this);
        setOpaque(false);
        super.paint(g);
    }
}
