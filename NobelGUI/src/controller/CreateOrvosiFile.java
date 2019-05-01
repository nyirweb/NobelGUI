package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nyirweb
 */
public class CreateOrvosiFile 
{
    public static void createOrvosiFile(ArrayList<String> result, String fileName)
    {
        RandomAccessFile raf;
        try 
        {
            raf = new RandomAccessFile(fileName, "rw");
            for (String line : result) 
            {
                raf.writeBytes(line+"\r"+"\n");
            }
        }
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        } catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
}
