
import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs; // List to store Friend IDs
    User next; // Pointer to the next user

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int userID) {
        if (!friendIDs.contains(userID)) {
            friendIDs.add(userID);
        }
    }

    public void removeFriend(int userID) {
        friendIDs.remove(Integer.valueOf(userID));
    }

}

class SocialNetwork {
    private User head;

    public void addUser(int userID, String name, int age) {
        User newuser = new User(userID, name, age);

        if (head == null) {
            head = newuser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newuser;
        }

    }

    private User findUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    public void addFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userID2);
            user2.addFriend(userID1);
            System.out.println(user1.name + "and " + user2.name + " are now friends");
        } else {
            System.out.println("one or both user are not found");
        }
    }
    
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userID2);
            user2.removeFriend(userID1);
            System.out.println( "connection remove successfully");
        } else {
            System.out.println("one or both user are not found");
        }
    }



    public void displayFriends(int userID) {
        User user = findUser(userID);

        if (user != null) {

            System.out.println(user.name + "'s Friends: " + user.friendIDs);

        } else {
            System.out.println("user is not found");

        }

    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);

            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found!");
        }
    }

    public void searchUser(String query) {
        User temp = head;
        boolean isFound = false;

        while (temp != null) {
            if (String.valueOf(temp.userID).equals(query) || temp.name.equalsIgnoreCase(query)) {
                System.out.println("User Found -> ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
                isFound = true;
            }
            temp = temp.next;
        }
        if (!isFound) {
            System.out.println("user is not found");
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friends.");
            temp = temp.next;
        }
    }

}

public class SocialMedia {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Adding users
        network.addUser(1, "Shivam", 23);
        network.addUser(2, "Rohan", 22);
        network.addUser(3, "Ashu", 28);
        network.addUser(4, "Aman", 30);

        // Adding friend connections
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(3, 4);

        // Display friends
        network.displayFriends(1);
        network.displayFriends(2);

        // // Finding mutual friends
        network.findMutualFriends(1, 3);
        network.findMutualFriends(2, 4);

        // // Searching for a user
        network.searchUser("rohit");
        network.searchUser("5");

        // // Removing a friend
        network.removeFriend(1, 2);
        network.displayFriends(1);

        // // Counting friends
        network.countFriends();
    }
}