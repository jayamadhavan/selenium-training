package mavenproject.class1;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Arrayinsert {
	private static void insert( ) {
		
    	int[] anArray = new int[] {1,2,3,4,5};
    	
    	
    	int[] resultArray = ArrayUtils.insert(3, anArray, 0);
    	@SuppressWarnings("unused")
		int[] Firstelememt = anArray;
    	
    			System.out.println(Arrays.toString(resultArray));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		insert();
	}

}
