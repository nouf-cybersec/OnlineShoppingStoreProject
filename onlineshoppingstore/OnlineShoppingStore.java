package onlineshoppingstore;

import java.io.*;
import java.util.*;

public class OnlineShoppingStore {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Clothes clothes = new Clothes();
        MakeUp makeup = new MakeUp();
        String name, userID, itemID, itemName, color, department, size, brand, category, season;
        int choice, selection, quantity;
        double price;
        System.out.println("Enter user name:");
        name = input.next();
        System.out.println("Enter user ID");
        userID = input.next();
        makeup.showItem();
        clothes.showItem();
        if (name.equals("Nuha") & userID.equals("1234")) {
            System.out.println("^^^^^^^Welcome to the Admin View^^^^^^^");
            do {
        System.out.println("pleas choose from the following tasks:");
            System.out.println("1-Add a clothe item");
            System.out.println("2-Delete a clothe item");
            System.out.println("3-Add a makeup item");
            System.out.println("4-Delete a makeup item");
            System.out.println("5-Exit the menu");
            System.out.println("6-Exit the application");
            System.out.println("Enter your choice:");
        choice=input.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter itemID, itemName, color, department,size, price to be added:");
                itemID = input.next();
                itemName = input.next();
                color = input.next();
                department = input.next();
                size = input.next();
                price = input.nextDouble();
                clothes.setItemID(itemID);
                clothes.setItemName(itemName);
                clothes.setColor(color);
                clothes.seteDpartment(department);
                clothes.setSize(size);
                clothes.setPrice(price);
                clothes.writeItem();
                break;
            case 2:
                System.out.println("Enter a clothe ID to be deleted:");
                itemID=input.next();
                clothes.deleteItem(itemID);
                break;
            case 3:
                System.out.println("Enter a itemId, itemName, brand, category,price season to be added:");
                itemID = input.next();
                itemName = input.next();
                brand=input.next();
                category=input.next();
                season=input.next();
                price = input.nextDouble();
                makeup.setItemID(itemID);
                makeup.setItemName(itemName);
                makeup.setBrand(brand);
                makeup.setCategory(category);
                makeup.setSeason(season);
                makeup.setPrice(price);                
                makeup.writeItem();
                break;
            case 4:
                System.out.println("Enter a makeup ID to be deleted:");
                itemID=input.next();
                makeup.deleteItem(itemID);
                break;
            case 5:
               choice=5;
                System.out.println("you exit the menu");
                break;
            case 6:
                System.out.println("you exit the application");
                System.exit(0);
            default:
                System.out.println("invaild choice");}
          }while(choice!=5);
        }else if(name.equals("Samar")&userID.equals("5678")){
            System.out.println("----------welcome to the costomer view----------");
        do{
            System.out.println("1-Buy clothes");
            System.out.println("2-Buy makeup");
            System.out.println("3-Exit the menu");
            System.out.println("4-Exit the application");
            System.out.println("Enter your selection:");
        selection=input.nextInt();
        switch(selection){
            case 1:
                System.out.println("please Enter the following information to buy clothes:");
                System.out.println("Enter an Item ID:");
                itemID=input.next();
                if(clothes.searchItem(itemID)){
                clothes.setItemID(itemID);
                System.out.println("Enter an item Quantity:");
                quantity=input.nextInt();
                clothes.orderSummary(quantity);
                }else
                    System.out.println("item does not exist");
                break;
            case 2:
                System.out.println("please Enter the following information to buy makeup:");
                System.out.println("Enter an Item ID:");
                itemID=input.next();
                if(makeup.searchItem(itemID)){
                makeup.setItemID(itemID);
                System.out.println("Enter an item Quantity:");
                quantity=input.nextInt(); 
                makeup.orderSummary(quantity);
                }else
                System.out.println("item does not exist");
            case 3:
                selection=3;
                System.out.println("you exit the menu");
            case 4:
                System.out.println("you exit the application");
                System.exit(0);
                break;
            default:
               System.out.println("invaild choice");
    }}while(selection!=3); 
    }else{System.out.println("wrong username or userID");}  input.close();
}  }

