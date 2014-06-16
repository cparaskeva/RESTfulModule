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

/**
 * ProductCode generated by hbm2java
 */
@Entity
@Table(name="product_code"
    ,catalog="broker"
)
public class ProductCode  implements java.io.Serializable {


     private String prodCode;
     private char discountCode;
     private String description;
     private Set<Product> products = new HashSet<Product>(0);

    public ProductCode() {
    }

	
    public ProductCode(String prodCode, char discountCode) {
        this.prodCode = prodCode;
        this.discountCode = discountCode;
    }
    public ProductCode(String prodCode, char discountCode, String description, Set<Product> products) {
       this.prodCode = prodCode;
       this.discountCode = discountCode;
       this.description = description;
       this.products = products;
    }
   
     @Id 

    
    @Column(name="prod_code", unique=true, nullable=false, length=2)
    public String getProdCode() {
        return this.prodCode;
    }
    
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    
    @Column(name="discount_code", nullable=false, length=1)
    public char getDiscountCode() {
        return this.discountCode;
    }
    
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }

    
    @Column(name="description", length=10)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productCode")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}

