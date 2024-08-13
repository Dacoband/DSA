/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetThreeLargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bolic
 */
public class Slot2 {

    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(50, 1, 100);
        System.out.println("List: " + numbers);
        List<Integer> getNumberLargest = getThreeLargestNumber(numbers);
        System.out.println("3 Largest Number" + getNumberLargest);
        List<Integer> modifiNumber = removeThreeLargestNumbers(numbers);
        System.out.println("Romove List" + modifiNumber);
    }
     private static List<Integer> generateRandomNumbers(int size, int min, int max) {
        Random rand = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(rand.nextInt((max - min) + 1) + min);
        }
        return numbers;
    }
     private static List<Integer> getThreeLargestNumber(List<Integer> numbers){
         List<Integer> largest = new ArrayList<>(numbers);
         largest.sort(Collections.reverseOrder());
         
         return largest.subList(0, 3);
     }
     private static List<Integer> removeThreeLargestNumbers(List<Integer> numbers){
         List<Integer> copy = new ArrayList<>(numbers);
         
         copy.sort(Collections.reverseOrder());
         int count = 0;
         for(int i = 0 ;i < copy.size() && count < 3 ; i++){
             int Largest = copy.get(i);
             if (numbers.remove(Integer.valueOf(Largest))) {
                 count++;
             }
         }
         return numbers;
     }
}
