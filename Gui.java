package com.company;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Gui  extends JFrame{
    JPanel pnl = new JPanel();
    //konstruktor initialisieren
    Gui(){


        Button vsCpu =new Button("gegen Computer");
        Button vsPl = new Button("gegen Spieler");
        JButton restart = new JButton("Neu starten");
        pnl.setLayout(new java.awt.GridLayout(3,3));

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++) {
                JButton btn = new JButton();
                String s = i+""+j;
                btn.setText("");
                btn.setName(s);
                btn.addActionListener(
                        e-> {
                            TicTacToe.btnClicked(btn);
                            TicTacToe.regeln(btn);
                        }
                );
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pnl.add(btn);
            }
        }
        restart.addActionListener(
                e-> {
                    TicTacToe.restartClicked(restart);
                    pnl.getComponents();
                    for(Component c: pnl.getComponents()) { //Alle Komponenten in panel, weiss datentyp vermutlich nicht
                        JButton btn = (JButton) c; //"casten" damit compiler weiss, dass component c jbuttons sind.
                        btn.setText(""); //über btn können wir die texte der JButtons(felder) bearbeiten
                    }

                }
        );

        pnl.setBounds(300,100,600,600);
        vsCpu.setBounds(30,150,130,30);
        vsPl.setBounds(30,200,130,30);
        restart.setBounds(30,250,130,30);

        //button in frame einfügen, da im Konstruktor mit add(comp)
        this.add(vsCpu);
        this.add(vsPl);
        this.add(restart);
        this.add(pnl);

        this.setSize(1200,800);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
}
