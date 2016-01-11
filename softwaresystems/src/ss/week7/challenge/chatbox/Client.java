package ss.week7.challenge.chatbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * P2 prac wk4. <br>
 * Client. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Client extends Thread {

	private String clientName;
	private MessageUI mui;
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;
	private boolean connected;

	/**
	 * Constructs a Client-object and tries to make a socket connection
	 */
	public Client(String name, InetAddress host, int port, MessageUI muiArg)
			throws IOException {
		this.clientName = name;
		this.sock = new Socket(host, port);
		this.in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
		this.out = new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream()));
		this.mui=muiArg;
		connected=true;
	}

	/**
	 * Reads the messages in the socket connection. 
	 * Each message will be forwarded to the MessageUI
	 */
	public void run() {
		while (connected) {
			try {
				mui.addMessage(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** send a message to a ClientHandler. */
	public void sendMessage(String msg) {
		try {
			out.write(msg);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** close the socket connection. */
	public void shutdown() {
		mui.addMessage("Closing socket connection...");
		try {
			sock.close();
			in.close();
			out.close();
			connected = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** returns the client name */
	public String getClientName() {
		return clientName;
	}

}
