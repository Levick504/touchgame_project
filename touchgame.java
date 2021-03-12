package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;

public class touchgame extends JFrame { // timer 클래스 배워서 재화 자동으로 오르는 기능 만들 예정

    private Image screenImage;
    private Graphics screenGraphic;

    private ImageIcon exitButtonEnterImage = new ImageIcon(main.class.getResource("images/exitbuttonentered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(main.class.getResource("images/exitbutton.png"));

    private ImageIcon settingButtonEnterImage = new ImageIcon(main.class.getResource("images/settingiconentered.png"));
    private ImageIcon settingButtonBasicImage = new ImageIcon(main.class.getResource("images/settingicon.png"));

    private ImageIcon shopButtonEnterImage = new ImageIcon(main.class.getResource("images/shopiconentered.png"));
    private ImageIcon shopButtonBasicImage = new ImageIcon(main.class.getResource("images/shopicon.png"));

    private Image background = new ImageIcon(main.class.getResource("images/background.jpg")).getImage();
    private ImageIcon touchbackground = new ImageIcon(main.class.getResource("images/background.jpg"));
    private JLabel menubar = new JLabel(new ImageIcon(main.class.getResource("images/menubar.png")));

    private ImageIcon moneyImage = new ImageIcon(main.class.getResource("images/money2.png"));

    private JButton exitbutton = new JButton(exitButtonBasicImage);
    private JButton settingbutton = new JButton(settingButtonBasicImage);
    private JButton shopbutton = new JButton(shopButtonBasicImage);
    private JButton money = new JButton(moneyImage);
    private JButton touchbackground_ = new JButton(touchbackground);

    JLabel money_amount = new JLabel(main.formatter.format(main.money_));

    private int mouseX;
    private int mouseY;

    public touchgame() {
        setUndecorated(true);
        setTitle("터치형 게임 프로젝트");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);


        this.add(money_amount);
        money_amount.setFont(new Font("Noto Sans",Font.BOLD,30));
        money_amount.setBounds(90,-1,1280,50);

        money.setBounds(-2,2,87,46);
        money.setBorderPainted(false);
        money.setContentAreaFilled(false);
        money.setFocusPainted(false);
        add(money);

        exitbutton.setBounds(1233, 3, 45, 45);
        exitbutton.setBorderPainted(false);
        exitbutton.setContentAreaFilled(false);
        exitbutton.setFocusPainted(false);
        exitbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                exitbutton.setIcon(exitButtonEnterImage);
                exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitbutton.setIcon(exitButtonBasicImage);
                exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
        });
        add(exitbutton);

        settingbutton.setBounds(1185, 3, 45, 45);
        settingbutton.setBorderPainted(false);
        settingbutton.setContentAreaFilled(false);
        settingbutton.setFocusPainted(false);
        settingbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                settingbutton.setIcon(settingButtonEnterImage);
                settingbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                settingbutton.setIcon(settingButtonBasicImage);
                settingbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                new setting();
            }
        });
        add(settingbutton);

        shopbutton.setBounds(1135, 3, 45, 45);
        shopbutton.setBorderPainted(false);
        shopbutton.setContentAreaFilled(false);
        shopbutton.setFocusPainted(false);
        shopbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbutton.setIcon(shopButtonEnterImage);
                shopbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                shopbutton.setIcon(shopButtonBasicImage);
                shopbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                new shop();
            }
        });
        add(shopbutton);

        menubar.setBounds(0, 0, 1280, 50);
        menubar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menubar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                setLocation(x - mouseX, e.getYOnScreen()-mouseY);
            }
        });
        add(menubar);

        touchbackground_.setBounds(0, 50, 1280, 670);
        touchbackground_.setBorderPainted(false);
        touchbackground_.setContentAreaFilled(false);
        touchbackground_.setFocusPainted(false);
        touchbackground_.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 실행될 이벤트
                main.money_up = (int)(Math.random()*(main.m_max-main.m_min))+main.m_min;
                main.money_ += main.money_up;
                System.out.println(main.money_);
                money_amount.setText(""+main.money_);

            }
        });
        add(touchbackground_);

    }



    public void paint(Graphics g) {
        screenImage = createImage(1280, 720);
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
