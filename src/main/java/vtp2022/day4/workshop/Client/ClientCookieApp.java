package vtp2022.day4.workshop.Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



/**
 * Hello world!
 *
 */
public class ClientCookieApp 
{   
    public static void main( String[] args )
    {   
        int portNumber = 8888;
        String address = "localhost";

        if(args.length>0){
            address = args[0].split(":")[0];
            portNumber = Integer.parseInt(args[0].split(":")[1]);   }

        try{
            Socket socket = new Socket(address,portNumber);

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            OutputStream os = socket.getOutputStream();        
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            Console cons = System.console();
            String input = cons.readLine("Simi daiji > ");
            System.out.println(input);
            dos.writeUTF(input);
            dos.flush();    
        
       
            String response = dis.readUTF();  
            System.out.println(response);                                                      
                           
            if(response.contains("cookie-text"))
            {   System.out.println(response.split(",")[1]);}

            // dis.close();
            // bis.close();
            // is.close();

            // dos.close();
            // bos.close();
            // os.close();
            socket.close();
        }
        catch(IOException e){   System.err.println();   }



    }

}
