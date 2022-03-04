package CompetitiveProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class stampCombinations {
	
	
	
	
	public static boolean slidingWindow(int arr[], int target) {
		int sum = 0;
		int start = -1;
		int end = -1;
		
		while(true) {
			
			if(sum < target) {
				end++;
				
				if(end > arr.length -1 ) {
					break;
				}
				sum+=arr[end];
			}else if(sum > target) {
				if(start > arr.length -1 ) {
					break;
				}
				start++;
				sum-=arr[start];
				
			}
			
			
			if(sum == target) {
				return true;
			}
			
			
		}
			
		
		
		
		return false;
		
		
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String a[] = obj.nextLine().split(" ");
		int[] lens = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
		int queries = lens[1];
		String b[] = obj.nextLine().split(" ");
		int[] stamps = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();
		
		int sum = 0;
		for(int i = 0 ; i < stamps.length; i++) {
			sum+=stamps[i];
		}
		
		for(int i = 0; i < queries; i++) {
			int input = Integer.parseInt(obj.nextLine());
			if(input > sum) {
				System.out.println("No");
				continue;
			}
			int target = sum - input;
			if(target == 0) {
				System.out.println("Yes");
				continue;
			}
			
			boolean res = slidingWindow(stamps, target);
			if(res == true) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		
		
		
	}

}
