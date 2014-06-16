/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ubitech.broker.hibernate.dao.service;

import eu.ubitech.broker.hibernate.dao.HibernateUtil;
import eu.ubitech.broker.hibernate.models.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author promitheas
 */
@Stateless
@Path("/customer")
public class CustomerREST {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    @GET
    @Produces(MediaType.TEXT_HTML)
    //@Produces({"application/xml", "application/json"})
    public Response findAll() {

        List<Customer> customers;
        customers = session.createQuery("from Customer").list();
        String output = "";

        for (Customer customer : customers) {
            output += "<span>" + (customer.toString()) + "</span>";
            if (customers.get(customers.size() - 1) != customer) {
                output += "<br>";
            }
        }
        return Response.status(200).entity(output).build();

    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Customer entity) {

    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Customer entity) {

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response find(@PathParam("id") Integer id) {

         List<Object> customersList= session.createQuery(" from Customer where customer_id=" + id).list();
       String output;
         if (customersList.isEmpty())
             output ="<h3>No records found!</h3>";
         else
          output = ((Customer)customersList.get(0)).getAddressline1();
        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return null;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return null;
    }

}
