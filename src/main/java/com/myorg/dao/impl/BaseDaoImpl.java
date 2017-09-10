package com.myorg.dao.impl;

import com.myorg.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

    public T findOneByName(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.like("name", ""));
        List<T> tList = (List<T>) getHibernateTemplate().findByCriteria(criteria);
        System.out.println(tList);
        if (tList.size() != 0) {
            return tList.get(0);
        }
        return null;
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
