package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class ChatHandler {
	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	String clientIp;

	public ChatHandler(ChatServer chatServer, Socket socket) throws IOException {
		this.chatServer = chatServer;
		this.socket = socket;
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
		clientIp = isa.getHostName();
		
		receive();
	}

	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while(true) {
					String receiveJSON = dis.readUTF();
					
					JSONObject jsonObject = new JSONObject(receiveJSON);
					String command = jsonObject.getString("command");
					
					switch(command) {
					case "enter" : 
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "입장하셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message" :
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "퇴장하셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
