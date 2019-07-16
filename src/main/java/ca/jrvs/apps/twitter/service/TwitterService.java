package ca.jrvs.apps.twitter.service;

public interface TwitterService {

    /**
     * Post a Tweet along with a geo location
     * Print Tweet JSON which returned by the Twitter API
     *
     * @param text      tweet text
     * @param latitude  geo latitude
     * @param longitude geo longitude
     * @throws IllegalArgumentException if text exceed max number of allowed characters
     *                                  or lat/long out of range
     */
    void postTweet(String text, Double latitude, Double longitude);

    /**
     * Search a Tweet by id and print Tweet Object which returned by the Twitter API
     *
     * @param id tweet id
     * @param fields print Tweet fields from this param. Print all field if empty
     *
     * @throws IllegalArgumentException if id or fields param is invalid
     */

    void showTweet(String id, String[] fields);

    /**
     * Delete Tweet (s) by id(s)
     * Print Tweet object(s) which returned by Twitter API\
     *
     * @param ids tweet IDs which will be deleted
     *
     * @throws IllegalArgumentException if one of the IDs is valid
     */

    void deleteTweets(String[] ids);
}