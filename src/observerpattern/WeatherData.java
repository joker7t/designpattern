package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	private Boolean isChanged = Boolean.FALSE;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		if(isChanged) {
			for (int i = 0; i < observers.size(); i++) {
				Observer observer = (Observer) observers.get(i);
				observer.update(temperature, humidity, pressure);
			}
			isChanged = Boolean.FALSE;
		}
	}

	public void measurementsChanged() {
		//Can trigger some condition here
		isChanged = Boolean.TRUE;
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	// other WeatherData methods here
}