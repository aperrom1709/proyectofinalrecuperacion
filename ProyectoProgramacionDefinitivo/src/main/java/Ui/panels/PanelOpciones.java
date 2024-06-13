package Ui.panels;


import Ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelOpciones extends JPanel {

    private FrameLogin framePadre;
    JButton  Alta;
    JButton Baja;
    JButton modificar;
    JButton consulta;
    JButton atras;
    // usa este metodo para que cuando pulses el boton realice la funcion correspondiente llamando de el userservices
    private  MouseListener listenerMouseAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Alta pulsado");
            cargarpanelalta();
        }
    };
    private  MouseListener listenerMouseconsulta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Consulta pulsado");
            cargarpanelconsulta();
        }
    };
    private MouseListener listenerMouseAtras = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("atras pulsado");
            cargarpanellogin();
        }
    };
    private MouseListener listenerMouseModificar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("modificar pulsado");
            cargarpanelModificar();
        }
    };
    private MouseListener listenerMouseBaja = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Baja pulsado");
            cargarpanelBaja();
        }
    };

    // esto froma la ionterfaz grafica del panel
    public PanelOpciones(FrameLogin framepadre){
        this.framePadre=framepadre;
        this.setBackground((new Color(223, 220, 220)));
        this.setLayout(null);

        Alta=new JButton("Alta");
        Alta.setLocation(new Point(210,150));
        Alta.setSize(new Dimension(152,32));
        Alta.setBackground(new Color(0xC0DDB8));
        Alta.addMouseListener(listenerMouseAlta);
        this.add(Alta);

        Baja=new JButton("Baja");
        Baja.setLocation(new Point(210,200));
        Baja.setSize(new Dimension(152,32));
        Baja.setBackground(new Color(0xEA8484));
        Baja.addMouseListener(listenerMouseBaja);
        this.add(Baja);

        modificar=new JButton("Modificar");
        modificar.setLocation(new Point(210,250));
        modificar.setSize(new Dimension(152,32));
        modificar.setBackground(new Color(0xD8B969));
        modificar.addMouseListener(listenerMouseModificar);
        this.add(modificar);

        consulta=new JButton("Consulta");
        consulta.setLocation(new Point(210,300));
        consulta.setSize(new Dimension(152,32));
        Alta.setBackground(new Color(0x69B0D8));
        consulta.addMouseListener(listenerMouseconsulta);
        this.add(consulta);

        atras=new JButton("atras");
        atras.setLocation(new Point(100,500));
        atras.setSize(new Dimension(152,32));
        atras.setBackground(new Color(0xEA8484));
        atras.addMouseListener(listenerMouseAtras);
        this.add(atras);


    }
    // como se forma la funcion cargaR PANEL haciendo que se borren y se pinten dependiendo quien tenga que salir
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
    private void cargarpanelconsulta(){

        framePadre.remove(this);
        PanelConsulta consulta=new PanelConsulta(framePadre);
        framePadre.add(consulta);

        framePadre.repaint();
        framePadre.revalidate();
    }
    private void cargarpanellogin(){

        framePadre.remove(this);
        PanelLogin log=new PanelLogin(framePadre);
        framePadre.add(log);

        framePadre.repaint();
        framePadre.revalidate();
    }
    private void cargarpanelModificar(){

        framePadre.remove(this);

        PanelModificar modificar=new PanelModificar(framePadre);
        framePadre.add(modificar);


        framePadre.repaint();
        framePadre.revalidate();
    }
    private void cargarpanelBaja(){

        framePadre.remove(this);

        PanelBaja baja=new PanelBaja(framePadre);
        framePadre.add(baja);


        framePadre.repaint();
        framePadre.revalidate();
    }
}
