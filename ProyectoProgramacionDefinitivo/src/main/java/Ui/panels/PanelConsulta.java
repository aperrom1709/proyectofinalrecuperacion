package Ui.panels;



import Model.Classes.User;
import Services.UserServices;
import Ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelConsulta extends JPanel {
    private FrameLogin framePadre;
    UserServices serviceUser=new UserServices();
    JLabel idUser;
    JTextField idUsuario;
    JButton Consultar;
    JTextArea recuadro;

    JButton atras;
    private MouseListener listenerMouseAtras = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("atras pulsado");
            cargarpanelop();
        }
    };
    // usa este metodo para que cuando pulses el boton realice la funcion correspondiente llamando de el userservices
    private MouseListener listenerMouseOP = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            User consulta=new User(idUsuario.getText(),"","",false);
            recuadro.setText(serviceUser.consultausuario(consulta));






        }
    };



    // esto froma la ionterfaz grafica del panel
    public PanelConsulta(FrameLogin framePadre){
        this.framePadre=framePadre;
        this.setBackground((new Color(223, 220, 220)));
        this.setLayout(null);

        idUser=new JLabel("IdUsuario");
        idUser.setLocation(new Point(200,50));
        idUser.setSize(new Dimension(152,32));
        this.add(idUser);

        idUsuario=new JTextField("Introduzca su usuario");
        idUsuario.setLocation(new Point(260,50));
        idUsuario.setSize(new Dimension(152,32));
        this.add(idUsuario);

        Consultar=new JButton("Consultar");
        Consultar.setLocation(new Point(210,100));
        Consultar.setSize(new Dimension(152,32));
        Consultar.setBackground(new Color(0xEA8484));
        this.add(Consultar);
        Consultar.addMouseListener(listenerMouseOP);


        recuadro=new JTextArea();
        recuadro.setLocation(new Point(175,150));
        recuadro.setSize(new Dimension(300,300));
        this.add(recuadro);


        atras=new JButton("atras");
        atras.setLocation(new Point(100,500));
        atras.setSize(new Dimension(152,32));
        atras.setBackground(new Color(0xEA8484));
        atras.addMouseListener(listenerMouseAtras);
        this.add(atras);
    }
    private void cargarpanelop(){

        framePadre.remove(this);

        PanelOpciones panelop=new PanelOpciones(framePadre);
        framePadre.add(panelop);


        framePadre.repaint();
        framePadre.revalidate();
    }

}
