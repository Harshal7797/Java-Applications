package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TwitterRestDaoUnitTest {
    private CrdRepository dao;
    private HttpHelper httpHelper;
    private Tweet expectedTweet;
    private String id;

    @Before
    public void setup() {
        //setup Tweet
        this.expectedTweet = new Tweet();
        this.expectedTweet.setText("This is the testing phase" + System.currentTimeMillis());
        //Setup DAO
        this.httpHelper = new ApacheHttpHelper();
        this.dao = new TwitterRestDao(httpHelper);
    }

    @After
    public void cleanup() {
        //remove tweet
        dao.deleteById(this.id);
    }

    @Test
    public void create() throws Exception {
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(50.0, 50.0));
        coordinates.setType("Point");
        this.expectedTweet.setCoordinates(coordinates);
        System.out.println(JsonUtil.toPrettyJson(expectedTweet));

        //call create method
        Tweet createTweet = (Tweet) dao.create(expectedTweet);
        System.out.println(JsonUtil.toPrettyJson(createTweet));

        //validate Tweet Object
        assertTweets(expectedTweet, createTweet);
        this.id = createTweet.getIdStr();

        //Show Tweet
        Tweet showTweet = (Tweet) dao.findById(this.id);
        assertTweets(expectedTweet, showTweet);

    }

    public void assertTweets(Tweet expec, Tweet actual) {
        assertNotNull(actual);
        assertNotNull(actual.getIdStr());
        assertEquals(expec.getText(), actual.getText());
        assertEquals(expec.getCoordinates(), actual.getCoordinates());

    }
}
