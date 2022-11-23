package hust.soict.dsai.lab01;

import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = keyboard.nextInt();
        int[] a = new int[n];
        int sum = 0;
        double avarage = 0;
        for (int i = 0; i < n; i++){
            a[i] = keyboard.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;

            }
        }
        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < n; i++ ) {
            sum += a[i];
        }
        avarage = (float) sum / n;
        System.out.print("Sum of all elments in array: " + sum + "\n");
        System.out.print("average of the elements in the array: " + avarage);
    }
}
