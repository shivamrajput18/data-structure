package LinearandBinarySearch.LinearSearch;

public class SearchWord {

    public static String searchWord(String[] arr, String str) {

        int n = arr.length;
        boolean isFound = false;

        for (int i = 0; i < n; i++) {

            for (String ele : arr[i].split(" ")) {
                if (ele.equals(str)) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                return arr[i];
            }
        }
        
        return "Not found";
    }

    public static void main(String[] args) {
        String[] arr = { "The sun set behind the mountains, painting the sky in hues of orange and pink.",
                "She carefully placed the book back on the shelf, smiling at the memories it held.",
                "The aroma of freshly baked bread filled the kitchen, making everyone's mouth water.",
                "He glanced at his watch, realizing he was running late for the meeting.",
                "The children laughed and played in the park, their joy infectious to all around."
        };

        System.out.println(searchWord(arr, "carefully"));

    }

}
