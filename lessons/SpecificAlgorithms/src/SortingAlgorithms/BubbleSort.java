package SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {5, 7, 2, 9, 6, 1, 3};
        System.out.print("Unsorted Array : ");
        printArray(arr);
        bubbleSort(arr);
        System.out.print("\nSorted Array : ");
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}







