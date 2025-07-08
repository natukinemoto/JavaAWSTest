package com.example.demo.weather;

public class WeatherApiResponse {
    private Weather[] weather;
    private Main main;

    public Weather[] getWeather() { return weather; }
    public void setWeather(Weather[] weather) { this.weather = weather; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }

    public static class Weather {
        private String description;
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    public static class Main {
        private double temp;
        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
    }
}
