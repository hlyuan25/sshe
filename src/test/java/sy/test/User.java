package sy.test;

public class User {
	private String username;
	private Group group;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public int addSomething(int a, int b){
		return a + b;
	}
	
}
