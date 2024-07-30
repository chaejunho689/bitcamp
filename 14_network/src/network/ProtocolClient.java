package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ProtocolClient {
	 Socket socket;
	 BufferedReader br;
	 BufferedWriter bw;
	 Scanner scan;
	 
	public ProtocolClient() {
		try {
			socket = new Socket("localhost", 9500);

			br = new BufferedReader((new InputStreamReader(socket.getInputStream())));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			scan = new Scanner(System.in);
		
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		
		String message, line;
		
		try {
			while(true) {
					// 서버로 보내기
					System.out.println();
					System.out.println("입장은 100:대화명이라고 입력하세요");
					System.out.println("퇴장은 200:대화명이라고 입력하세요.");
					System.out.println("메세지는 300:메시지 라고 입력하세요.");
//					System.out.print("종료하려면 200:대ㄴ화명 이라고 입력하세요.");
					System.out.print("입력 : ");
					message = scan.nextLine();
					
					bw.write(message + "\n"); //서버로 보내기
					bw.flush();
					
					line = br.readLine();
					System.out.println(line);
					String[] ar = line.split(":");
					
//					if(ar[0].equals("200")) {
					if(ar[0].equals(Protocol.EXIT)) {
						br.close();
						bw.close();
						socket.close();
						
						System.out.println("클라이언트 종료");
						System.exit(0);
					}
				}
			} catch (IOException e) {
					e.printStackTrace();
			}
				// 서버로 받기
		} //try

	public static void main(String[] args) {
		new ProtocolClient();
		
		
	}
}
