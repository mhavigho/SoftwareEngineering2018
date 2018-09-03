// Michael Havighorst
// Homework 2
// Question 3

package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question3 {

	public int getMirrorCount(int[] arr) {
		int[] reversedArr = mirrorArray(arr);
		return getMaxCount(arr, reversedArr);
	}
    
	private int[] mirrorArray(int[] array1) {
		int[] mirrored = new int[array1.length];
		for (int i = array1.length-1, j = 0; i >= 0; i--, j++) {
			mirrored[j] = array1[i];
        }   
		return mirrored;
	} 
	
	private int getMaxCount(int[] original, int[] reversed) {
		int max = 0;
		int count = 0;
		for (int i = 0; i < original.length; i++) {
			if (original[i] == reversed[i]) {
				count++;
            }
			else {
				count = 0;
            }
			if (count > max) {
				max = count;
			}      
		}
		System.out.println(max);
		return max;
	}

}