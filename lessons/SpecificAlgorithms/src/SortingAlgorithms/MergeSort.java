package SortingAlgorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {18, 26, 32, 6, 43, 15, 9, 1};
        System.out.println("Unsorted Array : ");
        printArray(array);
        mergeSort(array);
        System.out.println("\nSorted Array : ");
        printArray(array);
    }

    public static void merge(int[] left, int[] right, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;


        for (; i < left.length && j < right.length && k != array.length - 1; k++) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }
        while (i < left.length) { // left dizisinde kalan elemanları kopyalama
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) { // right dizisinde kalan elemanları kopyalama
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2)  // Tek Eleman veya Hiç Eleman Yoksa Sıralanamaz. Min 2 eleman lazım.
            return;

        int mid = array.length / 2; // Ortanca Eleman Bulunur.
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Diziyi sol ve sağ alt dizilere bölme
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left); // Sol alt diziyi sıralama (recursiv olarak üstteki işlemleri tekrar uygulama )
        mergeSort(right); // Sağ alt diziyi sıralama (recursiv olarak üstteki işlemleri tekrar uygulama )
        merge(left, right, array); // Sıralanmış alt dizileri birleştirme
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

