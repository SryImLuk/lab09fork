package it.unibo.mvc;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String str = "";
    ArrayList<String> strHistory = new ArrayList<String>();

    @Override
    public void nextString(String next) throws IOException {
        if(next == null){
            throw new IOException();
        }else{
            this.str = next;
        }
    }

    @Override
    public String getString() {
        return str;
    }

    @Override
    public ArrayList<String> getHistory() {
        return strHistory;
    }

    @Override
    public void printString() {
        try {
            strHistory.add(str);
        System.out.println(str);
        } catch (IllegalStateException e) {
            throw e;
        }
    }
    
}
