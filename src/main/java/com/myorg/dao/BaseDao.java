package com.myorg.dao;

import org.hibernate.criterion.Criterion;

import java.util.Collection;
import java.util.List;

public interface BaseDao<T> {

    public void insert(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteAll(Collection<T> entities);

    public T findOneById(Integer id);

    public T findOneByName(String name);

    public int countAll();

    public int conditionCount(Criterion criterion);

    public int countBySQL(String sql);

    public List<T> findAll();

    public List<T> findAllByHQL();

    public List<T> conditionFindAll(Criterion criterion);

    public List<T> findByPage(int pageNumber, int pageSize);

    public List<T> conditionFindByPage(int pageNumber, int pageSize, Criterion criterion);

}
