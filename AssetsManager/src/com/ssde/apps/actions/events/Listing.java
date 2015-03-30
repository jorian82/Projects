package com.ssde.apps.actions.events;

import java.util.List;

import com.ssde.apps.actions.base.BaseAction;
import com.ssde.apps.data.Event;

public class Listing extends BaseAction {

	List<Event> events;
	public List<Event> getEvents(){return events;}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		events = services.getEvents();
		return "success";
	}
	
}
