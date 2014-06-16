/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ubitech.broker.hibernate.dao.service;

import eu.ubitech.broker.hibernate.dao.HibernateUtil;
import eu.ubitech.broker.hibernate.models.DiscountCode;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author promitheas
 */
@Path("/hello")
public class demo {
    
    @GET
    public Response getCode() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List discountCode = null;
        try {
            transaction = session.beginTransaction();
            discountCode = session.createQuery("from DiscountCode").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        DiscountCode discount = new DiscountCode();
        
        discount = (DiscountCode) discountCode.get(0);
        
        String output = "Jersey say : " + discount.getDiscountCode();

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

}
