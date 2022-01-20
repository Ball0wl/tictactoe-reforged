package com.company;

import javax.swing.*;

public class TicTacToe{

    public static int  zaehler = 0;
    public static String[][] feld = new String[3][3];

    public static void btnClicked(JButton btn) {
        if(btn.getText().equals("")) {
            zaehler++;
            if(zaehler%2==1){
                btn.setText("X");
            }if(zaehler%2==0){
                btn.setText("O");
            }
        }
    }
    public static void restartClicked(JButton btn) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
               feld[i][j]=null;
            }
        }
        zaehler=0;
        }
    public static void regeln(JButton btn) {
        String s = btn.getText();

        // s = 00 01 02 10 11 12 20 21 22 als String
        int x = Character.getNumericValue(btn.getName().charAt(0));
        int y = Character.getNumericValue(btn.getName().charAt(1));
        // onclick gibt 00 für oben links 01 oben mitte 02 oben rechts 10 mitte links usw.
        // umwandlung von string zu zahl
        feld[x][y] = s;
            //checkt ob oben links existiert und gleich feld mitte mitte ist und ob mitte mitte rechts unten ist. einfach \ diag.
            if (feld[0][0] != null && feld[0][0].equals(feld[1][1]) && feld[1][1].equals(feld[2][2])) {
                JOptionPane.showMessageDialog(btn, s + " hat gewonnen.");
                //oben rechts einfach / diag.
            } else if (feld[0][2] != null && feld[0][2].equals(feld[1][1]) && feld[1][1].equals(feld[2][0])) {
                JOptionPane.showMessageDialog(btn, s + " hat gewonnen.");
            } else if (zaehler == 9) {
                JOptionPane.showMessageDialog(btn, "unentschieden.");
                zaehler=0;

            } else {
                //horizontal
                for (int i = 0; i < 3; i++) {
                    if (feld[i][0] != null && feld[i][0].equals(feld[i][1]) && feld[i][0].equals(feld[i][2])) {
                        JOptionPane.showMessageDialog(btn, s + " hat gewonnen.");
                        break;
                    }
                    // vertikal
                    if (feld[0][i] != null && feld[0][i].equals(feld[1][i]) && feld[0][i].equals(feld[2][i])) {
                        JOptionPane.showMessageDialog(btn, s + " hat gewonnen.");
                        break;
                    }
                }
            }
        }
    }

