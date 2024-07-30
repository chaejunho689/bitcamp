package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.err.println("Naver IP = " + naver.getHostAddress());
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("Local Host = " + local);
		System.out.println();
		
		// IP 하나당, InetAddress가 생겨야 함
		InetAddress[] naver2 = InetAddress.getAllByName("www.naver.net");
		for(InetAddress data : naver2) {
			System.out.println("naver IP = " + data.getHostAddress());
		}
		
	}                              
}
