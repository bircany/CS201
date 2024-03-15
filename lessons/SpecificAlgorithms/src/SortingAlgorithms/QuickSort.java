package SortingAlgorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {25,10,5,30,40,2,1,18,7};
        System.out.print("Unsorted Array : ");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.print("\nSorted Array : ");
        printArray(array);
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        int j = low;
        for (; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1); // Sol tarafı sıralama (recursive)
            quickSort(array, pivotIndex + 1, high); // Sağ tarafı sıralama (recursive)
        }
    }


}

