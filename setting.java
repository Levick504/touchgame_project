package project;

import javax.swing.*;
import java.awt.*;


class setting extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image background = new ImageIcon(main.class.getResource("images/background.jpg")).getImage();

    public setting() {
        setTitle("설정");
        setSize(500,600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
    }

    public void paint(Graphics g) {
        screenImage = createImage(500, 600);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }
}
