package com.creative.DAO;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * Created by jisabw1 on 6/1/2016.
 */
public abstract class UserDAO {

    private static UserDAO dao;

    public abstract List<String> findAllUsers();

    public static UserDAO getDAO() {
        if (dao == null) {
            ClassPathResource res = new ClassPathResource("/applicationContext.xml");
            XmlBeanFactory factory = new XmlBeanFactory(res);
            dao = (UserDAO)factory.getBean("UserDAOImpl");
        }
        return dao;
    }
}
