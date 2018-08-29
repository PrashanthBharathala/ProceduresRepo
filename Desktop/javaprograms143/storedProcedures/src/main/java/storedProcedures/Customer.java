package storedProcedures;

public class Customer {
	
	private int cid;
	private String firstname;
	private String lastname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	

}
