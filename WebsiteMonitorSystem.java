package model;

import java.util.List;

class WebsiteMonitorSystem {
    public void monitorWebsites(List<Website> websites, CommunicationChannel channel) {
        while (true) {
            for (Website website : websites) {
                website.checkForUpdates();
            }
            try {
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
