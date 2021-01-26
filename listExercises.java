package listExercises;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * List classes
 * A group of different list exercises
 * 
 * List Exercises!
 * 4/15/19
 * @author Cade Boggan
 */
public class listExercises {
	//testing methods
	public static void main(String[] args)  {
		List <String> tester = new ArrayList <String>();
		tester.add("red");
		tester.add("orange");
		tester.add("yellow");
		tester.add("green");
		tester.add("blue");
		tester.add("blue");
		tester.add("purple");
		tester.add("violet");
		tester.add("yellow");
		tester.add("green");
		tester.add("blue");
		tester.add("purple");

		List <String> testerShort = new ArrayList <String>();
		testerShort.add("rain");
		testerShort.add("parade");
		testerShort.add("bone");

		List <Integer> testerInt = new ArrayList <Integer>();
		testerInt.add(2);
		testerInt.add(4);
		testerInt.add(12);
		testerInt.add(1);
		testerInt.add(13);
		testerInt.add(7);

		List <Integer> testerInt2 = new ArrayList <Integer>();
		testerInt2.add(3);
		testerInt2.add(5);
		testerInt2.add(17);
		testerInt2.add(11);
		testerInt2.add(9);
		
		
		try {
			navarroExercises("randomFile");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

		List <String> testerM = new ArrayList <String>(tester);
		System.out.println("\n" + maxLength(testerM)); 

		List <String> testerS = new ArrayList <String>(tester);
		System.out.println(swapPairs(testerS)); 

		List <String> testerR = new ArrayList <String>(tester);
		System.out.println(removeEvenLength(testerR)); 

		List <String> testerD = new ArrayList <String>(tester);
		System.out.println(doubleList(testerD)); 
		
		List <Integer> testerF = new ArrayList <Integer>(testerInt);
		System.out.println(minToFront(testerF)); 

		List <String> testerP = new ArrayList <String> (tester);
		System.out.println(removeDuplicates(testerP)); 

		List <String> testerT = new ArrayList <String> (testerShort);
		System.out.println(stutter(testerT, 3)); 

		List <String> tester4 = new ArrayList <String> (testerShort);
		System.out.println(markLength4(tester4)); 

		List<String> testerRSS = new ArrayList <String> (tester);
		System.out.println(removeShorterStrings(testerRSS)); 

		List<Integer> testerI = new ArrayList <Integer> (testerInt);
		List<Integer> testerI2 = new ArrayList <Integer> (testerInt2);
		System.out.println(interleave(testerI, testerI2));

		List<Integer> testerA = new ArrayList <Integer> (testerInt);
		List<Integer> testerA2 = new ArrayList <Integer> (testerInt2);
		System.out.println(sumLists(testerA, testerA2));
	}

	public static void navarroExercises(String filename) throws FileNotFoundException {
		
		Scanner reader = new Scanner(new File(filename));
		ArrayList <Integer> a1 = new ArrayList<Integer>();
		
		while(reader.hasNext()) {
			if(reader.hasNextInt()) {	
				a1.add(reader.nextInt());
			}
			else{
				reader.next();
			}
		}
		reader.close();
		int first = a1.get(0);
		int last = a1.get(a1.size()-1);
		System.out.println("# of numbers: " + a1.size());
		
		System.out.print("Navarro Values: " );
		for(int i: a1) {
			System.out.print(i);
		}
		for(int i = 0; i < a1.size(); i++) {
			if(a1.get(i) % 2 != 0) {
				a1.remove(a1.get(i));
				i--;
			}
		}
		System.out.println("\n# of even numbers: "+ a1.size());
		Iterator iterator = a1.iterator();
		System.out.print("Even Navarro values: ");
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.print("\nFist element: " +  first + "\nLast element " + last);
	}

	public static int maxLength(List <String> some) {
		int max = 0;
		for(int i = 0; i < some.size(); i++) {
			if(some.get(i).length() > max) {
				max = some.get(i).length();
			}
		}
		return max;
	}



	public static List<String> swapPairs(List<String> tester) {
		if(tester.size() % 2 == 0) {
			for(int i = 0; i < tester.size(); i += 2) {
				String temp = "";
				String temp2 = "";
				temp = tester.get(i);
				temp2 = tester.get(i+1);
				tester.set(i,temp2);
				tester.set(i+1, temp);

			}
		}
		else {
			for(int i = 0; i < tester.size(); i += 2) {
				if(i != tester.size() - 1) {
					String temp = "";
					String temp2 = "";
					temp = tester.get(i);
					temp2 = tester.get(i+1);
					tester.set(i,temp2);
					tester.set(i+1, temp);

				}
			}

		}
		return tester;
	}
	public static List<String> removeEvenLength(List<String> some){
		for(int i = 0; i < some.size(); i++) {
			if(some.get(i).length() % 2 == 0) {
				some.remove(i);
				i--;
			}
		}
		return some;
	}
	public static List<String> doubleList(List<String> some){
		for(int i = 0; i < some.size(); i++) {
			some.set(i,((some.get(i) +", "+ some.get(i))));
		}
		return some;
	}
	public static List<Integer> minToFront(List<Integer> some){
		int min = some.get(0);
		int index = 0;
		for(int i = 0; i < some.size(); i++) {
			if(some.get(i) < min) {
				min = some.get(i);
				index = i;
			}
		}
		some.remove(index);
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(min);
		for(int i = 0; i < some.size(); i++) {
			newList.add(some.get(i));	
		}
		return newList;


	}

	public static List<String> removeDuplicates(List<String> some){
		String current = some.get(0);

		for(int j = 0; j < some.size(); j++) {
			current = some.get(j);
			for(int i = j+1; i < some.size(); i++) {
				if(some.get(i).equals(current)) {
					some.remove(i);
					i--;
				}
			}
		}
		return some;
	}
	/*check if k is <+ 0
		if so loop and remove all elements
	make a new list
		double for loop add elements of original list k times
	 */
	public static List<String> stutter(List<String> some, int k){
		if(k <= 0) {
			for(int i = 0; i == some.size(); i++) {
				some.remove(i);
				i--;
			}
		} 

		List <String> someLong = new ArrayList <String> ();
		for(int i = 0; i < some.size(); i++) {
			for(int o = 0; o < k; o++) {
				someLong.add(some.get(i));
			}
		}
		return someLong;
	}
	/*
	 * loop through find elements with length 4 
	 * elements of 4 get symbols added in new string before
	 */
	public static List<String> markLength4(List<String> some) {

		List <String> someLong = new ArrayList <String> ();
		for(int i =0; i < some.size(); i ++) {
			if(some.get(i).length() == 4) {
				someLong.add("$&*#");
			}
			someLong.add(some.get(i));
		}
		return someLong;
	}
	public static List<String> removeShorterStrings(List <String> some){
		List<String> someShort = new ArrayList <String> ();
		for(int i =0; i < some.size()-1; i +=2) {
			if(some.get(i).length() >= some.get(i+1).length()) {
				someShort.add(some.get(i));
			}
			else {
				someShort.add(some.get(i+1));
			}
		}
		if(some.size() % 2 != 0) {
			someShort.add(some.get(some.size()-1));
		}
		return someShort;
	}

	public static List<Integer> interleave(List <Integer> a1, List <Integer> a2){
		List<Integer> aNew = new ArrayList <Integer> ();
		int minList = 0;
		int count =0;
		if(a1.size() <= a2.size()) {
			minList = a1.size();
		}
		else {
			minList = a2.size();
		}
		for(int i =0; i < minList; i ++) {
			aNew.add(a1.get(i));
			aNew.add(a2.get(i));
			count++;
		} 
		if(a1.size() < a2.size()) {
			for(int i =0; i < a2.size() -count; i++) {
				aNew.add(a2.get(count + i));
			}
		}
		else {
			for(int i =0; i < a1.size() -count; i++) {
				aNew.add(a1.get(count + i));
			}
		}
		return aNew;
	}

	/*
	 *Write a method called sumLists that accepts two Lists of integers a1 and a2 as parameters and sums
	 *the values at each index together. If the lists are if uneven length, the remaining integers are discarded. 
	 */
	public static List<Integer> sumLists (List <Integer> a1, List <Integer> a2){
		List <Integer> summed = new ArrayList <Integer> ();
		int minList = 0;
		if(a1.size()> a2.size()) {
			minList = a2.size();
		}
		else {
			minList = a1.size();
		}
		for(int i = 0; i < minList; i++) {
			summed.add(a1.get(i) + a2.get(i));
		}
		return summed;
	}
}



