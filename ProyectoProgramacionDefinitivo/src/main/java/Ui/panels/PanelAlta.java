package Ui.panels;



import Services.UserServices;
import Ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAlta extends JPanel {
    JTextField idUser;

    JTextField pass;
    JTextField correo;
    JComboBox isadmin;
    private FrameLogin framepadre;
    UserServices serviceUser=new UserServices();

    JButton enviar;
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
             if (serviceUser.registrarUsuario(idUser.getText(),correo.getText(),pass.getText(),false)) {
                System.out.println("Esta registrado");
                System.out.println("Opciones");


                // si ha realizado correctamente la accion se carga la pantalla correspondiente
                cargarpanelop();
            }


        }
    };


// esto froma la ionterfaz grafica del panel
    public PanelAlta(FrameLogin framepadre){
        this.framepadre=framepadre;
        this.setBackground(new Color(155, 138, 129, 243));
        this.setLayout(null);

        JLabel idusuario =new JLabel("IdUsuario:");
        idusuario.setLocation(new Point(200,150));
        idusuario.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(idusuario);
        idUser = new JTextField("");
        idUser.setLocation(new Point(260,150));
        idUser.setSize(new Dimension(152,32));
        this.add(idUser);

        JLabel correos =new JLabel("correo:");
        correos.setLocation(new Point(200,200));
        correos.setSize(new Dimension(152,32));
        this.add(correos);
        correo=new JTextField("");
        correo.setLocation(new Point(260,200));
        correo.setSize(new Dimension(152,32));
        this.add(correo);

        JLabel passwd = new JLabel("Passwd:");
        passwd.setLocation(new Point(200,250));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,250));
        pass.setSize(new Dimension(152,32));
        this.add(pass);



        JLabel Isadmin=new JLabel("IsAdmin:");
        Isadmin.setLocation(new Point(200,350));
        Isadmin.setSize(new Dimension(152,32));
        this.add(Isadmin);

        isadmin=new JComboBox();
        isadmin.addItem("no");
        isadmin.setLocation(new Point(260,350));
        isadmin.setSize(new Dimension(152,32));
        this.add(isadmin);


        enviar = new JButton("Enviar");
        enviar.setLocation(new Point(220,400));
        enviar.setSize(new Dimension(152,32));
        this.add(enviar);
        enviar.addMouseListener(listenerMouseOP);

        atras=new JButton("atras");
        atras.setLocation(new Point(100,500));
        atras.setSize(new Dimension(152,32));
        atras.setBackground(new Color(0xEA8484));
        atras.addMouseListener(listenerMouseAtras);
        this.add(atras);





    }
    private void cargarpanelop(){

        framepadre.remove(this);

        PanelOpciones panelop=new PanelOpciones(framepadre);
        framepadre.add(panelop);


        framepadre.repaint();
        framepadre.revalidate();
    }


}
