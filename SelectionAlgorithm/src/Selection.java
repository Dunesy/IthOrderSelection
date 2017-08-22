import java.util.Arrays;

public class Selection {

	
	public static void swap(int left, int right, int[] array) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static int partition(int[] data, int index, int left, int right)
	{
		//Partitions array around index value and returns it's index;
		if (index < left || index > right || left > right) {
			return -1;
		}
		int pivotValue = data[index];
		data[index] = data[right];
		data[right] = pivotValue;
		
		//System.out.println("Pivot Value " + pivotValue);
		
		int low = left - 1;
		int high = right;
		
		while (true) {
			
			   while(data[++low] < pivotValue) {
			         //do nothing
			      }
					
			      while(high > 0 && data[--high] > pivotValue) {
			         //do nothing
			      }							
			
			      if(low >= high) {
			          break;
			       } else {
			         // System.out.println(String.format(" item swapped :%d,%d\n", data[low],data[high]));
			          swap(low, high, data);
			       }
			}
		
			     // System.out.println(String.format("pivot swapped :%d,%d\n", data[low],data[data.length -1]));
			      swap(low,right,data);
		
		return low;
	}
	
	public static int ithOrderStatisticSelect(int[] array, int i ) {
		
		int right = array.length -1;
		int left = 0; 
		int index = -1;
		while (true) {
									
			if (left == right) {
				return array[left];
			}	
			//System.out.println(left + " " + right);
			
			for (int j = left ; j <= right; j++) {
				//System.out.print(array[j] + " ");			
			}
			//System.out.println();
			
			index = partition(array, Math.abs((left + right)) / 2, left, right);
			
			for (int j = left ; j <= right; j++) {
			//	System.out.print(array[j] + " ");			
			}
		//	System.out.println();
			//System.out.println("Index " + index);
			
			if (index > i) {
				right = index -1; 				
			} else if (index < i) {				
				left = index + 1;			
			} else {			
				return array[index];
			}
			
		}
			
	}
	
	public static void main(String args[]) {
		
		int[] array = new int[] {17, 3, 9, 12, 16, 4, 7, 3, 8, 17, 1, 12, 9, 11, 13, 10, 3, 7, 3, 1};
		int[] array2 = new int[1000000];
		for (int i = 0 ; i < 1000000; i++) {
			array2[i] = (int)(Math.random() * 10000.0); 
		}
				
		//for (int i = 0 ; i < array2.length; i++) {
		//	System.out.print(array2[i] + ", ");
		//}
		
		//System.out.println();
		
		long startTime = System.currentTimeMillis(); 
		int result = ithOrderStatisticSelect(array2, 5000);
		long finishTime = System.currentTimeMillis()  - startTime;
		
		
		System.out.println();
		System.out.println(result + " " + finishTime);
		
		
		startTime = System.currentTimeMillis(); 
		Arrays.sort(array2);
		finishTime = System.currentTimeMillis()  - startTime;
		
		System.out.println(array2[5000] + " " + finishTime);
		
		
	}
	
	
	
	
}
