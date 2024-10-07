package sample05;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private OutPutter outputter;

	
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("MessageBeanImpl(String name)");
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setPhone(String phone)");

	}

	public void setOutputter(OutPutter outputter) {
		this.outputter = outputter;
		System.out.println("setOutputter(OutPutter outputter");

	}

	
	@Override
	public void helloCall() {
		System.out.println("helloCall");
		outputter.output("나의 이름은 : " + name + "이고, " + "핸드폰은 " + phone + "이다.");
	}
}
