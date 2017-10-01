package Models;

import java.io.*;

/**
 * Created by steve on 9/25/2017.
 */
public class Player  implements Serializable {

    String name;
    char mark;
    boolean active;

    public Player(String name, char mark, boolean active) {
        this.name = name;
        this.mark = mark;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static void write(Player one,Player two) throws Exception {
        File file = new File("save.txt");
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fo);
        output.writeObject(one);
        output.writeObject(two);
        output.close();
    }
    public static Player[] read () throws Exception {
        Player[] players = new Player[2];
        File file = new File("save.txt");
        FileInputStream fo = new FileInputStream(file);
        ObjectInputStream output = new ObjectInputStream(fo);
        players[0] = (Player)output.readObject();
        players[1] = (Player)output.readObject();
        output.close();
        return players;
    }

}
