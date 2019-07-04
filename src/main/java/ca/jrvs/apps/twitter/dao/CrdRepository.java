package ca.jrvs.apps.twitter.dao;

public interface CrdRepository<T, ID> {
    T save(T entity);

    T fingById(ID id);

    T deleteById(ID id);
}
