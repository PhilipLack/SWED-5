package model;

class CommunicationChannel {
    private String channelType;

    
    public CommunicationChannel(String channelType) {
        this.channelType = channelType;
    }

   
    public void deliverNotification(Notification notification) {
        System.out.println("Delivering notification via " + channelType);
        notification.deliverNotification();
    }


	
}