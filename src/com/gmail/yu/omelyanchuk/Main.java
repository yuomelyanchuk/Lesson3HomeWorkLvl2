package com.gmail.yu.omelyanchuk;

import java.util.Scanner;

public class Main {

	private static double distance(double x1, double y1, double x2, double y2) {

		return (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
	}

	private static double triangleArea(double a, double b, double c) {
		double p;
		p = (a + b + c) / 2.0;
		return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
	}

	private static double round(double value, int places) {
		if (places < 0) {
			return 0d;
		} else {
			long factor = (long) Math.pow(10, places);
			value = value * factor;
			long tmp = Math.round(value);
			return (double) tmp / factor;
		}
	}

	private static void isPalindrome(int a) {
		int k;
		String s;
		boolean b = true;
		k = Integer.toString(a).length();
		s = Integer.toString(a);
		if (k % 2 == 0) {
			for (int i = 0; i < k / 2; i++) {
				if (s.charAt(i) != s.charAt(k - 1 - i)) {
					b = false;
				}
			}

		} else {
			b = false;
		}
		if (b) {
			System.out.println("palindrome");
		} else {
			System.out.println("not palindrome");
		}

	}

	private static void isHappyTicket(int a) {
		int k;
		int summ1 = 0;
		int summ2 = 0;
		String s;
		boolean b = true;
		k = Integer.toString(a).length();
		s = Integer.toString(a);
		if (k % 2 == 0) {
			for (int i = 0; i < k / 2; i++) {
				summ1 += Integer.parseInt(String.valueOf(s.charAt(i)));
				summ2 += Integer.parseInt(String.valueOf(s.charAt(k - 1 - i)));
			}
			if (summ1 != summ2) {
				b = false;
			}
		} else {
			b = false;
		}
		if (b) {
			System.out.println("happy");
		} else {
			System.out.println("not happy");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x;
		double y;
		// tasc 1

		System.out.println("input point x");
		x = sc.nextDouble();
		System.out.println("input point y");
		y = sc.nextDouble();
		if (distance(x, y, 0, 0) <= 4) {
			System.out.println("in circle");
		} else {
			System.out.println("not in circle");
		}

		// tasc 2
		System.out.println("input point x");
		x = sc.nextDouble();
		System.out.println("input point y");
		y = sc.nextDouble();
		double originalTriangleArea;
		originalTriangleArea = triangleArea(distance(0, 0, 4, 4), distance(0, 0, 6, 1), distance(4, 4, 6, 1));
		double tr1Area;
		double tr2Area;
		double tr3Area;
		tr1Area = triangleArea(distance(0, 0, 4, 4), distance(4, 4, x, y), distance(x, y, 0, 0));
		tr2Area = triangleArea(distance(0, 0, x, y), distance(x, y, 6, 1), distance(6, 1, 0, 0));
		tr3Area = triangleArea(distance(4, 4, x, y), distance(x, y, 6, 1), distance(6, 1, 4, 4));
		if (round(tr1Area + tr2Area + tr3Area, 3) == round(originalTriangleArea, 3)) {
			System.out.println("in triangle");
		} else {
			System.out.println("not in triangle");
		} 
		// tasc 3

		int a;
		System.out.println("input digit for happy test");
		a = sc.nextInt();
		isHappyTicket(a);

		System.out.println("input digit for palindrome test");
		a = sc.nextInt();
		isPalindrome(a);

		sc.close();

	}

}
