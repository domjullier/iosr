package dao;

import java.io.Serializable;

/**
 * Interface for generic Data Access Object
 * @param <T> object type
 * @param <PK> primary key type
 */
public interface GenericDao<T, PK extends Serializable>
{
    /**
     * Creates new instance of an object
     * @param newInstance instance to be created
     * @return instance created
     */
    T create(T newInstance);

    /**
     * Reads object
     * @param id primary key of object to be read
     * @return instance read
     */
    T read(PK id);

    /**
     * Updates object
     * @param transientObject updated version of an object to be updated
     * @return updated object
     */
    T update(T transientObject);

    /**
     * Deletes object
     * @param persistentObject object to be deleted
     */
    void delete(T persistentObject);
}