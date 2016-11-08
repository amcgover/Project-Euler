import java.util.ArrayList;

public class Problem32 {//45228
    public static final int UPPER_LIMIT = 9999;
	public static void main(String[] args) {
		long sum = 0;
		ArrayList<Integer> seen = new ArrayList<Integer>();
		for(int i = 1; i < 100; i++) {
			for(int j = 1; j < 10000; j++) {
				int product = i *j;
				
				int[] arguments = {i,j,product};
				if (!seen.contains(product) && pandigital(arguments)) {
					sum += product;
					seen.add(product);
					System.out.printf("%d*%d=%d\n",i,j,product);
				}
			}
		}
		System.out.println(sum);
	}
	
	public static boolean pandigital(int[] numbers) {
		boolean[] digits = new boolean[9];
		int digitCounts = 0;
		for (int numberToCheck : numbers) {
			while (numberToCheck > 0) {
			    int digit = (numberToCheck % 10)-1;
			    
			    if (digit == -1) return false;//0 appears in one of the numbers
			    
			    if (digits[digit]) return false;//We've already seen the digit
			    
			    digits[digit] = true;
			    digitCounts++;
			    numberToCheck /= 10;
			}
		}
	    return (digitCounts==9);
	}

}
