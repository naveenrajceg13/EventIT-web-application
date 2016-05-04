package OOAD.PROJECT.EVENTIT.Model;

public class User {

	public String lastname;
	public String firstname;
	public String email;
	public String address;
	public String phone;
	public String password;
	public float rating;
	public int total_rating;

	/**
	 * 
	 * @param userid
	 * @param password
	 */
	public boolean Checklogin(String userid, String password1) {
		// TODO - implement User.Checklogin
		if(userid.equalsIgnoreCase(email) && password.equalsIgnoreCase(password1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 
	 * @param Userid
	 * @param Emailid
	 * @param password
	 * @param name
	 * @param phone
	 * @param address
	 */
	public boolean updateuser(String emailid1, String password1, String firstname1, String lastname1, String phone1, String address1,float rating,int total_rating) {
		this.email=emailid1;
		this.password=password1;
		this.firstname=firstname1;
		this.address=address1;
		this.phone=phone1;
		this.lastname=lastname1;
		this.rating=rating;
		this.total_rating=total_rating;
		return true;
	}

	public User() {
		this.rating=0;
	}
	public User(String email1,String password1,String firstname1,String lastname1,String phone1,String address1,float rating,int total_rating)
	{
		email=email1;
		password=password1;
		firstname=firstname1;
		address=address1;
		phone=phone1;
		lastname=lastname1;
		this.rating=rating;
		this.total_rating=total_rating;
	}
	public boolean updateRating(int rating)
	{
		this.rating=this.rating+rating;
		return true;
	}

}