package hello;

public class ExamplesDay1 {

	public static void main(String[] args) {
		
		/*double[] myDblArray = new double[5];
		myDblArray[2] = 12.5;
		
		System.out.println(myDblArray);
		System.out.println(myDblArray[2]);
		System.out.println(myDblArray.length);*/

		int[][] numbers = {
			{10, 20, 30},
			{40, 50, 60},
			{70, 80, 90}
		};
		
		for(int[] number: numbers) {
			for(int numbe : number) {
				System.out.print(numbe + " ");
			}
			System.out.println();
		}
	}

}
