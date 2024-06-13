package Ui.panels;



import Model.Classes.User;
import Services.UserServices;
import Ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelModificar extends JPanel {
    JTextField idUser;
    String id_usuario;
    JTextField  correo;
    JTextField pass;
    JComboBox isadmin;
    private FrameLogin framepadre;
    UserServices serviceUser=new UserServices();
    User huan;

    JButton Consultar;
    JButton Modificar;
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
            if (idUser.getText().isEmpty()){
                System.out.println("faltan cosas");
            }else {
                if (serviceUser.userExists(idUser.getText())){
                    if (serviceUser.modificarusuario(huan,id_usuario)){
                        idUser.setEditable(true);
                        correo.setEditable(true);
                        pass.setEditable(true);
                        isadmin.setEditable(true);
                    }



                }
            }


        }

    };
    // esto froma la ionterfaz grafica del panel
    public PanelModificar(FrameLogin framepadre){
        this.framepadre=framepadre;
        this.setBackground((new Color(223, 220, 220)));
        this.setLayout(null);

        JLabel iduser=new JLabel("IdUsuario");
        iduser.setLocation(new Point(200,50));
        iduser.setSize(new Dimension(152,32));
        this.add(iduser);

        idUser=new JTextField("Introduzca su usuario");
        idUser.setLocation(new Point(260,50));
        idUser.setSize(new Dimension(152,32));
        this.add(idUser);

        Consultar=new JButton("Consultar");
        Consultar.setLocation(new Point(210,100));
        Consultar.setSize(new Dimension(152,32));
        Consultar.setBackground(new Color(0xEA8484));
        this.add(Consultar);
        Consultar.addMouseListener(listenerMouseOP);


        JLabel idusuario =new JLabel("IdUsuario: ");
        idusuario.setLocation(new Point(200,150));
        idusuario.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(idusuario);
        idUser = new JTextField("Introduzca su usuario: ");
        idUser.setLocation(new Point(260,150));
        idUser.setSize(new Dimension(152,32));
        this.add(idUser);

        JLabel correos =new JLabel("correo: ");
        correos.setLocation(new Point(200,200));
        correos.setSize(new Dimension(152,32));
        this.add(correos);
        correo=new JTextField("introduce tu correo: ");
        correo.setLocation(new Point(260,200));
        correo.setSize(new Dimension(152,32));
        this.add(correo);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200,250));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,250));
        pass.setSize(new Dimension(152,32));
        this.add(pass);


        JLabel Isadmin=new JLabel("IsAdmin: ");
        Isadmin.setLocation(new Point(200,350));
        Isadmin.setSize(new Dimension(152,32));
        this.add(Isadmin);

        isadmin=new JComboBox();

        isadmin.addItem("no");
        isadmin.setLocation(new Point(260,350));
        isadmin.setSize(new Dimension(152,32));
        this.add(isadmin);

        Modificar = new JButton("Modificar");
        Modificar.setLocation(new Point(220,400));
        Modificar.setSize(new Dimension(152,32));
        this.add(Modificar);
        Modificar.addMouseListener(listenerMouseOP);

        atras=new JButton("atras");
        atras.setLocation(new Point(100,500));
        atras.setSize(new Dimension(152,32));
        atras.setBackground(new Color(0xEA8484));
        atras.addMouseListener(listenerMouseAtras);
        this.add(atras);

    }
    private void cargarpanelop(){
        //Eliminamos this Panellogin....
        framepadre.remove(this);
        //Añadimos un panel alta al frame
        PanelOpciones panelop=new PanelOpciones(framepadre);
        framepadre.add(panelop);

        //Ultimo
        framepadre.repaint();
        framepadre.revalidate();
    }


}
