package SearchAlgorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
        int target = 37; // sought number
        isIncluded(binarySearch(arr, target));
    }
    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target)
            return mid;

        else if (arr[mid] > target)
            return binarySearch(arr, target, low, mid - 1);

        else
            return binarySearch(arr, target, mid + 1, high);

    }
    public static void isIncluded(int result){
        if(result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index :  " + result);
    }

}
