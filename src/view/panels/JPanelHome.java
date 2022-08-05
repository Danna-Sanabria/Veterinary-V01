package view.panels;


// import presenter.listeners.HomeListener;
import presenters.listeners.HomeListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JPanelHome extends JPanel {

    private static final String LANE_IMAGE = ".\\resources\\image\\1.png";
    private static final String LANE_BACKGROUND = ".\\resources\\image\\fondo.jpg";
    private JButton jButtonNext;
    private JButton jButtonBack;
    private JLabel jLabelImage;
    private ImageIcon icon;
    private HomeListener homeListener;

    public JPanelHome() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        homeListener = new HomeListener(this);

        jLabelImage = new JLabel();
        jLabelImage.setBorder(null);
        jLabelImage.setSize(1050, 490);
        icon = new ImageIcon(LANE_IMAGE);
        jLabelImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH)));

        jButtonNext = new JButton();
        initButtonDinamic(jButtonNext, "next", "next");

        jButtonBack = new JButton();
        initButtonDinamic(jButtonBack, "back", "back");

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.weightx = 0.1;
        gridBagLayout.setConstraints(jButtonBack, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.weightx = 1;
        gridBagLayout.setConstraints(jLabelImage, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 5;
        gbc.weightx = 0.1;
        gridBagLayout.setConstraints(jButtonNext, gbc);

        this.add(jLabelImage);
        this.add(jButtonNext);
        this.add(jButtonBack);
        this.setBackground(Color.white);
    }

    public void initButtonDinamic(JButton button, String nameFile, String command) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setActionCommand(command);
       button.addActionListener(homeListener);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        icon = new ImageIcon(".\\resources\\image\\" + nameFile + ".png");
        button.setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
    }

    public JButton getjButtonNext() {
        return jButtonNext;
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public JLabel getjLabelImage() {
        return jLabelImage;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(LANE_BACKGROUND);
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
