package BenkoMatej.Minesweeper;

public class Launch {

    public static void main(String[] args) {
        Setup sup = new Setup();
        Core co = new Core(sup);

        new ConsoleHandler(co);
    }
    
    
    public static void meh() {
    	System.out.println("anyway");
    }

}
