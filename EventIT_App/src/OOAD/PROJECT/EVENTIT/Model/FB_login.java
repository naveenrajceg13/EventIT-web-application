package OOAD.PROJECT.EVENTIT.Model;

import OOAD.PROJECT.EVENTIT.DBcontroller;

public class FB_login implements Login {

	User user;
	DBcontroller dbconnect;
	public FB_login() {
		dbconnect=new DBcontroller();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkuser(String Userid) {
		
		// TODO Auto-generated method stub
		try {
			user=dbconnect.getuser(Userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			return true;
			
		}
		return false;
	}
	
	public boolean createuser(String Userid,String name)
	{
		boolean isValid=false;
		boolean result=false;
		String username=Userid;
		String password="random12390812312randomcannotcreackthis";
		String firstname=name;
		String lastname="";
		String phone="";
		String address="";
		if((username!=null && username.trim().length()!=0) && (password!=null && password.trim().length()!=0))
		{
			
			
			try {
				user=new User();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(user!=null){
				result=user.updateuser(username, password, firstname, lastname, phone, address,0,0);
				
			}
			if(result==true)
			{
				isValid=dbconnect.saveuser(user);
				
				
			}
		}
		return isValid;
	}

}
