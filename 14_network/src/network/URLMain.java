package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.Line;

public class URLMain {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://naver.com/html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getDefaultPort());
		System.out.println("기본 폴트 = " + url.getProtocol());
		System.out.println("파일 = " + url.getProtocol());
		System.out.println();
		// IO
		BufferedReader br  = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String line = null;
		while( (line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
