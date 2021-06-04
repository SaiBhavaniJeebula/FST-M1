package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {10, 77, 10, 54, -11, 10};
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 10) {
				sum = sum + array[i];
			}
		}
		if(sum == 30) {
			System.out.println("Sum is equal to 30");
		}
		else if(sum > 30){
			System.out.println("Sum is greater than 30");
		}
		else {
			System.out.println("Sum is less than 30");
		}
	}

}
