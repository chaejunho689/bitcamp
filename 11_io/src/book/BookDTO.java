package book;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BookDTO implements Serializable, Comparable<BookDTO> {
	@NonNull
	private int code, price, qty, total;
	@NonNull
	private String title, author;
	
//	public BookDTO() {}

	public BookDTO(int code, String title, String author, int price, int qty) {
		this.code = code;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
		this.Calc();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return code + "\t"
				+title + "\t"
				+author + "\t"
				+price + "\t"
				+qty + "\t"
				+total + "\t";
	}
	
	public void Calc() {
		this.total = price * qty;
	}
	
	// 총점으로 내림차 순.1
	public int compareTo(BookDTO bookDTO) {
		if(this.code > bookDTO.code) {
			return -1;
		} else if(this.code < bookDTO.code) {
			return 1;
		} else {
			return 0;
		}
	}
	

}
