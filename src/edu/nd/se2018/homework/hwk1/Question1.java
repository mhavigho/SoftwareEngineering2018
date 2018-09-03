// Michael Havighorst
// Homework 2
// Question 1

package edu.nd.se2018.homework.hwk1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Iterator;

public class Question1 {

	public int getSumWithoutDuplicates(int[] arr) {
		HashSet<Integer> entries = IntStream.of(arr).boxed().collect(Collectors.toCollection(HashSet::new));
		int total = 0;
		Iterator<Integer> i = entries.iterator();
		while(i.hasNext()){
			total += i.next();
		}
		System.out.println(total);
		return total;
	}      
}