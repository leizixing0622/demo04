package com.myorg.dao.impl;

import com.myorg.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        getHibernateTemplate().save(entity);
    }

    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    public T findOneById(Integer id) {
        return (T) getHibernateTemplate().get(entityClassName, id);
    }

    public T findOneByName(final String name) {
        if(name == null || name.length() == 0) {
            return null;
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("from " + entityClassName + " where 1 = 1");
            buffer.append(" and name = :name");
            final String s = new String(buffer);
            return (T) getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Query query = session.createQuery(s);
                    query.setString("name", name);
                    if(query.list().size() == 0) {
                        return null;
                    }else {
                        return query.list().get(0);
                    }
                }
            });
        }
    }

    public int countAll() {
        List<Long> longs = (List<Long>) getHibernateTemplate().find("select count(*) from " + entityClassName);
        if (longs != null) {
            return longs.get(0).intValue();
        }
        return 0;
    }

    public int conditionCount(Criterion... criterions) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        for(int i = 0; i < criterions.length; i ++) {
            criteria.add(criterions[i]);
        }
        criteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
        if(list != null) {
            Long aLong = (Long)list.get(0);
            return aLong.intValue();
        }
        return 0;
    }

    public List<T> findAll() {
        return (List<T>) getHibernateTemplate().find("from " + entityClassName);
    }

    public List<T> conditionFindAll(Criterion... criterions) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        for(int i = 0; i < criterions.length; i ++) {
            criteria.add(criterions[i]);
        }
        return (List<T>) getHibernateTemplate().findByCriteria(criteria);
    }

    public List<T> findAllByHQL(final String hql, final Object... params) {
        List<T> ts = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                for(int i = 0; params != null && i < params.length; i ++){
                    query.setParameter(i, params[i]);
                }
                return query.list();
            }
        });
        return ts;
    }

    public List<T> findByPage(final int pageNumber, final int pageSize) {
        List<T> ts = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException {
                String hql = "from " + entityClassName;
                Query query = session.createQuery(hql);
                int firstIndex = (pageNumber - 1) * pageSize;
                query.setFirstResult(firstIndex);
                query.setMaxResults(pageSize);
                return query.getResultList();
            }
        });
        return ts;
    }

    public List<T> conditionFindByPage(int pageNumber, int pageSize, Criterion... criterions) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        for(int i = 0; i < criterions.length; i ++) {
            criteria.add(criterions[i]);
        }
        if(pageSize == 0 && pageNumber < 1) {
            return (List<T>) getHibernateTemplate().findByCriteria(criteria);
        }
        return (List<T>) getHibernateTemplate().findByCriteria(criteria, (pageNumber - 1) * pageSize, pageSize);
    }
}
