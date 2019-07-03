package ca.jrvs.apps.twitter.dto.helper;

import oauth.signpost.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.net.URI;

public interface HttpHelper {

    HttpResponse httpPost(URI uri);

    HttpResponse httpPost(URI uri, StringEntity stringEntity);

    HttpResponse httpGet(URI uri);
}
