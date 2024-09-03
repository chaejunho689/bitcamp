package Account;

public class AccountDTO {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_email;
	private String user_phonenumber;
    private String user_address;

    public AccountDTO(String user_id, String user_pw, String user_name, String user_email, String user_address, String user_phonenumber) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_address = user_address;
        this.user_phonenumber = user_phonenumber;
        this.user_email = user_email;
    }

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
    public String getUser_name() {
		return user_name;
	}
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_phonenumber() {
		return user_phonenumber;
	}


	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}


	public String getUser_address() {
		return user_address;
	}


	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


    
}
