package ss.week7.cmdchat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Server.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	private static final String USAGE = "usage: " + Server.class.getName() + " <port>";

	/** Start een Server-applicatie op. */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(0);
		}

		Server server = new Server(Integer.parseInt(args[0]));
		server.run();

	}

	private int port;
	private List<ClientHandler> threads;

	/** Constructs a new Server object */
	public Server(int portArg) {
		this.port = portArg;
		threads = new ArrayList<ClientHandler>();
	}

	/**
	 * Listens to a port of this Server if there are any Clients that would like
	 * to connect. For every new socket connection a new ClientHandler thread is
	 * started that takes care of the further communication with the Client.
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
				ClientHandler clientHandler = new ClientHandler(this, sock);	
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

	public void print(String message) {
		System.out.println(message);
	}

	/**
	 * Sends a message using the collection of connected ClientHandlers to all
	 * connected Clients.
	 * 
	 * @param msg
	 *            message that is send
	 */
	public void broadcast(String msg) {
		System.out.println(msg);
		for (ClientHandler client : threads) {
			client.sendMessage(msg);
		}
	}

	/**
	 * Add a ClientHandler to the collection of ClientHandlers.
	 * 
	 * @param handler
	 *            ClientHandler that will be added
	 */
	private void addHandler(ClientHandler handler) {
		threads.add(handler);
		System.out.println("handler added");
	}

	/**
	 * Remove a ClientHandler from the collection of ClientHanlders.
	 * 
	 * @param handler
	 *            ClientHandler that will be removed
	 */
	public void removeHandler(ClientHandler handler) {
		threads.remove(handler);
		System.out.println("handler added removed");
	}
}
