package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
	ServerSocket serverSocket; // 클라이언트가 올 때가지 기다린다.
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("서버 준비 완료...");
			
			socket = serverSocket.accept();
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		
		String line;
		
		try {
			while(true) {
				//클라이언트로 부터 받기
				line = br.readLine();
				String[] ar = line.split(":");
		
				//클라이언트로 보내기
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1] + "님 입장했습니다. \n");
					bw.flush();
					
					
				} else if(ar[0].equals(Protocol.EXIT)) { // 퇴장
					bw.write(ar[1] + "님 퇴장했습니다. \n");
						bw.flush();
						
						br.close();
						bw.close();
						socket.close();
						
						System.out.println("서버 종료");
						System.exit(0);
				} else if(ar[0].equals(Protocol.SEND_MESSAGE)) { //메시지 : 300 : 대화명메시지
					 bw.write("[" + ar[1] + "] " + ar[2] + "\n");
					 bw.flush();
				}
			}
		} catch (IOException e) {

		}
	}
	
	public static void main(String[] args) {
		new ProtocolServer();
	
	}
}
