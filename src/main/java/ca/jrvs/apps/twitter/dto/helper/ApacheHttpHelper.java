package ca.jrvs.apps.twitter.dto.helper;


import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.Arrays;

public class ApacheHttpHelper implements HttpHelper {
    private static String CONSUMER_KEY = System.getenv("consumerKey");
    private static String CONSUMER_SECRET = System.getenv("consumerSecrect");
    private static String ACCESS_TOKEN = System.getenv("accessToken");
    private static String TOKEN_SECRET = System.getenv("tokenSecret");
    @Override
    public HttpResponse httpPost(URI uri) throws Exception {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        HttpPost request = new HttpPost(uri);
        consumer.sign(request);
        System.out.println("HTTP Request Headers: ");
        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);
        //send/execute the request
        HttpClient httpClient = new DefaultHttpClient();
        return httpClient.execute(request);
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity) {
        return null;
    }

    @Override
    public HttpResponse httpGet(URI uri) throws Exception {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        HttpGet request = new HttpGet(uri);
        consumer.sign(request);
        System.out.println("HTTP Request Headers: ");
        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);
        //send/execute the request
        HttpClient httpClient = new DefaultHttpClient();

        return httpClient.execute(request);
    }

    public static void main(String[] args) throws Exception {
        ApacheHttpHelper help = new ApacheHttpHelper();
        URI uri = new URI("https://api.twitter.com/1.1/users/search.json?q=realDonaldTrump");
        HttpResponse response = help.httpGet(uri);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