class User{
private String userId, username, password, email, userTybe;
public User(){}
 public String getUserId(){return userId;}
 public void setUserId(String userId){this.userId=userId;}
 public String getUsername(){return username;}
 public void setUsername(String username){this.username=username;}
 public String getPassword(){return password;}
 public void setPassword(String password){this.password=password;}
 public String getEmail(){return email;}
 public void setEmail(String email){this.email=email;}
 public String getUserTybe(){return userTybe;}
 public void setUserTybe(String userTybe){this.userTybe=userTybe;} }// end the user class

abstract class Item{
protected String itemId, itemName;
protected double price; 
protected Item(){}
public String getItemID() {return itemId;}
public void setItemID(String itemID) {this.itemId = itemID;}
public String getItemName() {return itemName;}
public void setItemName(String itemName) {this.itemName = itemName;}
public double getPrice() {return price;}
public void setPrice(double price) {this.price = price;}
protected abstract void orderSummary(int quantity)throws IOException;
protected abstract void showItem()throws IOException;
protected abstract boolean searchItem(String itemId)throws IOException;
protected abstract void writeItem()throws IOException;
protected abstract void deleteItem(String ItemId)throws IOException;} //end the item class

class Clothes extends Item{
private String color, department, size;
public Clothes(){}
public String getColor(){return color;}
public void setColor(String color){this.color=color;}
public String getDepartment(){return department;}
public void seteDpartment(String department){this.department=department;}
public String getSize(){return size;}
public void setSize(String size){this.size=size;}

//Method That show the purchase summer to the customer
@Override
public void orderSummary(int quantity){
    try{
   File clothesFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication56\\clothesFile.txt");
   Scanner input = new Scanner(clothesFile);
   double itemPrice=0;
   while(input.hasNext()){
   String line=input.nextLine();
   String[] array = line.split(",");
   if(array[0].equals(itemId)){
   itemPrice=Double.parseDouble(array[5]);
   break;} }
   input.close();
   double totalPrice = itemPrice*quantity;
     System.out.println("purchased item:"+itemId+", QTY="+quantity+", total price="+totalPrice);}
   catch (IOException e){
     System.out.println(e);}
     System.out.println("***************thank you for shopping***************");}

//Method that reads all the contents of the fileand display it on the console
@Override
public void showItem(){
try{
File clothesFile=new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication56\\clothesFile.txt");
Scanner input =new Scanner(clothesFile);
     System.out.println("Clothes File");
while (input.hasNext()) {
String line=input.nextLine();
     System.out.println(line);}
input.close();}
catch(IOException e){
     System.out.println(e);}
     System.out.println("*******************************************");}
//Method that add an item to the file
@Override
public void writeItem(){
 try {
        if (searchItem(itemId)) {
            System.out.println("Item already exists");
        } else {
            File clothesFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication56\\clothesFile.txt");
            PrintWriter output = new PrintWriter(new FileWriter(clothesFile, true));
            String newItem = itemId + "," + itemName + "," + color + "," + department + "," + size + "," + price;
            output.println(newItem);
            output.close();
            System.out.println("Item was added successfully!");}
    } catch (IOException e) {
        System.out.println(e);}}
//Method that search for an item and delete it from the file if it was found.
@Override
public void deleteItem(String itemId) throws IOException{
if (searchItem(itemId)) {
File clothesFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication56\\clothesFile.txt"); 
ArrayList<String> clothes = new ArrayList<>(); 
Scanner input = new Scanner(clothesFile);
while (input.hasNext()) {
String line = input.nextLine();
clothes.add(line); }
input.close();
ArrayList<String> newClothes = new ArrayList<>();
for (String line : clothes) {
String id = line.split(",")[0]; if (!id.equals(itemId)) {
 newClothes.add(line); }
}
PrintWriter output = new PrintWriter(clothesFile); 
for (int i = 0; i <  newClothes .size(); i++) {
output.println(newClothes.get(i)); }
output.close();
System.out.println("Item was deleted successfully!");
} else {
System.out.println("The item does not exist");}}
//Method that returns a boolean value indicating if it exists.
@Override
public  boolean searchItem(String itemId) throws IOException {    
File clothesFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication56\\clothesFile.txt"); 
Scanner input = new Scanner(clothesFile);
while (input.hasNext()) {
String line = input.nextLine();
if (line.split(",")[0].equals(itemId)) {
input.close();
return true; }}     
input.close();
return false;}}
 
