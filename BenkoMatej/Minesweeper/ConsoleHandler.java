package BenkoMatej.Minesweeper;

import BenkoMatej.Minesweeper.Nwm;
import java.awt.Point;
import java.util.Scanner;

class ConsoleHandler {

    private final Scanner sc;
    private final Core co;

    ConsoleHandler(Core co) {
        sc = new Scanner(System.in);
        this.co = co;

        System.out.println("use X,Y\n 1 ====> +Y\n||\n||\n\\/\n+X");
        while (true) {
            print(co.getMeh());
            if (co.isExpoded()) {
                break;
            }
            co.open(parse());
        }
        System.out.println("BOOOOO \nnow you have more than one peace\n:D");
    }

    private Point parse() {
        int x = -1, y = -1;
        boolean runOunce = true;
        do {
            if (!runOunce) {
                System.out.println("try again");
            }
            runOunce = false;
            try {
                String[] tmp = sc.nextLine().split(",");

                x = Integer.parseInt(tmp[0]) - 1;
                y = Integer.parseInt(tmp[1]) - 1;
            } catch (Exception e) {
            }
        } while (x < 0 || y < 0 || x > co.getMeh().length - 1 || y > co.getMeh()[0].length - 1);
        return new Point(x, y);
    }

    private void print(Nwm[][] meh) {
        for (int i = 0; i < meh.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < meh[0].length; j++) {
                if (meh[i][j].isShow()) {
                    if (meh[i][j].isMine()) {
                        tmp.append(" X");
                    } else {
                        if (meh[i][j].getVal() == 0) {
                            tmp.append("  ");
                            continue;
                        }
                        tmp.append(" " + meh[i][j].getVal());
                    }
                } else {
                    tmp.append(" -");
                }
            }
            System.out.println(tmp.toString());
        }
    }


}