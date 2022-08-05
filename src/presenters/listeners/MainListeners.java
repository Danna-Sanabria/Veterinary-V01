package presenters.listeners;

import presenters.Presenter;
import view.JFrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainListeners implements ActionListener {

    public static final String USUARIO = "USUARIO";
    private static final String MEDICO = "MEDICO";
    private JFrameMain jFrameMain;
    private Presenter presenter;

    public MainListeners(JFrameMain jFrameMain, Presenter presenter) {
        this.jFrameMain = jFrameMain;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case USUARIO:
                presenter.init(USUARIO);
                jFrameMain.dispose();
                break;
            case MEDICO:
                presenter.init(MEDICO);
                break;
        }
    }
}
