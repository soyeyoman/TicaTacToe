package Models;

public class GameResult {
    private int[] pos1;
    private int[] pos2;
    private int[] pos3;
    private  boolean win;

    public GameResult(int[] pos1, int pos2[], int pos3[],boolean win){
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.win = win;
    }

    public String getPos1() {
        return getStr(this.pos1);
    }

    public String getPos2() {
        return getStr(this.pos2);
    }

    public String getPos3() {
        return getStr(this.pos3);
    }

    private String getStr(int[] pos) {

        char i = pos[0] == 0?'z':pos[0] == 1?'o':pos[0] == 2?'t':pos[0] == 3?'h':'e';
        char j  = pos[1] == 0?'0':pos[1] == 1?'1':pos[1] == 2?'2':pos[1] == 3?'3':'9';

        return String.format("%c%c",i,j);
    }

    public boolean isWin() {
        return win;
    }
}
