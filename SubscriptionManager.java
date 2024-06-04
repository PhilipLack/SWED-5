package model;

class SubscriptionManager {
   
	 public void addSubscription(User user, Website website) {
	        user.registerForUpdates(website, "default");
	    }

	    public void cancelSubscription(User user, Website website) {
	        website.detachObserver(user);
	        System.out.println("Subscription cancelled for user: " + user.getUsername());
	    }
}
