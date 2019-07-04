package ca.jrvs.apps.twitter.dao;

import java.net.URISyntaxException;

public interface CrdRepository<T, ID> {
    T create(T entity);

    T fingById(ID id) throws URISyntaxException, Exception;

    T deleteById(ID id);
}
