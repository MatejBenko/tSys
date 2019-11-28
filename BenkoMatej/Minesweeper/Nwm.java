package BenkoMatej.Minesweeper;

import java.awt.Point;

class Nwm {

    private final Point location;

    private boolean hasMine;
    private boolean show;
    private int val;

    public Nwm(Point location) {
        this.location = location;
        this.hasMine = false;
        this.show = false;
        val=0;
    }

    public void setMine() {
        this.hasMine = true;
    }

    public boolean isMine() {
        return hasMine;
    }

    public boolean isShow() {
        return show;
    }

    public void show() {
        this.show = true;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}
