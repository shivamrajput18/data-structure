import java.util.ArrayList;
import java.util.List;

class Node {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    Node next;
    Node prev;

    Node(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    Node head;

    public void addMovieAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addMovieAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void addMovieAtPosition(String movieTitle, String director, int yearOfRelease, double rating, int position) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (position <= 1 || head == null) {
            addMovieAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addMovieAtEnd(movieTitle, director, yearOfRelease, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    public void displayMovies() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Movie Title: " + temp.movieTitle + " | Director: " + temp.director + 
                               " | Year: " + temp.yearOfRelease + " | Rating: " + temp.rating);
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayReverse() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.println("Movie Title: " + temp.movieTitle + " | Director: " + temp.director + 
                               " | Year: " + temp.yearOfRelease + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void searchByDirectorOrRating(String directorName, double rating) {
        List<Node> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(directorName) || temp.rating == rating) {
                list.add(temp);
            }
            temp = temp.next;
        }

        if (list.isEmpty()) {
            System.out.println("No matching movies found.");
        } else {
            for (Node x : list) {
                System.out.println("Movie Title: " + x.movieTitle + " | Director: " + x.director + 
                                   " | Year: " + x.yearOfRelease + " | Rating: " + x.rating);
            }
        }
    }

    public void removeMovieByTitle(String movieTitle) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Node temp = head;

        // If head node is the movie to be deleted
        if (temp != null && temp.movieTitle.equals(movieTitle)) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            System.out.println("Movie removed: " + movieTitle);
            return;
        }

        while (temp != null && !temp.movieTitle.equals(movieTitle)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        System.out.println("Movie removed: " + movieTitle);
    }

    public void updateRating(String movieTitle, double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.movieTitle.equals(movieTitle)) {
                temp.rating = rating;
                System.out.println("Updated rating for " + movieTitle + " to " + rating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
}

public class MovieManager {
    public static void main(String[] args) {
        MovieManagement movieList = new MovieManagement();
        movieList.addMovieAtEnd("PK", "Rajkumar Hirani", 2016, 8.9);
        movieList.addMovieAtEnd("Black", "Sanjay Leela Bhansali", 2025, 6.0);
        movieList.addMovieAtPosition("Dark", "Unknown", 2019, 8.0, 1);
        
        System.out.println("Movies List:");
        movieList.displayMovies();

        System.out.println("Searching for movies directed by 'Unknown' or with rating 0:");
        movieList.searchByDirectorOrRating("Unknown", 0);

        System.out.println("Removing movie 'PK':");
        movieList.removeMovieByTitle("PK");
        
        System.out.println("Movies List after removal:");
        movieList.displayMovies();
        
        System.out.println("Updating rating of 'Black' to 7.5:");
        movieList.updateRating("Black", 7.5);
        movieList.displayMovies();
    }
}
