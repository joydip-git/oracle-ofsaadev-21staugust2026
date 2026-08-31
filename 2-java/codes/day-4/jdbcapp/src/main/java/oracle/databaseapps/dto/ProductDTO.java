package oracle.databaseapps.dto;

import java.util.Date;

public class ProductDTO {
    private int productId;
    private String productName;
    private double productPrice;
    private String productCode;
    private String description;
    private Date releaseDate;
    private byte[] image;
    private double rating;
    private int categoryId;

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName,
                      double productPrice, String productCode,
                      String description, Date releaseDate,
                      byte[] image, double rating, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCode = productCode;
        this.description = description;
        this.releaseDate = releaseDate;
        this.image = image;
        this.rating = rating;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Name=" + productName
                + ", Price=" + productPrice
                + ", Code: " + productCode
                + ", Released On=" + (releaseDate == null ? "NA" : releaseDate.toString());
    }
}
