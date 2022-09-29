package membership;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	private String birth;
	private String addr;
	private String email;
	
	public String getId() {return id;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	public String getRegidate() {return regidate;}
	public String getBirth() {return birth;}
	public String getAddr() {return addr;}
	public String getEmail() {return email;}
	
	public void setId(String id) {this.id = id;}
	public void setPass(String pass) {this.pass = pass;}
	public void setName(String name) {this.name = name;}
	public void setRegidate(String regidate) {this.regidate = regidate;}
	public void setBirth(String birth) {this.birth = birth;}
	public void setAddr(String addr) {this.addr = addr;}
	public void setEmail(String email) {this.email = email;}
	
	
}
