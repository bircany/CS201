package SortingAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 9, 6, 1, 3, 7};
        System.out.print("Unsorted Array : ");
        printArray(arr);
        selectionSort(arr);
        System.out.print("\nSorted Array : ");
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

