package eu.ubitech.broker.hibernate.models;
// Generated Jun 16, 2014 4:29:36 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DiscountCode generated by hbm2java
 */
@Entity
@Table(name="discount_code"
    ,catalog="broker"
)@XmlRootElement

public class DiscountCode  implements java.io.Serializable {


     private char discountCode;
     private BigDecimal rate;
     private Set<Customer> customers = new HashSet<Customer>(0);

    public DiscountCode() {
    }

	
    public DiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    public DiscountCode(char discountCode, BigDecimal rate, Set<Customer> customers) {
       this.discountCode = discountCode;
       this.rate = rate;
       this.customers = customers;
    }
   
     @Id 

    
    @Column(name="discount_code", unique=true, nullable=false, length=1)
    public char getDiscountCode() {
        return this.discountCode;
    }
    
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }

    
    @Column(name="rate", precision=4)
    public BigDecimal getRate() {
        return this.rate;
    }
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="discountCode")
    public Set<Customer> getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }




}

