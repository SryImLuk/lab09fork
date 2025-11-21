package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static String sep = System.getProperty("file.separator"); 
    private File currFile = new File(new String(System.getProperty("user.home") + sep + "output.txt"));

    public void setFile(final String path){
        currFile = new File(path);
    }

    public File getFile() throws IOException{
        return currFile;
    }

    public String getPath() throws IOException{
        return currFile.getCanonicalPath();
    }

    public void write(String str) throws IOException{
        try(final OutputStream oStream = new FileOutputStream(currFile.getName())){
            DataOutputStream dStream = new DataOutputStream(oStream);
            dStream.writeChars(str);
        }
    }
}
