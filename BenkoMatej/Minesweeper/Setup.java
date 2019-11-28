package BenkoMatej.Minesweeper;

import java.awt.Dimension;
import java.util.Scanner;

public class Setup {

    private final Dimension d;
    private final int minesCount;

    public Setup() {
        Scanner sc = new Scanner(System.in);

        int x = -1, y = -1, count = -1;

        System.out.println("init as <x>,<y>,<mines count>");
        System.out.println("for example: 9,10,11");

        boolean firstRun = true;
        
        do {
            if (!firstRun) {
                System.out.println("try again");
            }
            firstRun = false;
            try {
                String[] tmp = sc.nextLine().split(",");
                if (tmp.length != 3) {
                    continue;
                }
                
                x = Integer.parseInt(tmp[0]);
                y = Integer.parseInt(tmp[1]);
                count = Integer.parseInt(tmp[2]);

            } catch (Exception e) {
                continue;
            }

        } while (x < 1 || y < 1 || count < 1 || x > 1000 || y > 1000 || count >= (x * y));
        
        d=new Dimension(x, y);
        this.minesCount = count;
    }

    public Dimension getArrayDimension() {
        return d;
    }

    public int getMinesCount() {
        return minesCount;
    }

    @Override
    public String toString() {
        return d + " " + minesCount;
    }

}
