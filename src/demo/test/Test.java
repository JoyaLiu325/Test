package demo.test;

import java.util.ArrayList;

public class Test {
	
	public static String replace(ArrayList<Integer> array1,ArrayList<Integer> array2) {
		if(array1 == null || array2 == null)
			return null;
		int lengthNew = array1.size() + array2.size();
		int k = lengthNew -1;
		int i = array1.size()-1;
		int j = array2.size()-1;
		array1.addAll(array2);
		while(i>=0 && j>=0) {
			if(array1.get(i)>array2.get(j)) {
				array1.set(k, array1.get(i));
				k--;
				i--;
			}
			else {
				array1.set(k, array2.get(j));
				k--;
				j--;
			}
		}
		while(i>=0) {
			array1.set(k, array1.get(i));
			i--;
		}
		while(j>=0) {
			array1.set(k, array2.get(j));
			j--;
		}
		return array1.toString();
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array1.add(1);
		array1.add(3);
		array1.add(6);
		array2.add(2);
		array2.add(4);
		array2.add(5);
		array2.add(7);
		System.out.println(replace(array1,array2));
	}
}
