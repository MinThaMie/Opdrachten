
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " +  " <name> <port>";
 

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }
    	
    	String name = args[0];
    	int port=0;
    	ServerSocket serverSock=null;
    	
    	// parse args[1] - the port
    	 try {
             port = Integer.parseInt(args[1]);
         } catch (NumberFormatException e) {
             System.out.println(USAGE);
             System.out.println("ERROR: port " + args[1]
             		           + " is not an integer");
             System.exit(0);
         }
    	 
    	 try {
             serverSock = new ServerSocket(port);      
             System.out.println("server started");
         } catch (IOException e) {
             System.out.println("ERROR: could not create a socket on port " + port);
         }  
    	 
    	 try {
             Socket clientsocket = serverSock.accept();
             Peer server = new Peer(name, clientsocket);
             Thread streamInputHandler = new Thread(server);
             System.out.println("connected to client");
             streamInputHandler.start();
             server.handleTerminalInput();
             server.shutDown();
             serverSock.close();
             clientsocket.close();
         } catch (IOException e) {
             e.printStackTrace();
         } 
    	 System.exit(0);
    }

} // end of class Server
