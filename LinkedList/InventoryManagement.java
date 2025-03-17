// Problem Statement: Design an inventory management system using a singly linked list where each node stores information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
// Add an item at the beginning, end, or at a specific position.
// Remove an item based on Item ID.
// Update the quantity of an item by Item ID.
// Search for an item based on Item ID or Item Name.
// Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
// Sort the inventory based on Item Name or Price in ascending or descending order.

class Item{ 
    String itemName;
    int itemID;
    int quantity;
    double price;
    Item next;
    
    Item(String itemName, int itemID, int quantity, double price){
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

}

class Inventory{
    Item head;

    public void addItem(String itemName, int itemID, int quantity, double price){
        Item newItem = new Item(itemName, itemID, quantity, price);
        if(head == null){
            head = newItem;
        }else{
            Item temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    public void displayInventory(){
        Item temp = head;
        while(temp != null){
            System.out.println("Item Name: " + temp.itemName + " Item ID: " + temp.itemID + " Quantity: " + temp.quantity + " Price: " + temp.price);
            temp = temp.next;
        }
        System.out.println();
    }

    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price){
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemID, int quantity, double price){
        Item newitem = new Item(itemName, itemID, quantity, price);
        if(head==null){
            head = newitem;
        }else{
            Item temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newitem;
        }
    }

    public void removeItem(int itemID) {
        // Special case for head node
        if (head != null && head.itemID == itemID) {
            head = head.next;
            return;
        }
    
        Item temp = head;
    
        while (temp != null && temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
    
        // If we reached the end, the itemID was not found
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    
    public void updateQuantity(int itemID,int newQuantity){
        Item temp = head;

        while (temp!=null && temp.itemID != temp.itemID) {
            temp = temp.next;
        }

        if(temp!=null && temp.itemID == itemID ){
            temp.quantity = newQuantity;
        }
    }

    public void calculateTotalValue(){
        Item temp = head;
        double totalPrice = 0.0;

        while(temp!=null){
            totalPrice += temp.quantity * temp.price;
            temp= temp.next;
        }

        System.out.println("Total Price: " + totalPrice);

    }    

    
    public void Search(int itemID , String itemName){
        Item temp = head;
        while(temp!=null){
            if(temp.itemName.equals(itemName) || temp.itemID == itemID ){
                System.out.println("Item Name: " + temp.itemName + " Item ID: " + temp.itemID + " Quantity: " + temp.quantity + " Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }
     
    public void sortNameByAcesnding(){
        
        Item temp = head;
        while(temp!=null){
            Item temp2 = temp.next;
            while(temp2!=null){
                if(temp.itemName.compareTo(temp2.itemName)>0){
                    String tempName = temp.itemName;
                    int tempID = temp.itemID;
                    int tempQuantity = temp.quantity;
                    double tempPrice = temp.price;

                    temp.itemName = temp2.itemName;
                    temp.itemID = temp2.itemID;
                    temp.quantity = temp2.quantity;
                    temp.price = temp2.price;

                    temp2.itemName = tempName;
                    temp2.itemID = tempID;
                    temp2.quantity = tempQuantity;
                    temp2.price = tempPrice;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }
    public void sortPriceBy(String order){
        Item temp = head;
        while(temp!=null){
            Item temp2 = temp.next;
            while(temp2!=null){
                if(order.equals("asc")){
                    if(temp.price> temp2.price){
                        String tempName = temp.itemName;
                        int tempID = temp.itemID;
                        int tempQuantity = temp.quantity;
                        double tempPrice = temp.price;
    
                        temp.itemName = temp2.itemName;
                        temp.itemID = temp2.itemID;
                        temp.quantity = temp2.quantity;
                        temp.price = temp2.price;
    
                        temp2.itemName = tempName;
                        temp2.itemID = tempID;
                        temp2.quantity = tempQuantity;
                        temp2.price = tempPrice;
                    }
                    temp2 = temp2.next;
                }else{
                    if(temp.price< temp2.price){
                        String tempName = temp.itemName;
                        int tempID = temp.itemID;
                        int tempQuantity = temp.quantity;
                        double tempPrice = temp.price;
    
                        temp.itemName = temp2.itemName;
                        temp.itemID = temp2.itemID;
                        temp.quantity = temp2.quantity;
                        temp.price = temp2.price;
    
                        temp2.itemName = tempName;
                        temp2.itemID = tempID;
                        temp2.quantity = tempQuantity;
                        temp2.price = tempPrice;
                    }
                    temp2 = temp2.next;
                }
          
           
            }
            temp = temp.next;
        }
    }

}



public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inve = new Inventory();
        inve.addItem("egg", 101 , 2, 7);
        inve.addItem("banana", 102 , 12, 5);
   
        // inve.removeItem(102);
        // inve.updateQuantity(101,10);
        // inve.displayInventory();
        // inve.Search(1099, "banana");
        // inve.displayInventory();
        // inve.sortNameByAcesnding();
        inve.sortPriceBy("desc");
        inve.displayInventory();
        // inve.calculateTotalValue();
    }
    
}