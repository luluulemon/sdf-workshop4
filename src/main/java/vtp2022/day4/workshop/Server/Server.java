package vtp2022.day4.workshop.Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    
    
    public void start(){ 

        boolean stop = false;

        try{
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Starting serving... waiting for client connection");
        System.out.println("listening on port 8888");
        Socket socket = server.accept();   

        while(!stop){
            
            String input = null;

            InputStream is = socket.getInputStream(); 
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            input = dis.readUTF();
            System.out.println(input);
            
            //catch(IOException e){ e.printStackTrace(); }


            if (input.contains("get-cookie")){
                System.out.println("does it get here");
                OutputStream os = socket.getOutputStream(); 
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);

                InputStream cis = new FileInputStream("cookie_file.txt");
                String msg = cookie.getCookieLines(cis);
                System.out.println(msg);
                dos.writeUTF("cookie-text,"+msg);
                    // do all the closings
                dos.flush();
                //catch(IOException e){ e.printStackTrace(); }              
            }

            else if( input.contains("stop")){ stop = true; }

            else { System.out.println("invalid cmd la");}
        }
    
    System.out.println("Hope u enjoyed ur cookies!");
    socket.close();
    server.close();
    }
    catch(IOException e){ System.err.println(); }
    }


    public static void main(String[] args) {

        Server server = new Server();
        server.start();
    }


}

