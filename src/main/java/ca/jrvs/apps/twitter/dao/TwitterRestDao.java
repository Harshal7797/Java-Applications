package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.dto.helper.ApacheHttpHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TwitterRestDao implements CrdRepository<Tweet, String> {
    @Override
    public Tweet create(Tweet entity) {
        return null;
    }

    @Override
    public Tweet fingById(String s) throws Exception {
        try {
            ApacheHttpHelper help = new ApacheHttpHelper();
            URI uri = new URI(s);
            HttpResponse response = help.httpGet(uri);
            String tmp = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            Tweet cp = mapper.readValue(tmp, Tweet.class);

            return cp;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Tweet deleteById(String s) {
        return null;
    }
}