package com.coderbyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class DuplicateWords {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    String test = s.nextLine();
	    // String testString = "Big black bug bit a big black dog on his big black nose";
	    System.out.println(duplicateWords(test).toString());
	    System.out.println(duplicateWordsWithMap(test).toString());

	    s.close();
	}
	
	public static ArrayList<String> duplicateWords(String sentence) {
		
		ArrayList<String> duplicates = new ArrayList<String>();
		//Converts the string into lowercase  
        sentence = sentence.toLowerCase();  
          
        //Split the string into words using built-in function  
        String words[] = sentence.split(" ");
        int count = 0;
          
        System.out.println("Duplicate words in a given string : ");   
        for(int i = 0; i < words.length; i++) {  
            count = 1;  
            for(int j = i+1; j < words.length; j++) {  
                if(words[i].equals(words[j])) {  
                    count++;  
                    //Set words[j] to 0 to avoid printing visited word  
                    words[j] = "0";  
                }  
            }  
              
            //Displays the duplicate word if count is greater than 1  
            if(count > 1 && words[i] != "0") {
                System.out.println(words[i]);
                duplicates.add(words[i]);
            }
        }
        return duplicates;
	}
	
	public static Map<String, Integer> duplicateWordsWithMap(String sentence) {
		
		Map<String, Integer> duplicates = new HashMap<String, Integer>();
		Map<String, Integer> all = new HashMap<String, Integer>();
		//Converts the string into lowercase  
        sentence = sentence.toLowerCase();  
          
        //Split the string into words using built-in function  
        String words[] = sentence.split(" ");
        Stream<String> wordStream = Arrays.stream(words);
        wordStream.forEach(w -> {
        	if (all.containsKey(w)) {
        		Integer temp = all.get(w);
        		temp++;
            	all.put(w, temp);
        	} else {
        		all.put(w, 1);
        	}
        });
        all.forEach((k, v) -> {
        	if (v > 1) {
        		duplicates.put(k, v);
        	}
        });
        
        return duplicates;
	}
}
