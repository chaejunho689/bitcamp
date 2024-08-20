	// 빈 객체로 생성
	var calc = {}
	
	//멤버변수 추가
	calc.x = 0;
	calc.y = 0;
	
	
	//멤버 함수
	calc.setValue = function(x, y) {
		this.x = x;
		this.y = y;
	}
	
	calc.plus = function() {
		return this.x + this.y;
	}
	
	calc.minus = function() {
		return this.x - this.y;		
	}
	
	calc.result = function() {
		var sum = this.plus();
		var sub = this.minus();
		document.write("<div>" + "합계 = " + sum + "<br>" + "빼기 = " + sub + "</div>"); 
	}

/*


	|
	|
	|
	V

// 클래스 선언
public class Calc {
	public int x = 0;	
	public int y = 0;	
	
	public void setValue(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void plus() {
		return x+y;
	}
	public void minus() {
		return x-y;		
	}
	public void result() {
		int sum = plus();		
		int sub = minus();
		
		System.out.println("덧셈 = " + sum + "뺄셈 = " + sub);		
	}
}

//객체 생성 
Calc calc = new Calc();
calc.x = 25;

*/