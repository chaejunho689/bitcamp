package class_;

import java.text.DecimalFormat;

public class SalaryDTO {
	private String name;
	private String job;
	private int basic, extra, total, salary, tax, rate;
	
	public void setData(String n, String j, int b, int e) {
		name = n;
		job = j;
		basic = b;
		extra = e;
	}
	
	public void calc() {
		total = basic + extra;
		
		if(total >= 5000000) {
			rate = 3;
		} else if(total >= 3000000) {
			rate = 2;
		} else { rate = 1;}
		
		tax = total * rate / 100;
		salary = total - tax;
	}
	
	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
	
	public int getBasic() {
		return basic;
	}
	
	public int getExtra() {
		return extra;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getRate() {
		return rate;
	}
	
	public int getTax() {
		return tax;
	}
	
	
	
}
