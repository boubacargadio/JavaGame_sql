package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence;

import java.util.List;

public interface DAO<T extends DTO<ID>, ID> {

    T findById(ID id);

    List<T> findAll();

    T create(T dto);

    T update(T dto);

    boolean remove(T dto);

    boolean removeById(ID id);
}
