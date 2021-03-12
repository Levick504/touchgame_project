package project;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class main {

    public static int m_max = 2+1; //최대값

    public static int m_min = 1; //최소값

    public static int money_ = 0; //현재 돈의 양

    public static int money_up = (int)(Math.random()*(main.m_max-main.m_min))+main.m_min; //오르는 양

    public static DecimalFormat formatter = new DecimalFormat("###,###");

    public static int money_auto = 0;

    public static void main(String[] args) {

        new touchgame();

        while(true) {

            if (shop.ListNumber == 1) {
                shop.shopitemList1.setIcon(shop.shopListRed);
                shop.shopitemList2.setIcon(shop.shopListBlack);
                shop.shopitemList3.setIcon(shop.shopListBlack);
                shop.shopitemList4.setIcon(shop.shopListBlack);
                shop.shopitemList5.setIcon(shop.shopListBlack);
            } else if (shop.ListNumber == 2) {
                shop.shopitemList1.setIcon(shop.shopListBlack);
                shop.shopitemList2.setIcon(shop.shopListRed);
                shop.shopitemList3.setIcon(shop.shopListBlack);
                shop.shopitemList4.setIcon(shop.shopListBlack);
                shop.shopitemList5.setIcon(shop.shopListBlack);
            } else if (shop.ListNumber == 3) {
                shop.shopitemList1.setIcon(shop.shopListBlack);
                shop.shopitemList2.setIcon(shop.shopListBlack);
                shop.shopitemList3.setIcon(shop.shopListRed);
                shop.shopitemList4.setIcon(shop.shopListBlack);
                shop.shopitemList5.setIcon(shop.shopListBlack);
            } else if (shop.ListNumber == 4) {
                shop.shopitemList1.setIcon(shop.shopListBlack);
                shop.shopitemList2.setIcon(shop.shopListBlack);
                shop.shopitemList3.setIcon(shop.shopListBlack);
                shop.shopitemList4.setIcon(shop.shopListRed);
                shop.shopitemList5.setIcon(shop.shopListBlack);
            } else if (shop.ListNumber == 5) {
                shop.shopitemList1.setIcon(shop.shopListBlack);
                shop.shopitemList2.setIcon(shop.shopListBlack);
                shop.shopitemList3.setIcon(shop.shopListBlack);
                shop.shopitemList4.setIcon(shop.shopListBlack);
                shop.shopitemList5.setIcon(shop.shopListRed);
            } else if (shop.ListNumber == 6){
                shop.ListNumber = 1;
            }else{
                shop.ListNumber = 5;
            }
        }
    }
}
