package DynamicProgramming.EggDropping;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng quả trứng và số lượng tầng
        System.out.print("Enter the number of eggs: ");
        int eggsCount = scanner.nextInt();

        System.out.print("Enter the number of floors: ");
        int floors = scanner.nextInt();

        // Khởi tạo mảng quả trứng
        Egg[] eggs = new Egg[eggsCount];
        for (int i = 0; i < eggsCount; i++) {
            eggs[i] = new Egg();
        }

        // Khởi tạo đối tượng tòa nhà
        Building building = new Building(floors);

        // Gọi phương thức minDroppings từ EggDropSolver và output
        int minDroppings = EggDropSolver.minDroppings(eggs, building);
        System.out.println("The minimum number of egg droppings needed: " + minDroppings);
    }
}
