import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private Boolean productStatus;

    public Product() {
    }

    public Product(String productID, String productName, double productPrice, int productQuantity, Boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner){
        System.out.print("Nhập mã sản phẩm: ");
        this.productID = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.productPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng sản phẩm: ");
        this.productQuantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập trạng thái sản phẩm: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.printf("%-10s%-20s%-10f%-10d%-10b\n",this.productID,this.productName,this.productPrice,this.productQuantity,this.productStatus);
    }


}
