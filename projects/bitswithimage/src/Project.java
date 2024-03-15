
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        System.out.println("Algorithms and Programming Final Homework");
        Scanner kb = new Scanner(System.in);

        boolean flag = false;
        do {
            System.out.println("ANA MENÜ:\n-----------------------------");
            System.out.println("""
            SORU 1 icin 1'e basın
            SORU 2 icin 2'e basın
            SORU 3 icin 3'e basın
            SORU 4 icin 4'e basın
            Çıkış için  0'a basın.""");

            System.out.print("Seçiminizi yapın: ");
            int choice = kb.nextInt();

            switch (choice) {
                case 1:
                    print2DArray(readFile());
                    break;
                case 2:
                    printCounter();
                    break;
                case 3:
                    colorConsole();
                    break;
                case 4:
                    toBinary();
                    break;
                case 0:
                    System.out.println("ÇIKIŞ Yapılıyor...");
                    flag = true;
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız.");
                    break;
            }

            if (!flag)
                flag = subMenu();

        } while (!flag);
    }

    public static boolean subMenu() {
        Scanner kb = new Scanner(System.in);
        boolean flag = false;

        while (true) {
            System.out.print("Seçiminizi yapın: ");
            int choice = kb.nextInt();

            if (choice == 5)
                break;

            else if (choice == 0) {
                System.out.println("ÇIKIŞ Yapılıyor...");
                flag = true;
                break;
            }
            else
                System.out.println("Lütfen geçerli bir işlem yapınız.");
        }
        return flag;
    }

    public static int[][] readFile() {
        String path = "bilgi.txt";
        int[][] numbers = new int[64][32];

        int row = 0;
        try {
            Scanner kb = new Scanner(new File(path));
            while (kb.hasNextLine()) {
                String line = kb.nextLine();
                String[] StringNumber = line.trim().split("\t");
                for (int col = 0; col < StringNumber.length; col++) {
                    numbers[row][col] = Integer.parseInt(StringNumber[col]);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("Bir Hata Oluştu.");
            e.printStackTrace();
        }
        return numbers;
    }

    public static void print2DArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Soru 1 Cevaplandı , Üst Menü için 5 , Çıkış için 0'a basın.");
    }

    public static void colorConsole() {
        int[][] arr = readFile();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    System.out.print("\u001B[44m" + arr[i][j] + "\t");
                } else if (arr[i][j] <= 0) {
                    System.out.print("\u001B[43m" + arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("Soru 3 Cevaplandı , Üst Menü için 5 , Çıkış için 0'a basın.");
    }

    public static void toBinary() {
        int[][] arr = readFile();
        int[][] newArr = new int[64][32];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] <= 10)
                    newArr[i][j] = 0;

                else
                    newArr[i][j] = 1;
            }
        }
        fileWrite(newArr);
        System.out.println("Soru 4 Cevaplandı , Üst Menü için 5 , Çıkış için 0'a basın.");
    }

    public static int[] countNumbers() {
        int[][] arr = readFile();
        int[] count = new int[256];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = arr[i][j];
                count[val]++;
            }
        }
        return count;
    }

    public static void printCounter() {
        int[] count = countNumbers();
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                System.out.println(i + " -> " + count[i] + " adet");
            }
        }
        System.out.println("Soru 2 Cevaplandı , Üst Menü için 5 , Çıkış için 0'a basın.");
    }

    public static void fileWrite(int[][] arr) {
        String path = "ikiliDosya.txt";
        try {
            FileWriter writer = new FileWriter(path);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    String satir = " " + arr[i][j];
                    writer.write(satir);
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Bir Hata Oluştu.");
            e.printStackTrace();
        }
        System.out.println("Veriler ikiliDosya.txt'ye yazdirildi.");
    }
}










