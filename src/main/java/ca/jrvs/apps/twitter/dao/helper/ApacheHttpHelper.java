package ca.jrvs.apps.twitter.dao.helper;


import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

@Component
public class ApacheHttpHelper implements HttpHelper {
    private static String CONSUMER_KEY = System.getenv("consumerKey");
    private static String CONSUMER_SECRET = System.getenv("consumerSecrect");
    private static String ACCESS_TOKEN = System.getenv("accessToken");
    private static String TOKEN_SECRET = System.getenv("tokenSecret");
    @Override
    public HttpResponse httpPost(URI uri) {
        OAuthConsumer consumer = helpOauth();
        HttpPost request;
        try {
            request = new HttpPost(uri);
            consumer.sign(request);
            HttpClient httpClient = new DefaultHttpClient();
            return httpClient.execute(request);
        } catch (IOException | OAuthException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity) {
        return null;
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        OAuthConsumer consumer = helpOauth();
        HttpGet request;
        try {
            request = new HttpGet(uri);
            consumer.sign(request);
            HttpClient httpClient = new DefaultHttpClient();
            return httpClient.execute(request);
        } catch (IOException | OAuthException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private OAuthConsumer helpOauth() {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        return consumer;

    }

}
