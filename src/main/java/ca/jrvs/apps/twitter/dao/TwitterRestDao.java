package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class TwitterRestDao implements CrdRepository<Tweet, String> {
    //URI constsnt
    private static final String API_BASE_URI = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";
    //URI symbol
    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";
    //Response Code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;

    @Autowired
    public TwitterRestDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Tweet create(Tweet tweet) {
        //Construct URI
        URI uri;
        try {
            uri = getPostUri(tweet);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Invalid tweet input", e);
        }

        //Execute HTTP Request
        HttpResponse response = httpHelper.httpPost(uri);

        //Validate response and deser response to Tweet object
        return parseResponseBody(response, HTTP_OK);

    }

    @Override
    public Tweet findById(String id) {
        //Construct URI
        URI uri;
        try {
            uri = getshowUri(id);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to Construct URI", e);
        }
        //Execute HTTP Request
        HttpResponse response = httpHelper.httpGet(uri);
        return parseResponseBody(response, HTTP_OK);

    }


    @Override
    public Tweet deleteById(String id) {
        //Construct URI
        URI uri;
        try {
            uri = getDeleteUri(id);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to construct URI", e);
        }

        //Execute HTTP Request
        HttpResponse response;
        response = httpHelper.httpPost(uri);

        //Validate response and deser response to Tweet object
        return parseResponseBody(response, HTTP_OK);
    }

    protected URI getDeleteUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(DELETE_PATH)
                .append("/")
                .append(id)
                .append(".json");

        return new URI(sb.toString());
    }


    protected URI getshowUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(SHOW_PATH)
                .append(QUERY_SYM);
        appendQueryParam(sb, "id", id, true);
        return new URI(sb.toString());
    }

    protected URI getPostUri(Tweet tweet)
            throws URISyntaxException, UnsupportedEncodingException {
        String text = tweet.getText();
        Double longitude = tweet.getCoordinates().getCoordinates().get(0);
        Double latitude = tweet.getCoordinates().getCoordinates().get(1);

        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(POST_PATH)
                .append(QUERY_SYM);

        appendQueryParam(sb, "status", URLEncoder.encode(text, StandardCharsets.UTF_8.name()), true);
        appendQueryParam(sb, "long", longitude.toString(), false);
        appendQueryParam(sb, "lat", latitude.toString(), false);

        return new URI(sb.toString());
    }


    private void appendQueryParam(StringBuilder sb, String key, String value, boolean firstParam) {
        if (!firstParam) {
            sb.append(AMPERSAND);
        }
        sb.append(key)
                .append(EQUAL)
                .append(value);
    }

    //Check Response Status Coe and convert Response Entity to Tweet object
    protected Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
        Tweet tweet = null;

        //check Response status
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode) {
            throw new RuntimeException("Unexpected HTTP Status:" + status);
        }
        if (response.getEntity() == null) {
            throw new RuntimeException("Empty response body");
        }

        //Convert Response Entity to Str
        String jsonStr;
        try {
            jsonStr = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert entity to string ", e);
        }
        //Deserialize JSON String to Tweet Object
        try {
            tweet = (Tweet) JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
        } catch (IOException e) {
            throw new RuntimeException("Ubale to convert JSON str to Object", e);
        }
        return tweet;
    }
}