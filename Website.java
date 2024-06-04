package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Website implements Subject {
    private String url;
    private List<Observer> observers = new ArrayList<>();
    private String lastContent = "";

    
    public Website(String url) {
        this.url = url;
    }

    @Override
    public void attachObserver(Observer observer, String subscriptionPreferences) {
        observers.add(observer);
        System.out.println("Observer attached with preferences: " + subscriptionPreferences);
    }

    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(url);
        }
    }

    public void checkForUpdates() {
        try {
            String currentContent = getWebsiteContent();
            if (!currentContent.equals(lastContent)) {
                lastContent = currentContent;
                notifyObservers();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getWebsiteContent() throws Exception {
        URL websiteURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) websiteURL.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}