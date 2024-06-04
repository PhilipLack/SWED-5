package model;

class User implements Observer{
	 private int userID;
	    private String username;

	    
	    public User(int userID, String username) {
	        this.userID = userID;
	        this.setUsername(username);
	    }

	   
	    public void registerForUpdates(Website website, String subscriptionPreferences) {
	        website.attachObserver(this, subscriptionPreferences);
	    }

	    
	    public void manageSubscriptions(SubscriptionManager manager, String action, Website website) {
	        if (action.equals("add")) {
	            manager.addSubscription(this, website);
	        } else if (action.equals("cancel")) {
	            manager.cancelSubscription(this, website);
	        }
	    }

	    @Override
	    public void update(String url) {
	        System.out.println(getUsername() + " received an update from " + url);
	    }


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}
}