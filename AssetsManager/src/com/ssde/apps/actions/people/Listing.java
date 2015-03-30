package com.ssde.apps.actions.people;

import java.util.List;

import com.ssde.apps.actions.base.BaseAction;
import com.ssde.apps.data.Person;

public class Listing extends BaseAction {

	List<Person> person;
	public List<Person> getEvents(){return person;}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		person = services.getPeople();
		return "success";
	}
	
}
