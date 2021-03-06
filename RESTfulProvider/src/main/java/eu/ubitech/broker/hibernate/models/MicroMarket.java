package eu.ubitech.broker.hibernate.models;
// Generated Jun 16, 2014 4:29:36 PM by Hibernate Tools 3.6.0


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
 * MicroMarket generated by hbm2java
 */
@Entity
@Table(name="micro_market"
    ,catalog="broker"
)@XmlRootElement

public class MicroMarket  implements java.io.Serializable {


     private String zipCode;
     private Double radius;
     private Double areaLength;
     private Double areaWidth;
     private Set<Customer> customers = new HashSet<Customer>(0);

    public MicroMarket() {
    }

	
    public MicroMarket(String zipCode) {
        this.zipCode = zipCode;
    }
    public MicroMarket(String zipCode, Double radius, Double areaLength, Double areaWidth, Set<Customer> customers) {
       this.zipCode = zipCode;
       this.radius = radius;
       this.areaLength = areaLength;
       this.areaWidth = areaWidth;
       this.customers = customers;
    }
   
     @Id 

    
    @Column(name="zip_code", unique=true, nullable=false, length=10)
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
    @Column(name="radius", precision=22, scale=0)
    public Double getRadius() {
        return this.radius;
    }
    
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    
    @Column(name="area_length", precision=22, scale=0)
    public Double getAreaLength() {
        return this.areaLength;
    }
    
    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    
    @Column(name="area_width", precision=22, scale=0)
    public Double getAreaWidth() {
        return this.areaWidth;
    }
    
    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="microMarket")
    public Set<Customer> getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }




}


