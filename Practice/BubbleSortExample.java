import java.util.Arrays;
import java.util.Random;

public class BubbleSortExample {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có hoán đổi nào xảy ra, kết thúc sớm
            if (!swapped) break;
        }
    }

    // Hàm in mảng
    public static void main(String[] args) {
        int[] arr = new int[2000000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000000);
        }

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        // Lấy bộ nhớ ban đầu
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Gọi garbage collector để lấy thông số chính xác hơn
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        // Sử dụng Bubble Sort (hoặc thay bằng Arrays.sort(arr); để so sánh)
        bubbleSort(arr);

        long endTime = System.currentTimeMillis();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();
        long duration = endTime - startTime;
        long memoryUsed = endMemory - startMemory;

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);

        System.out.println("Thời gian sắp xếp: " + duration + " milliseconds");
        System.out.println("Dung lượng bộ nhớ sử dụng: " + memoryUsed / (1024 * 1024) + " MB");
    }

    // Hàm in mảng (giới hạn số lượng phần tử in ra)
    public static void printArray(int[] arr) {
        for (int i = 0; i < Math.min(arr.length, 100); i++) { // Chỉ in 100 phần tử đầu tiên
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
