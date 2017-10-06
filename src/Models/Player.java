package Models;

import java.io.*;

/**
 * Created by steve on 9/25/2017.
 */
public class Player {

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



}
