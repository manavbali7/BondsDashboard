package bondsDashboard.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity // This tells Hibernate to make a table out of this class

public class Bond {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  
	  private String issuer;

	  private String state;
	  
	  private BigDecimal coupon;
	  
	  private BigDecimal yield;
	  
	  private String moody;

	  private String maturity;
	  
	  private BigDecimal price;
	
	  private boolean sold;
	  
	  private String purchased;
	  
	  public Integer getId() {
	    return id;
	  }
	  public void setId(Integer id) {
	    this.id = id;
	  }

	  public String getIssuer() {
	    return issuer;
	  }
	  public void setIssuer(String issuer) {
	    this.issuer = issuer;
	  }

	  public String getState() {
	    return state;
	  }
	  public void setState(String state) {
	    this.state = state;
	  }
	  
	  public BigDecimal getCoupon() {
		return coupon;
	  }
	  public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	  }
	  
	  public BigDecimal getYield() {
		return yield;
	  }
	  public void setYield(BigDecimal yield) {
	    this.yield = yield;
	  }	  

	  public String getMoody() {
	    return moody;
	  }
	  public void setMoody(String moody) {
	    this.moody = moody;
	  }
	  
	  public String getMaturity() {
	    return maturity;
	  }
	  public void setMaturity(String maturity) {
	    this.maturity = maturity;
	  }
	  
	  public BigDecimal getPrice() {
		return price;
	  }
	  public void setPrice(BigDecimal price) {
		this.price = price;
	  }
	  
	  public boolean getSold() {
		return sold;
	  }
	  public void setSold(boolean sold) {
		this.sold = sold;
	  }
	  
	  public String getPurchased() {
	    return purchased;
	  }
	  public void setPurchased(String purchased) {
	    this.purchased = purchased;
	  }
}
