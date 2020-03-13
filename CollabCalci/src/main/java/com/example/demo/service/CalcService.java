package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcService {

	
	Map<String, List<String>> users = new HashMap();
	ArrayList<String> results = new ArrayList();
	
	public void addUser(String user, String result) {
		if(users.get(user)!=null) {
			users.get(user).add(result);
		}else {
			ArrayList<String> userResults = new ArrayList();
			userResults.add(result);
			users.put(user, userResults);
		}
		results.add(result);
		
	}

	public List<String> getAllResults() {
		return results.subList(0, 10);
	}

	public void deleteUserById(String id) {
		ArrayList<String> userRes = (ArrayList<String>) users.get(id);
		for(String res : userRes) {
			if(results.contains(res))
				results.remove(res);
		}
		users.remove(id);
	}

	
}
