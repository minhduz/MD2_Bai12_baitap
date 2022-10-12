import java.util.*;


public class ProductManager {

    static List<Product> listProduct = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("_____________________MENU____________________");
            System.out.println("1. Thêm sản phẩm ");
            System.out.println("2. Sửa thông tin sản phẩm theo id ");
            System.out.println("3. Xoá sản phẩm theo id ");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá ");
            System.out.println("7. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.print("Nhập số sản phẩm muốn nhập: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    inputMultipleData(n,scanner);
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String keyEdit = scanner.nextLine();
                    editProduct(keyEdit,scanner);
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm muốn xóa: ");
                    String keyDelete = scanner.nextLine();
                    deleteProduct(keyDelete);
                    break;
                case 4:
                    displayData();
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm muốn tìm: ");
                    String name = scanner.nextLine();
                    searchProduct(name);
                    break;
                case 6:
                    System.out.println("1. Tăng dần theo giá");
                    System.out.println("2. Giảm dần theo giá");
                    int choiceSort = Integer.parseInt(scanner.nextLine());
                    switch (choiceSort){
                        case 1:
                            sortProductIncrease();
                            break;
                        case 2:
                            sortProductDecrease();
                            break;
                        default:
                            System.out.println("Mời chọn lại");
                    }
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Mời chọn lại");
            }
        }while (true);
    }

    public static void inputMultipleData(int n, Scanner scanner){
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData(scanner);
            listProduct.add(product);
        }
    }

    public static void editProduct(String key,Scanner scanner){
        boolean check = true;
        for (Product product: listProduct) {
            if(Objects.equals(key, product.getProductID())){
                System.out.print("Nhập lại tên sản phẩm: ");
                String name = scanner.nextLine();
                if(!Objects.equals(name, "") && name.length() != 0) product.setProductName(name);

                System.out.print("Nhập lại giá sản phẩm: ");
                String price = scanner.nextLine();
                if(!Objects.equals(price,"") && price.length() !=0) product.setProductPrice(Double.parseDouble(price));

                System.out.print("Nhập lại số lượng sản phẩm: ");
                String quantity = scanner.nextLine();
                if(!Objects.equals(quantity,"") && quantity.length() != 0) product.setProductQuantity(Integer.parseInt(quantity));

                System.out.println("Nhập lại trạng thái sản phẩm: ");
                String status = scanner.nextLine();
                if(!Objects.equals(status,"") && status.length() != 0) product.setProductStatus(Boolean.parseBoolean(status));

                check = true;
                break;
            } else check = false;
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm có mã là "+key);
        }
    }

    public static void deleteProduct(String key){
        boolean check = true;
        for (Product product: listProduct) {
            if(Objects.equals(key, product.getProductID())){
                listProduct.remove(product);
                System.out.println("Đã xóa sản phẩm có mà là "+key);

                check = true;
                break;
            } else check = false;
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm có mã là "+key);
        }
    }

    public static void displayData(){
        System.out.printf("%-10s%-20s%-10s%-10s%-10s\n","ID","Name","Price","Quantity","Status");
        for (Product product: listProduct) {
            product.displayData();
        }
    }

    public static void searchProduct(String name){
        boolean check = true;
        System.out.printf("%-10s%-20s%-10s%-10s%-10s\n","ID","Name","Price","Quantity","Status");
        for (Product product: listProduct) {
            if (Objects.equals(name, product.getProductName())) {
                product.displayData();

                check = true;
                break;
            } else check = false;
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm có tên là "+name);
        }
    }

    public static void sortProductIncrease(){
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getProductPrice(),o2.getProductPrice());
            }
        });
    }

    public static void sortProductDecrease(){
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getProductPrice(),o1.getProductPrice());
            }
        });
    }

}