package hello;

public class Transpose {
	
	public static void main(String[] args) {
		
		int[][] original = { {1, 2, 3}, {4, 5, 6} };
		
		for(int[] originals : original)
	    {
	        for(int orig : originals)
	        {
	        	System.out.print("");
				System.out.print("|");
				System.out.print(""+ orig + "|");
	        }
	        System.out.println();
	    }
		
		trasposeMatrix(original);
		
	}

	public static int[][] trasposeMatrix(int[][] original)
	{
	    int m = original.length;
	    int n = original[0].length;

	    int[][] trasposedMatrix = new int[n][m];

	    for(int x = 0; x < n; x++)
	    {
	        for(int y = 0; y < m; y++)
	        {
	            trasposedMatrix[x][y] = original[y][x];
	        }
	    }
	    
	    for(int[] transposes : trasposedMatrix)
	    {
	        for(int transpose : transposes)
	        {
	        	System.out.print("");
				System.out.print("|");
				System.out.print(""+ transpose + "|");
	        }
	        System.out.println();
	    }
	    
	    return trasposedMatrix;
	}
}
