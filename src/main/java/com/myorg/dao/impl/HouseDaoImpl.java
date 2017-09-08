package com.myorg.dao;

import com.myorg.model.House;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class HouseDaoImpl extends HibernateDaoSupport{

    @Autowired
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    public List<House> findAll() {
        String hql = "from House";
        List<House> houses = (List<House>) getHibernateTemplate().find(hql);
        return houses;
    }
}
