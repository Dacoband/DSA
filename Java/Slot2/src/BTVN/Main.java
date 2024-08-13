/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

import java.util.Scanner;

/**
 *
 * @author bolic
 */
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        // Thêm các phần tử vào danh sách
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(5);
        list.addLast(15);

        // In danh sách
        System.out.print("Danh sách ban đầu: ");
        list.traverse();

        System.out.println("Tổng các giá trị: " + list.sum());

        System.out.println("Giá trị lớn nhất: " + list.findMax());
        System.out.println("Giá trị nhỏ nhất: " + list.findMin());

        list.removeMax();
        System.out.print("Danh sách sau khi xóa giá trị lớn nhất: ");
        list.traverse();

        list.removeEven();
        System.out.print("Danh sách sau khi xóa các giá trị chẵn: ");
        list.traverse();

        list.reverse();
        System.out.print("Danh sách sau khi đảo ngược: ");
        list.traverse();
    }
}
