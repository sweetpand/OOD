import java.util.*;

public class WeatherData implements Subject {
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
	}
	public void notifyObservers() { //notifyObervers
		for(int i = 0; i < observers.size(); i++) {
			Observer ob = (Observer) observers.get(i);
			ob.update(temperature, humidity, pressure);
		}
	}
	public void measurementsChanged() {
		notifyObservers();
	}
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	public float getTempreture() {
		return temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public float getPressure() {
		return pressure;
	}

}
