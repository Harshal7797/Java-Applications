package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterService;

public class TwitterCLIRunner {
    private TwitterService service;

    public TwitterCLIRunner(TwitterService service) {
        this.service = service;
    }

    public void run(String[] args) {
    }
}
