package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UsersListWrapper {
	
	List<UserWrapper> usersList;

	
	public UsersListWrapper() {
		usersList = new ArrayList<>();
	}

	public List<UserWrapper> getThemeList() {
		return usersList;
	}

	public void addUserWrapper(UserWrapper userWrapper){
		usersList.add(userWrapper);
	}
	
	@Override
	public String toString() {
		String result = "{\"usersList\":[ ";
		for (UserWrapper userWrapper : usersList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
