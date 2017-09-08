package com.myorg.dao.impl;

import com.myorg.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class entityClass;

    private String entityClassName;

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    public BaseDaoImpl() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
        entityClassName = entityClass.getSimpleName();
    }

    public void insert(T entity) {

    }

    public void update(T entity) {

    }

    public void delete(T entity) {

    }

    public void deleteAll(Collection<T> entities) {

    }

    public T findOneById(Integer id) {
        return null;
    }

    public T findOneByName(String name) {
        return null;
    }

    public int countAll() {
        return 0;
    }

    public int conditionCount(Criterion criterion) {
        return 0;
    }

    public int countBySQL(String sql) {
        return 0;
    }

    public List<T> findAll() {
        return (List<T>) getHibernateTemplate().find("from " + entityClassName);
    }

    public List<T> findAllByHQL() {
        return null;
    }

    public List<T> conditionFindAll(Criterion criterion) {
        return null;
    }

    public List<T> findByPage(int pageNumber, int pageSize) {
        return null;
    }

    public List<T> conditionFindByPage(int pageNumber, int pageSize, Criterion criterion) {
        return null;
    }
}
