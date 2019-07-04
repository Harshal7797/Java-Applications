package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dto.Tweet;

public class TwitterRestDao implements CrdRepository<Tweet, String> {
    @Override
    public Tweet save(Tweet entity) {
        return null;
    }

    @Override
    public Tweet fingById(String s) {
        return null;
    }

    @Override
    public Tweet deleteById(String s) {
        return null;
    }
}