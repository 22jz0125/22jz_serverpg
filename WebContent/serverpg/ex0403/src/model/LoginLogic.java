package model;

public class LoginLogic{
	public boolean execute (User user) {
		if (user.getId().equals("22jz0125") && user.getPassword().equals("22jz0144")) {
			return true;
		}
		else {
			return false;
		}
	}
}
