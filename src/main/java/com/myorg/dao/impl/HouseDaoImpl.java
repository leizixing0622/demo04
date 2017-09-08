package com.myorg.dao.impl;

import com.myorg.model.House;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class HouseDaoImpl extends BaseDaoImpl<House> {

}
