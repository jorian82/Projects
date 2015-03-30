package com.ssde.apps.services;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssde.apps.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// This class is the business services tier in the application.
// @Transactional is needed so that a Hibernate transaction is set up,
// otherwise updates won't have an effect

@Transactional
public class Services {
	
	// So spring can inject the sesison factory
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory value) {
		sessionFactory = value;
	}
	
	// Shortcut for sessionFactory
	public Session sess() {
		return sessionFactory.getCurrentSession();
	}
	
	public Event getEventById(long id) {
		return (Event) sess().load(Event.class, id);
	}
	
	public Person getPersonById(long id) {
		return (Person) sess().load(Person.class, id);
	}
	
	public Device getDeviceById(long id) {
		return (Device) sess().load(Device.class, id);
	}
	
	public Responsible getResponsibleById(long id) {
		return (Responsible) sess().load(Responsible.class, id);
	}
	
	public Part getPartById(long id){
		return (Part) sess().load(Part.class, id);
	}
	
	public List<Device> getDevicesByResponsibleId(long id) {
		return new ArrayList<Device>(getResponsibleById(id).getDevices());
	}
	
	public List<Part> getPartsByDeviceId(long id) {
		return new ArrayList<Part>(getDeviceById(id).getParts());
	}
	
	public List<Repair> getRepairsByDeviceId(long id) {
		return new ArrayList<Repair>(getDeviceById(id).getRepairs());
	}
	
	public void deleteResponsibleById(long id) {
		sess().delete(getResponsibleById(id));
	}
	
	public void deleteDeviceById(long id) {
		sess().delete(getDeviceById(id));
	}
	
	
	
	public void deleteEventById(long id) {
		sess().delete(getEventById(id));
	}
	
	public void deletePersonById(long id){
		sess().delete(getPersonById(id));
	}
	
	public void createEvent(String name) {
		Event e = new Event();
		e.setName(name);
		sess().save(e);
	}
	
	public void createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		sess().save(p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents() {
		return sess().createQuery("from Event").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {
		return sess().createQuery("from Person").list();
	}
	
	public void removePersonFromEvent(int personId, int eventId) {
		getEventById(eventId).getPeople().remove(getPersonById(personId));
	}
	
	public void addPersonToEvent(int personId, int eventId) {
		getEventById(eventId).getPeople().add(getPersonById(personId));
	}
}
