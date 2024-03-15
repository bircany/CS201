package SearchAlgorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 6, 12, 8, 5, 15, 25, 34};
        int target = 15; // sought number
        isIncluded(linearSearch(arr, target));

    }
    public static void isIncluded(int result){
        if(result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);
    }
    public static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
                return i;
        }
        return -1;
    }
}
