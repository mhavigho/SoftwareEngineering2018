// Michael Havighorst
// Homework 2
// Question 2

package edu.nd.se2018.homework.hwk1;

import java.util.*;
import java.util.Map.Entry;

public class Question2 {
	
	public Object getMostFrequentWord(String inputString, String stopWords) {
		HashMap<String, Integer> words = new HashMap<>();
		// Split by " "
		String[] item1 = stopWords.split(" ");
		HashSet<String> stopSet = new HashSet<>(Arrays.asList(item1));
		// Split again
		String[] item2 = inputString.split(" ");
		for (String item: item2){
			if(!stopSet.contains(item)) {
				if(words.containsKey(item)) {
					int tally = words.get(item);
					words.put(item, tally+1);
				} 
				else {
					words.put(item, 1);
				}
			}
		}
		// Must check if top two most frequent words have same count
		// Turn the mapped values into an order array and check last two values
		Object[] counts = words.values().toArray();
		Arrays.sort(counts);      
		if (counts[counts.length-1] == counts[counts.length-2]) {
			return null;
		}
		// If the most frequent word has a unique count, we return that word
		Map.Entry<String,Integer> maxCount = (Entry<String, Integer>) words.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get();
		System.out.println(maxCount.getKey());
		return maxCount.getKey();
	}

}