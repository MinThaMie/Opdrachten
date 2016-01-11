package ss.week7.challenge.chatbox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import ss.week7.cmdchat.ClientHandler;

/**
 * P2 prac wk5. <br>
 * Server. A Thread class that listens to a socket connection on a 
 * specified port. For every socket connection with a Client, a new 
 * ClientHandler thread is started. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server extends Thread {
    private int port;
    private MessageUI mui;
    private Collection<ClientHandler> threads;

    /** Constructs a new Server object */
    public Server(int portArg, MessageUI muiArg) {
    	this.port = portArg;
		this.threads = new ArrayList<ClientHandler>();
		this.mui=muiArg;
    }

    /**
     * Listens to a port of this Server if there are any Clients that 
     * would like to connect. For every new socket connection a new
     * ClientHandler thread is started that takes care of the further
     * communication with the Client.
     */
    public void run() {
    	System.out.println("server started");
		ServerSocket servSock = null;
		try {
			servSock = new ServerSocket(this.port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {

				Socket sock = servSock.accept();
				System.out.println("connected to new client");
				ss.week7.challenge.chatbox.ClientHandler clientHandler = new ss.week7.challenge.chatbox.ClientHandler(this,sock);
				addHandler(clientHandler);
				System.out.println("handler created");
				
				clientHandler.announce();
				Thread clientHandlerThread = new Thread(clientHandler);

				clientHandlerThread.start();
				System.out.println("handler started");
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
    }

    /**
     * Sends a message using the collection of connected ClientHandlers
     * to all connected Clients.
     * @param msg message that is send
     */
    public void broadcast(String msg) {
    	System.out.println(msg);
		for (ClientHandler client : threads) {
			client.sendMessage(msg);
		}
    }

    /**
     * Add a ClientHandler to the collection of ClientHandlers.
     * @param handler ClientHandler that will be added
     */
    public void addHandler(ClientHandler handler) {
    	threads.add(handler);
		System.out.println("handler added");
    }

    /**
     * Remove a ClientHandler from the collection of ClientHanlders. 
     * @param handler ClientHandler that will be removed
     */
    public void removeHandler(ClientHandler handler) {
    	threads.remove(handler);
		System.out.println("handler added removed");
    }

}