class MakeUp extends Item{
private String brand,category, season;
MakeUp(){}
public MakeUp(String itemId, String itemName, double price, String brand, String category, String season){
this.itemId=itemId;
this.itemName=itemName;
this.price=price;
this.brand=brand;
this.category=category;
this.season=season;}
public String getBrand(){return brand;}
public void setBrand(String brand){this.brand=brand;}
public String getCategory(){return category;}
public void setCategory(String category){this.category=category;}
public String getSeason(){return season;}
public void setSeason(String season){this.season=season;}

//Method That show the purchase summer to the customer
@Override
public void orderSummary(int quantity)throws IOException{
    try{
   File makeupFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication51\\MakeupFile.txt");
   Scanner input = new Scanner(makeupFile);
   double itemPrice=0;
   while(input.hasNext()){
   String line=input.nextLine();
   String[] array = line.split(",");
   if(array[0].equals(itemId)){
   itemPrice=Double.parseDouble(array[5]);
   break;} }
   input.close();
   double totalPrice = itemPrice*quantity;
     System.out.println("purchased item:"+itemId+", QTY="+quantity+", total price="+totalPrice);}
   catch (IOException e){
     System.out.println(e);}
     System.out.println("***************thank you for shopping***************");}

//Method that reads all the contents of the fileand display it on the console
@Override
public void showItem() {
 try{   
File makeupFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication51\\MakeupFile.txt"); 
Scanner input = new Scanner(makeupFile);
System.out.println("Makeup File:");
while (input.hasNext()) {
String line = input.nextLine();
System.out.println(line); }
input.close();}
 catch (IOException e) {
        System.out.println(e);}
System.out.println("**************************************************");}

//Method that returns a boolean value indicating if it exists.
@Override
public  boolean searchItem(String itemID) throws IOException {    
File makeupFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication51\\MakeupFile.txt"); 
Scanner input = new Scanner(makeupFile);
while (input.hasNext()) {
String line = input.nextLine();
if (line.split(",")[0].equals(itemID)) {
input.close();
return true; } }     
input.close();
return false;}
//Method that add an item to the file
@Override
public void writeItem(){
 try {
        if (searchItem(itemId)) {
            System.out.println("Item already exists");
        } else {
            File makeupFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication51\\MakeupFile.txt");
            PrintWriter output = new PrintWriter(new FileWriter(makeupFile, true));
            String newItem = itemId + "," + itemName + "," + brand + "," + category + "," + season + "," + price;
            output.println(newItem);
            output.close();
            System.out.println("Item was added successfully!");}
    } catch (IOException e) {
        System.out.println(e);
        e.printStackTrace();}}
//Method that search for an item and delete it from the file if it was found.
@Override
public void deleteItem(String itemId) throws IOException{
if (searchItem(itemId)) {
File clothesFile = new File("C:\\Users\\nouf alsuhaimi\\Documents\\JavaApplication51\\MakeupFile.txt"); 
ArrayList<String> makeup = new ArrayList<>(); 
Scanner input = new Scanner(clothesFile);
while (input.hasNext()) {
String line = input.nextLine();
makeup.add(line); }
input.close();
ArrayList<String> newMakeup = new ArrayList<>();
for (String line : makeup) {
String id = line.split(",")[0]; if (!id.equals(itemId)) {
 newMakeup.add(line); }}
PrintWriter output = new PrintWriter(clothesFile); 
for (int i = 0; i <  newMakeup .size(); i++) {
output.println(newMakeup.get(i)); }
output.close();
System.out.println("Item was deleted successfully!");
} else {
System.out.println("The item does not exist");}}}
 