// OBSERVER
// Don't missout when something interesting happens.
// You can view like news paper subscription model
// Defination: Observer describes one-to-many relationship between objects where one object state is changed all dependet objects gets notified.
// Design Pattern: Strive for loosly coupled design between the objects that they interact.
// We can implement pull/push mechanism. With Java util Observable we can implement pull mechanism.
// In pull mechanism Observer gets notified and observer enquires the subject about the change.

import java.io.*;
import java.util.*;

class ObserverCheck
{
	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		RetinaDisplay rd = new RetinaDisplay(wd);
		LedDisplay ld = new LedDisplay(wd);
		wd.changeData((float)12.1, (float)13.1);
		wd.changeData((float)22.1, (float)23.1);
	}
}


interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}


class WeatherData implements Subject {

	private ArrayList<Observer> observers;
	private float temparature;
	private float humidity;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>0) {
			observers.remove(i);
		}
	}
	public void notifyObservers() {
		for(Observer o: observers) {
			o.update(this.temparature, this.humidity);
		}
	}

	public void changeData(float temparature, float humidity) {
		this.temparature = temparature;
		this.humidity = humidity;
		notifyObservers();
	}
}


interface Observer {
	public void update(float temparature, float humidity);
}


class RetinaDisplay implements Observer{
	Subject subject;
	public RetinaDisplay(Subject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}
	public void update(float temparature, float humidity) {
		display(temparature, humidity);
	}

	public void display(float temparature, float humidity) {
		System.out.println("RetinaDisplay : "+ temparature + " " +humidity);
	}
}


class LedDisplay implements Observer{
	Subject subject;
	public LedDisplay(Subject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}
	public void update(float temparature, float humidity) {
		display(temparature, humidity);
	}

	public void display(float temparature, float humidity) {
		System.out.println("LedDisplay : "+ temparature + " " +humidity);
	}
}