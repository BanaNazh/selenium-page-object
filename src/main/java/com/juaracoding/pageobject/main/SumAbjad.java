package com.juaracoding.pageobject.main;

import java.util.Scanner;

public class SumAbjad {

	public static void main(String[] args) {
		Scanner scannerTest = new Scanner(System.in);
		System.out.println("Masukan text : ");
		String str = scannerTest.nextLine().toUpperCase();
		int sum = 0;
		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z') {
				int angka = 1 + ch - 'A';
				System.out.print(angka + "+");
				sum += 1 + ch - 'A';
			}
		}
//		System.out.printf("Jumlah text: %s adalah %d%n", str, sum);
		System.out.printf("=%d", sum);

	}
}
