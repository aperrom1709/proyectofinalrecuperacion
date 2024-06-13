
import Ui.frames.FrameLogin;


import javax.swing.*;


public class Main {// este es el main que funciona cuando quiere 
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameLogin fc = new FrameLogin();
            }
        });

    }
}
