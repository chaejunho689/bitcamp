package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	ServerSocket serverSocket; // 클라이언트의 연결 요청을 수락
	ExecutorService threadPool = Executors.newFixedThreadPool(100); // 100개의 클라이언트가 동시에 채팅함 
	Map<String, ChatHandler> chatRoom = Collections.synchronizedMap(new HashMap<>()); // 통신용 ChatHandler를 관리하는 동기화된 Map 컬렉션
	
	private void start() throws IOException {
		serverSocket = new ServerSocket(9500);
		System.out.println("서버 준비 완료");
		
		Thread thread = new Thread(() -> { //Runnable을 람다식으로 표현
			try {
				while(true) {
					Socket socket = serverSocket.accept(); // 연결 수락하고 , 통신용 SocketClient반복해서 생성
					ChatHandler chatHandler = new ChatHandler(this, socket);
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		});
		thread.start(); //스레드 시작
	} // start
	
	public void addSocketClient(ChatHandler chatHandler) {
		String key = chatHandler.chatName + "@" + chatHandler.clientIp;
		chatRoom.put(key, chatHandler);
		System.out.print("입장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}

	public void removeSocketClient(ChatHandler chatHandler) {
		String key = chatHandler + "@" + chatHandler.clientIp;
		chatRoom.remove(key);
		System.out.print("퇴장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}
	
	// 모든 클라이언트로 메시지 보냄
		public void sendToAll(ChatHandler sender, String message) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("clientIp", sender.clientIp);
			jsonObject.put("chatName", sender.chatName);
			jsonObject.put("message", message);
			
			String json = jsonObject.toString(); // json 객체를 String으로 변환 
			
			Collection<ChatHandler> collection = chatRoom.values();
			for(ChatHandler chatHandler : collection) {
				if(chatHandler == sender) continue;
				chatHandler.send(json);
			}
			
		}
	
	private void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			
			chatRoom.values().stream().forEach(ch -> ch.close());
			System.out.println("서버 종료");
		} catch (IOException e) {
		}
		//		chatRoom.values().stream().forEach(sc -> sc.close);		
	}
	
	
	public static void main(String[] args) {
		
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println();
			System.out.println("서버를 종료하려면 q를 입력하세요.");
			System.out.println();
			
			Scanner scan = new Scanner(System.in);
			while(true) {
				String key = scan.nextLine();
				if(key.toLowerCase().equals("q")) {
					break;
				}
			}
			
			scan.close();
			chatServer.stop();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[서버] " + e.getMessage());
		}
		
	}
	
	


}
