package LinearandBinarySearch.BinarySearch;

public class PeakElement {

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        while (start != end) {

            mid = start + (end - end) / 2;

            if (nums[mid] >= nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};

        System.out.println(findPeakElement(arr));
    }
}
