package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStream2 {
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt"); //파일 생성
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		
		int size = (int) file.length(); // 파일 크기

		//파일의 크기 만큼 byte[] 생성
		byte[] b = new byte[size];
		
		// 파일안의 내용에 한번에 읽기
		bis.read(b, 0, size);
		
		System.out.println(new String(b)); // byte[] => String 변환
		bis.close();
	}
}
