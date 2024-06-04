package model;

class Notification {
    private String message;
    private String channelType;

   
    public Notification(String message, String channelType) {
        this.message = message;
        this.channelType = channelType;
    }

   
    public void deliverNotification() {
        System.out.println("Delivering notification: " + message + " via " + channelType);
    }
}

