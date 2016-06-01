package com.creative;

import com.creative.Impl.UserDAOImpl;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jisabw1 on 6/1/2016.
 */
@Path("/myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsers() {
        final ApplicationContext app = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDAOImpl userDao = (UserDAOImpl)app.getBean("UserDAOImpl");
        return userDao.findAllUsers().get(0);
    }
}
