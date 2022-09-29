package dto;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -4274700572038677000L;

	private String productId;
	private String pname;
	private Integer unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;
	private String filename;
	private int quantity;

	public Product() {
		super();
	}

	public Product(String productId, String pname, Integer unitPrice) {
		this.productId = productId;
		this.pname = pname;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {return productId;}
	public String getPname() {return pname;}
	public Integer getUnitPrice() {return unitPrice;}
	public String getDescription() {return description;}
	public String getManufacturer() {return manufacturer;}
	public String getCategory() {return category;}
	public long getUnitsInStock() {return unitsInStock;}
	public String getCondition() {return condition;}
	public String getFilename() {return filename;}
	public int getQuantity() {return quantity;}
	
	public void setPname(String pname) {this.pname = pname;}
	public void setProductId(String productId) {this.productId = productId;}
	public void setUnitPrice(Integer unitPrice) {this.unitPrice = unitPrice;}
	public void setDescription(String description) {this.description = description;}
	public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
	public void setCategory(String category) {this.category = category;}
	public void setUnitsInStock(long unitsInStock) {this.unitsInStock = unitsInStock;}
	public void setCondition(String condition) {this.condition = condition;}
	public void setFilename(String filename) {this.filename = filename;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
}
