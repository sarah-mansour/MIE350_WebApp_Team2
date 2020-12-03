package model;


//IGNORE THIS CLASS
public class Wishlist {
	
	private Account account;
	private Model model;
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	@Override
	public String toString () {
		return String.format("%s wishes to have  %s", account, model);
	}
	
	
}
