import java.util.*;
class PartitionPalindrome
{
	int[][] cache;
	public boolean isPalindrome(char[] arr,int i,int j)
	{
		boolean flag = true;
		while(i<=j)
		{
			if(arr[i] != arr[j])
			{
				flag = false;
				break;
			}
			i++;
			j--;
		}
		return flag;
	}
	public int solve(char[] arr,int i,int j)
	{
		if(i>=j)
			return 0;
		
		if(cache[i][j]!= -1) 
			return cache[i][j];
		
		if(isPalindrome(arr,i,j) == true) 
			return 0;
		
		int minVal = Integer.MAX_VALUE;
		for(int k = i;k<j;k++)
		{
			int tempmin = 1 + solve(arr,i,k) + solve(arr,k+1,j);
			
			minVal = Math.min(minVal,tempmin);
		}
		return cache[i][j] = minVal;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		int n = arr.length;
		PartitionPalindrome obj = new PartitionPalindrome();
		obj.cache = new int[n+1][n+1];
		for(int[] a:obj.cache)
		{
			Arrays.fill(a,-1);
		}
		System.out.println("Minimum number of partition = "+obj.solve(arr,0,n-1));
	}
}
