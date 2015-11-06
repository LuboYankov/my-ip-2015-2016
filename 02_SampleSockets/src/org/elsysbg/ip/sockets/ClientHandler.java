package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

	private final Socket socket;
	private static final String COMMAND_STOP_SERVER = "stopServer";
	private final EchoServer echoServer;
	
	public ClientHandler(Socket socket, EchoServer echoServer) {
		this.socket = socket;
		this.echoServer = echoServer;
	}
	
	@Override
	public void run() {
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			while(scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if(COMMAND_STOP_SERVER.equals(line)) {
					echoServer.stopServer();
				}
				out.println(line);
			}
			scanner.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
