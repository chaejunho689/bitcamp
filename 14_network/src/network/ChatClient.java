package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	public void connect() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 9500);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		System.out.println("서버에 연결되었음");
	}
	
	//서버로부터 JSON 데이터 받기
	public void receive() {
		// 람다 -> 러너블
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					String json = dis.readUTF(); //서버와 통신이 끊어지면 IOException 발생
					
					JSONObject jsonObject = new JSONObject(json);
					String clientIp = jsonObject.getString("clientIp");
					String chatName = jsonObject.getString("chatName");
					String message = jsonObject.getString("message");
					
					System.out.println("[" + chatName + "@" + clientIp + "]" +  message);
				}//while
			} catch (IOException e) {
				System.out.println("서버와 연결이 끊어졌음");
				System.exit(0);
			}
		});
		thread.start();
	}
	
	//서버로부터 JSON 데이터 보내기 - main 메소드에서 키보드로부터 입력한 메세지를 보낼 때 호출
	public void send(String json) throws IOException {
			dos.writeUTF(json);
			dos.flush();
	}
	
	
	public void unconnect() throws IOException {
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();
			
			Scanner scan = new Scanner(System.in);
			System.out.println("닉네임 입력");
			chatClient.chatName = scan.nextLine();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command","enter");
			jsonObject.put("data", chatClient.chatName);
			
			String json = jsonObject.toString();
			chatClient.send(json);
			
			chatClient.receive();
			
			System.out.println();
			System.out.println("메세지를 입력하세요.");
			System.out.println("클라이언트를 종료하려면 q를 입력하세요.");
			System.out.println();
			
			while(true) {
				String message = scan.nextLine();
				
				if(message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					
					json = jsonObject.toString();
					chatClient.send(json);
				}//if
				
			}//while
			
			chatClient.unconnect();
			
		} catch (IOException e) {
			System.out.println("서버와 연결이 안 됨");
		}
	}


}
