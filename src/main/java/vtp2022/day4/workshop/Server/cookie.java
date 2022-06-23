package vtp2022.day4.workshop.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.LinkedList;
import java.util.List;

public class cookie {


    public static String getCookieLines(InputStream is) throws IOException {
        
        int randomNumber;
        List<String> cookieJar = new LinkedList<>();
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        int lines = 0;
        String msg;
        String fortuneCookie;
        
        // count number of lines
        while((msg = br.readLine()) != null)
         {  cookieJar.add(msg);     // add to 
            lines++;
         }
        br.close();
        isr.close();    
        
        randomNumber = (int)(Math.random()* lines);
        fortuneCookie = cookieJar.get(randomNumber);

        return fortuneCookie;
    }
 




}
