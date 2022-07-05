public class User 
{
	private String account;
	private String password;
	private String name;

	public User(String account, String password, String name)
	{
		setAccount(account);
		setPassword(password);
		setName(name);
	}

	public void setAccount(String account){this.account = account;}
	public String getAccount(){return account;}
	public void setPassword(String password){this.password = password;}
	public String getPassword(){return password;}	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}

}
