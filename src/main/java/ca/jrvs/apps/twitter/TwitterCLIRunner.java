package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterService;


public class TwitterCLIRunner {
    private TwitterService service;

    public TwitterCLIRunner(TwitterService service) {
        this.service = service;
    }

    public void run(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("USAGE: TwitterCLI post|show|deleteTweet");
        }
        switch (args[0].toLowerCase()) {
            case "post":
                String[] tmp = args[2].split(":");
                service.postTweet(args[1], Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
                break;
            case "show":
                service.showTweet(args[1], args[2].split(","));
                break;
            case "delete":
                service.deleteTweets(args[1].split(","));
                break;
            default:
                System.out.println("USAGE TwitterCLI post|show|delete");
                break;
        }
    }
}
