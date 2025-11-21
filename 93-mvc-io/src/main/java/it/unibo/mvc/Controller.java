 package it.unibo.mvc;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public interface Controller {

    public void nextString(final String next) throws IOException;

    public String getString();

    public ArrayList<String> getHistory();

    public void printString();
}
