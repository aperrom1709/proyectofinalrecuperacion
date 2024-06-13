package Ui.panels;

import Ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;

public class Panelprueba  extends JPanel {
    JLabel pruebaDefensa;
    private FrameLogin framePadre;

    public Panelprueba(FrameLogin framePadre){
        this.framePadre=framePadre;
        pruebaDefensa=new JLabel("prueba defensa");
        pruebaDefensa.setLocation(new Point(200,135));
        pruebaDefensa.setSize(new Dimension(152,32));
        this.add(pruebaDefensa);

    }
}
