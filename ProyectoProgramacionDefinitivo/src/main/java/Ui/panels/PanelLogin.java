package Ui.panels;





import Services.UserServices;
import Ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanelLogin extends JPanel {
    JTextField user;
    JTextField pass;
    JButton bEnviar;

    private JButton bAlta;
    //Este es el frame padre de este frame
    private FrameLogin framePadre;



    UserServices serviceUser=new UserServices();
    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(serviceUser.checkUserExists(user.getText(), pass.getText())) {
                System.out.println("Esta registrado");
            } else {
                System.out.println("Pa tu casa");
            }
        };


        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
        }
    };

    private  MouseListener listenerMouseAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Alta pulsado");
            cargarpanelalta();
        }
    };
    // usa este metodo para que cuando pulses el boton realice la funcion correspondiente llamando de el userservices
    private MouseListener listenerMouseOP = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (serviceUser.checkUserExists(user.getText(),pass.getText())){
                System.out.println("Opciones");
                cargarpanelop();
            }

        }
    };

    // esto froma la interfaz grafica del panel
    public PanelLogin(FrameLogin framePadre) {
        this.framePadre=framePadre;
        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200,135));
        usuario.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        user = new JTextField("");
        user.setLocation(new Point(260,135));
        user.setSize(new Dimension(152,32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200,200));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,200));
        pass.setSize(new Dimension(152,32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(120,321));
        bEnviar.setSize(new Dimension(152,32));
        this.add(bEnviar);
        bEnviar.addMouseListener(listenerMouse);
        bEnviar.addMouseListener(listenerMouseOP);

        bAlta=new JButton("Alta");
        bAlta.setLocation(new Point(280,321));
        bAlta.setSize(new Dimension(152,32));
        bAlta.addMouseListener(listenerMouseAlta);
        this.add(bAlta);



    }
    private void cargarpanelalta(){
        //Eliminamos this Panellogin....
        framePadre.remove(this);
        //Añadimos un panel alta al frame
        PanelAlta panelAlta=new PanelAlta(framePadre);
        framePadre.add(panelAlta);

        //Ultimo
        framePadre.repaint();
        framePadre.revalidate();
    }
    private void cargarpanelop(){
        //Eliminamos this Panellogin....
        framePadre.remove(this);
        //Añadimos un panel alta al frame
        PanelOpciones panelop=new PanelOpciones(framePadre);
        framePadre.add(panelop);

        //Ultimo
        framePadre.repaint();
        framePadre.revalidate();
    }
    private void cargarpanelprueba(){
        //Eliminamos this Panellogin....
        framePadre.remove(this);
        //Añadimos un panel alta al frame
        Panelprueba panelprueba=new Panelprueba(framePadre);
        framePadre.add(panelprueba);

        //Ultimo
        framePadre.repaint();
        framePadre.revalidate();
    }

}
