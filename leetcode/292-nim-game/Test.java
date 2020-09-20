public class Test {

	public static void main(String[] args) {
		Solution mySolution = new Solution();

		for(int i=0; i<6; i++) {
			System.out.print("Result for number "+i+": ");
			if(mySolution.canWinNim(i)) {
				System.out.print("Yes");
			}
			else {
				System.out.print("No");
			}
			System.out.println(".");
		}
	}
}