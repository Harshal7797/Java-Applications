package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

import static ca.jrvs.apps.twitter.util.JsonUtil.toPrettyJson;


@Service
public class TwitterServiceImp implements TwitterService {

    private final static Double MAX_LAT = 90d;
    private final static Double MIN_LAT = -90d;
    private final static Double MAX_LON = 180d;
    private final static Double MIN_LON = -180d;
    private final static Integer MAX_TWEET_SIZE = 140;
    private CrdRepository dao;
    private static Predicate<String> validID = (x) -> x.matches("[0-9]+");

    @Autowired
    public TwitterServiceImp(CrdRepository dao) {
        this.dao = dao;
    }

    @Override
    public void postTweet(String text, Double latitude, Double longitude) {
        Tweet postTweet = generateBody(text, latitude, longitude);
        try {
            Tweet reposne = (Tweet) dao.create(postTweet);
        } catch (SyntaxException e) {
            throw new RuntimeException("Failed to post Tweet");
        }

    }

    protected Tweet generateBody(String text, Double latitude, Double longitude) {
        //validate tweet
        if (text.toCharArray().length > MAX_TWEET_SIZE || text.isEmpty()) {
            throw new IllegalArgumentException("Not a valid tweet");
        }
        if (latitude < MIN_LAT || latitude > MAX_LAT || longitude < MIN_LON || longitude > MAX_LON) {
            throw new IllegalArgumentException("Invalid Latitude or longitude");
        }
        Tweet tweet = new Tweet();
        Coordinates coordinates = new Coordinates();
        tweet.setText(text);
        coordinates.setCoordinates(Arrays.asList(latitude, longitude));
        tweet.setCoordinates(coordinates);
        return tweet;

    }

    @Override
    public void showTweet(String id, String[] fields) {
        if (!validID.test(id) || id.isEmpty()) {
            throw new RuntimeException("ID must be numeric");
        }
        try {
            Tweet tweet = (Tweet) dao.findById(id);
            System.out.println(toPrettyJson(tweet));
        } catch (IOException e) {
            throw new RuntimeException("Failed to display Tweet");
        }
    }


    @Override
    public void deleteTweets(String[] ids) {
        for (String s : ids) {
            if (!validID.test(s)) {
                throw new RuntimeException("ID must be numeric");
            }
            try {
                Tweet tweet = (Tweet) dao.deleteById(s);
                System.out.println("Deleted Tweet" + toPrettyJson(tweet));
            } catch (IOException e) {
                throw new RuntimeException("Failed to display Tweet");
            }
        }
    }

}
