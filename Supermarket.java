package com.mycompany.supermarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Supermarket extends Application {
@Override
    public void start(Stage stage) throws Exception {
        GridPane g = new GridPane();
        g.setAlignment(Pos.CENTER);
        g.setHgap(10);
        g.setVgap(10);
        g.setPadding(new Insets(30));

        Text welcomeMsg = new Text(" Welcome TO Supermarket System  ");
        welcomeMsg.setFont(Font.font(" ", FontWeight.EXTRA_BOLD, 16));
        g.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, null, null)));
        welcomeMsg.setFill(Color.BLUE);

        g.add(welcomeMsg, 0, 0, 2, 1);

        TextArea A = new TextArea();
        A.setEditable(false);

        g.add(A, 0, 1, 2, 1);

        Button B = new Button("Show the List");
        B.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ArrayList<Product> list = Supermarket.productList;
                String n = "";
                for (Product c : list) {
                    n += c + "\n";
                }
                A.setText(n);
            }
        });

        g.add(B, 0, 2);

        Scene s = new Scene(g, 400, 300);

        stage.setScene(s);
        stage.setTitle("Supermarket System");
        stage.show();
        stage.setResizable(false);
    }
    // طريقة لتعبئة الـ ArrayList من عناصر جاهزة
    public static void fillList(ArrayList<Product> productList) {
        productList.add(new Food(10, 1, "Apple", "Fresh fruit"));
        productList.add(new Drinks(20, 3, 2, "Coca Cola", "Cold drink"));
        productList.add(new Food(15, 3, "Sandwich", "Fast food"));
        productList.add(new Drinks(5, 1, 4, "Water", "Refreshing water"));
    }

    // طريقة لعرض محتويات الـ ArrayList مع الأرقام
    public static void displayList(ArrayList<Product> productList) {
        System.out.println("===== Product List =====");
        for (Product product : productList) {
            System.out.println(product.getId() + ". " + product.getName() + " - " + product.getDescripoint());
            System.out.println("Price: " + product.offer() + " SAR");

            // تطبيق البوليمورفيزم عبر النداء على الميثود abstract
            if (product instanceof Drinks) {
                Drinks drink = (Drinks) product;
                System.out.println("Can count: " + drink.getNumber_of_cans());
            }
        }
    }

    static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        fillList(productList);
        Customer customer = null;
        boolean running = true;
        do {
            try {
                menu();
                choice = scanner.nextInt();

                switch (choice) {

                
            
          case 1:
                    displayList(productList);
                    break;

                case 2:
                    // عرض قائمة المنتجات للمستخدم
                    displayList(productList);
                    System.out.print("Enter the product ID to add: ");
                    int productIdToAdd = scanner.nextInt();
                    Product productToAdd = null;

                    // التحقق من وجود المنتج في القائمة
                    for (Product product : productList) {
                        if (product.getId() == productIdToAdd) {
                            productToAdd = product;
                            break;
                        }
                    }

                    if (productToAdd != null) {
                        // إذا تم العثور على المنتج، يمكن إضافة المنتج إلى قائمة الطلبات أو إجراء أي عملية أخرى
                        System.out.println("Product added to the cart: " + productToAdd.getName());
                    } else {
                        System.out.println("Product with ID " + productIdToAdd + " not found.");
                    }
                    break;

                        
                case 3:
                    // عرض قائمة المنتجات للمستخدم
                    displayList(productList);
                    System.out.print("Enter the product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    
                    Product productToRemove = null;

                    // التحقق من وجود المنتج في القائمة
                    for (Product product : productList) {
                        if (product.getId() == productIdToRemove) {
                            productToRemove = product;
                            break;
                        }
                    }
                    if (productToRemove != null) {
                        productList.remove(productToRemove);
                        System.out.println("Product removed: " + productToRemove.getName());
                    } else {
                        System.out.println("Product with ID " + productIdToRemove + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Creating an Order...");

                    // طلب تفاصيل الموقع
                    scanner.nextLine(); // تفريغ السطر
                    System.out.println("Enter the city:");
                    String city = scanner.nextLine();
                    System.out.println("Enter the street:");
                    String street = scanner.nextLine();
                    System.out.println("Enter the house number:");
                    int houseNumber = scanner.nextInt();

                    // إنشاء الموقع والعميل
                    Location location = new Location(city, street, houseNumber);
                    
                    System.out.println("enter Customer name: ");
                    String name = scanner.next();
                    
                    System.out.println(" enter Customer phoneNum:");
                    String phoneNum = scanner.next();

                    customer = new Customer(name, phoneNum, location);
                    // قائمة المنتجات المختارة
                    ArrayList<Product> selectedProductList = new ArrayList<>();
                    boolean addingProducts = true;

                    // السماح للمستخدم باختيار المنتجات
                    while (addingProducts) {
                        displayList(productList); // عرض المنتجات
                        System.out.print("Enter the product ID to add to the order (or 0 to finish): ");
                        int selectedProductId = scanner.nextInt();

                        if (selectedProductId == 0) {
                            addingProducts = false; // إنهاء عملية الاختيار
                        } else {
                            Product selectedProduct = null;
                            for (Product product : productList) {
                                if (product.getId() == selectedProductId) {
                                    selectedProduct = product;
                                    break;
                                }
                            }

                            if (selectedProduct != null) {
                                selectedProductList.add(selectedProduct);
                                System.out.println("Product added to the order: " + selectedProduct.getName());
                            } else {
                                System.out.println("Product with ID " + selectedProductId + " not found.");
                            }
                        }
                    }

                    // طلب معلومات الدفع
                    System.out.println("Enter payment amount:");
                    double paymentAmount = scanner.nextDouble();
                    Payment payment = new Payment(paymentAmount);

                    // تحويل قائمة المنتجات المختارة إلى مصفوفة
                    Product[] selectedProducts = new Product[selectedProductList.size()];
                    selectedProductList.toArray(selectedProducts);

                    // إعداد السلة
                    Cart cart = new Cart();
                    cart.setCustomer(customer);
                    cart.setProducts(selectedProducts);
                    cart.setPayment(payment);

                    // إنشاء وطباعة الفاتورة
                    Invoice invoice = new Invoice(cart);
                    invoice.printinvoice();

                    System.out.println("Order created successfully!");
                    break;

                case 5:
                    launch(args);
                    //GUI
                    break;

                case 6:
                   
                     WriteTextFile r = new WriteTextFile();
                    r.openFile("prodect.txt");
                    if (productList.isEmpty()) {
                        System.out.println("No prodects yet."); 
                    } else {
                            for (Product elm : productList) {
                                r.WriteFile(elm);
                            }
                        }
                     r.CloseFile();
                        System.out.println("All prodects saved to the text file prodect.txt");
                    
                    break;

                case 7:
                  
                    ReadTextFile in = new ReadTextFile();
                    in.openFile("prodect.txt");
                    in.ReadFile();
                    in.CloseFile();
                    break;
                 case 8:
                    System.out.println("Thank you for using our system.\nHave a nice day.");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            }catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                scanner.nextLine();
            }
        }while (choice != 8);
    }

    public static void menu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Display Products");
        System.out.println("2. Add Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Create Order");
        System.out.println("5. show info in GUI");
        System.out.println("6. Save Order");
        System.out.println("7. Show info in File");
        System.out.println("8. Exit");
        
        System.out.print("Please choose an option: ");
    }
}
