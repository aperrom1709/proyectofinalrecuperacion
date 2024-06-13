package Ui.frames;

import Ui.panels.PanelLogin;

import javax.swing.*;

public class FrameLogin extends JFrame {

    public FrameLogin() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto UI");
        ImageIcon image = new ImageIcon("src/main/resources/pokemonMedia/images/pikachu.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);

        PanelLogin p = new PanelLogin(this);
        this.add(p);




        this.setVisible(true);
    }


}
