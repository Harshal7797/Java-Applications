package ca.jrvs.apps.twitter.dto.helper;

import oauth.signpost.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.net.URI;

public class ApacheHttpHelper implements HttpHelper {

    @Override
    public HttpResponse httpPost(URI uri) {
        return null;
    }

    @Override
    public HttpResponse httpPost(URI uri, StringEntity stringEntity) {
        return null;
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        return null;
    }
}
