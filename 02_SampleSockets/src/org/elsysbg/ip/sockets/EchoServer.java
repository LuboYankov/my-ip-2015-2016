package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private boolean running;
	private final int port;
	
	public EchoServer(int port) {
		this.port = port;
		this.running = false;
	}
	
	public void startServer() throws IOException {
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		while(isRunning()) {
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(socket, this);
			new Thread(client).start();
		}
		serverSocket.close();
	}

	private synchronized void setRunning() {
		if(running) {
			throw new IllegalStateException("Already running");
		}
		running = true;
	}

	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized void stopServer() {
		running = false;
	}
	
}
