package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


class shop extends JFrame {

    public static int ListNumber = 1;

    int shopitem1_1num = 0;
    int shopitem1_2num = 0;
    int shopitem1_3num = 0;

    private Image screenImage;
    private Graphics screenGraphic;

    private Image background = new ImageIcon(main.class.getResource("images/shopbackground.png")).getImage();
    private JLabel shopdrag = new JLabel(new ImageIcon(main.class.getResource("images/shopdrag.png")));

    private ImageIcon shopbuttonImage = new ImageIcon(main.class.getResource("images/shopitembuttonsemple.png"));

    private ImageIcon exitButtonEnterImage = new ImageIcon(main.class.getResource("images/exitbuttonentered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(main.class.getResource("images/exitbutton.png"));

    private ImageIcon shopbuttonEnterImage = new ImageIcon(main.class.getResource("images/shopitembuttonentered.png"));
    private ImageIcon shopbuttonBasicImage = new ImageIcon(main.class.getResource("images/shopitembutton.png"));

    private ImageIcon shopbuttonnext = new ImageIcon(main.class.getResource("images/shopnextbutton.png"));
    private ImageIcon shopbuttonback = new ImageIcon(main.class.getResource("images/shopbackbutton.png"));

    public static ImageIcon shopListBlack = new ImageIcon(main.class.getResource("images/shopitemListbuttonBlack.png"));
    public static ImageIcon shopListRed = new ImageIcon(main.class.getResource("images/shopitemListbuttonRed.png"));

    private JButton shopbutton1_1 = new JButton(shopbuttonBasicImage);
    private JButton shopbutton1_2 = new JButton(shopbuttonBasicImage);
    private JButton shopbutton1_3 = new JButton(shopbuttonBasicImage);

    private JButton shopbuttonRight = new JButton(shopbuttonnext);
    private JButton shopbuttonLeft = new JButton(shopbuttonback);

    private JButton exitbutton = new JButton(exitButtonBasicImage);

    public static JButton shopitemList1 = new JButton(shopListRed);
    public static JButton shopitemList2 = new JButton(shopListBlack);
    public static JButton shopitemList3 = new JButton(shopListBlack);
    public static JButton shopitemList4 = new JButton(shopListBlack);
    public static JButton shopitemList5 = new JButton(shopListBlack);

    private int mouseX;
    private int mouseY;

    JLabel shopitem1_1 = new JLabel("테스트, 오르는 재화 양 늘리기");

    public shop() {
        setUndecorated(true);
        setTitle("상점");
        setSize(500,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        shopitemList1.setBounds(188, 50, 17, 17);
        shopitemList1.setBorderPainted(false);
        shopitemList1.setContentAreaFilled(false);
        shopitemList1.setFocusPainted(false);
        add(shopitemList1);

        shopitemList2.setBounds(214, 50, 17, 17);
        shopitemList2.setBorderPainted(false);
        shopitemList2.setContentAreaFilled(false);
        shopitemList2.setFocusPainted(false);
        add(shopitemList2);

        shopitemList3.setBounds(240, 50, 17, 17);
        shopitemList3.setBorderPainted(false);
        shopitemList3.setContentAreaFilled(false);
        shopitemList3.setFocusPainted(false);
        add(shopitemList3);

        shopitemList4.setBounds(266, 50, 17, 17);
        shopitemList4.setBorderPainted(false);
        shopitemList4.setContentAreaFilled(false);
        shopitemList4.setFocusPainted(false);
        add(shopitemList4);

        shopitemList5.setBounds(292, 50, 17, 17);
        shopitemList5.setBorderPainted(false);
        shopitemList5.setContentAreaFilled(false);
        shopitemList5.setFocusPainted(false);
        add(shopitemList5);

        exitbutton.setBounds(453, 3, 45, 45);
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
                dispose();
            }
        });
        add(exitbutton);

        this.add(shopitem1_1);
        shopitem1_1.setFont(new Font("Noto Sans",Font.BOLD,20));
        shopitem1_1.setBounds(100,130,1280,50);
        
        shopbutton1_1.setBounds(69, 100, 360, 130);
        shopbutton1_1.setBorderPainted(false);
        shopbutton1_1.setContentAreaFilled(false);
        shopbutton1_1.setFocusPainted(false);
        shopbutton1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbutton1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e){
                shopbutton1_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 발생할 이벤트
                int result = JOptionPane.showConfirmDialog(null,"정말로 "+"해당 아이템"+"아이템을 구매하시겠습니까?","안내",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.CLOSED_OPTION){

                }else if (result == JOptionPane.YES_OPTION){
                    if (shopitem1_1num == 1){
                        System.out.println("구매 실패\n더이상 재고가 없는 아이템입니다.");
                    }else{
                        System.out.println("구매성공"); // 아직 DB같은걸 안넣어서 상점을 나갔다들어오면 초기화가 됨
                        shopbutton1_1.setIcon(shopbuttonEnterImage);
                        shopbutton1_1.setBounds(69, 90, 360, 120);
                        shopitem1_1num = 1;

                        main.m_max += 2;
                        main.m_min += 2;
                    }

                }else{
                    System.out.println("구매취소");
                }

            }
        });
        add(shopbutton1_1);

        shopbutton1_2.setBounds(69, 240, 360, 130);
        shopbutton1_2.setBorderPainted(false);
        shopbutton1_2.setContentAreaFilled(false);
        shopbutton1_2.setFocusPainted(false);
        shopbutton1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbutton1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e){
                shopbutton1_2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 발생할 이벤트
                int result = JOptionPane.showConfirmDialog(null,"정말로 "+"해당 아이템"+"아이템을 구매하시겠습니까?","안내",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.CLOSED_OPTION){

                }else if (result == JOptionPane.YES_OPTION){
                    if (shopitem1_2num == 1){
                        System.out.println("구매 실패\n더이상 재고가 없는 아이템입니다.");
                    }else{
                        System.out.println("구매성공");
                        shopbutton1_2.setIcon(shopbuttonEnterImage);
                        shopbutton1_2.setBounds(69, 240, 360, 120);
                        shopitem1_2num = 1;
                    }

                }else{
                    System.out.println("구매취소");
                }

            }
        });
        add(shopbutton1_2);

        shopbutton1_3.setBounds(69, 390, 360, 130);
        shopbutton1_3.setBorderPainted(false);
        shopbutton1_3.setContentAreaFilled(false);
        shopbutton1_3.setFocusPainted(false);
        shopbutton1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbutton1_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e){
                shopbutton1_3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 발생할 이벤트
                int result = JOptionPane.showConfirmDialog(null,"정말로 "+"해당 아이템"+"아이템을 구매하시겠습니까?","안내",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.CLOSED_OPTION){

                }else if (result == JOptionPane.YES_OPTION){
                    if (shopitem1_3num == 1){
                        System.out.println("구매 실패\n더이상 재고가 없는 아이템입니다.");
                    }else{
                        System.out.println("구매성공");
                        shopbutton1_3.setIcon(shopbuttonEnterImage);
                        shopbutton1_3.setBounds(69, 390, 360, 120);
                        shopitem1_3num = 1;
                    }

                }else{
                    System.out.println("구매취소");
                }

            }
        });
        add(shopbutton1_3);

        shopbuttonRight.setBounds(432, 254, 52, 93);
        shopbuttonRight.setBorderPainted(false);
        shopbuttonRight.setContentAreaFilled(false);
        shopbuttonRight.setFocusPainted(false);
        shopbuttonRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbuttonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e){
                shopbuttonRight.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 발생할 이벤트
                ListNumber++;
            }
        });
        add(shopbuttonRight);

        shopbuttonLeft.setBounds(12, 254, 52, 93);
        shopbuttonLeft.setBorderPainted(false);
        shopbuttonLeft.setContentAreaFilled(false);
        shopbuttonLeft.setFocusPainted(false);
        shopbuttonLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                shopbuttonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e){
                shopbuttonLeft.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){ // 클릭시 발생할 이벤트
                ListNumber--;
            }
        });
        add(shopbuttonLeft);

        shopdrag.setBounds(0, 0, 500, 40);
        shopdrag.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        shopdrag.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                setLocation(x - mouseX, e.getYOnScreen()-mouseY);
            }
        });
        add(shopdrag);
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