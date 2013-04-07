package dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable>
{

    T create(T newInstance);

    T read(PK id);

    T update(T transientObject);

    void delete(T persistentObject);
}