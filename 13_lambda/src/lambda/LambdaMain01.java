package lambda;

public class LambdaMain01 {
	
	public void execute(Compute compute) {
		int x = 25;
		int y = 36;
	
		compute.calc(x, y);
	};

	public static void main(String[] args) {
		LambdaMain01 lambdaMain01 = new LambdaMain01();
		
		
		lambdaMain01.execute((x, y) -> {
			int result = x + y;
			System.out.println(x + " x " + y + " = " + result);
		});
		
		lambdaMain01.execute((x,y) -> {
			int result = x * y;
			System.out.println(x + " * " + y + " = " + result);
			
		});
	}
}
