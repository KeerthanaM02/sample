package springmvc_example.model;

public class User {
	 private String user_name;
	 private String mail_id;
	 private String password;
	 
	 public User() {
	  super();
	 }
	 
	 public User(String user_name) {
	  super();
	  this.user_name= user_name;
	 }

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 
}
