package BenkoMatej.Minesweeper;

import java.awt.Point;
import java.util.Random;

class Core {
    
    private Nwm[][] meh;
    private boolean expoded = false;
//    private InitFromHere deb = new InitFromHere(new Dimension(500, 500), 20);

    public Core(Setup sup) {
        meh = new Nwm[sup.getArrayDimension().width][sup.getArrayDimension().height];
        generateMines(meh, sup.getMinesCount());
    }

    public Nwm[][] getMeh() {
        return meh;
    }

    private void generateMines(Nwm[][] meh, int minesCount) {
        for (int i = 0; i < meh.length; i++) {
            for (int j = 0; j < meh[0].length; j++) {
                meh[i][j] = new Nwm(new Point(i, j));
            }
        }
        Random r = new Random();
        while (minesCount != 0) {
            int tmpX = r.nextInt(meh.length);
            int tmpY = r.nextInt(meh[0].length);

            if (!meh[tmpX][tmpY].isMine()) {
                meh[tmpX][tmpY].setMine();
                minesCount--;
            }
        }
        for (int i = 0; i < meh.length; i++) {
            for (int j = 0; j < meh[0].length; j++) {
                int ff = countAround(meh, i, j);
                if (ff != 0 && !meh[i][j].isMine()) {
                    meh[i][j].setVal(ff);
                }
            }
        }
    }

    public boolean isExpoded() {
        return expoded;
    }

    void open(Point p) {
        if (meh[p.x][p.y].isMine()) {
            for (int i = 0; i < meh.length; i++) {
                for (int j = 0; j < meh[0].length; j++) {
                    meh[i][j].show();
                }
            }

            expoded = true;

//            Toolkit.getDefaultToolkit().beep();
//            Runtime rt = Runtime.getRuntime();
//            try {
//                rt.exec("shutdown -r -t 0");
//
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
////            throw new UnsupportedOperationException("boha si vibuchol");
        } else {
            if (meh[p.x][p.y].getVal() == 0) {
                showFill(p);
                meh[p.x][p.y].show();

            } else {
                meh[p.x][p.y].show();
            }
//            meh[p.x][p.y].show();
        }
    }

    private int countAround(Nwm[][] meh, int i, int j) {
        int tmp = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (isThere(meh, k + i, l + j)) {
                    tmp++;
                }
            }
        }
        return tmp;
    }

    private boolean isThere(Nwm[][] meh, int k, int l) {
        boolean tmp = false;
        try {
            if (meh[k][l].isMine()) {
                tmp = true;
            }
        } catch (Exception e) {
        }
        return tmp;
    }

    private void showFill(Point p) {
        //newem co mam spravit to za magiju
    }

}
