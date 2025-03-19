package LinearandBinarySearch.BinarySearch;

public class RotationPoint {

    public static int findRotatePoint(int[] arr){
        int n = arr.length;
        int left =0;
        int right =n-1;

        while(left<right){
            int mid = (left+right)/2;
            
            if(arr[mid] > arr[right]){
                left = mid +1;
            }else{
                right = mid;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};

        System.out.println(findRotatePoint(arr));

    }
}
