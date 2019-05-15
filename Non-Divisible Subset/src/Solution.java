import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int nonDivisibleSubset(int k, int[] S) {
    	List<LinkedList<Integer>> result = new ArrayList<>();
    	for(int i=1;i<=k;i++)
    		result.add(new LinkedList<Integer>());
    	for(int itr:S) { 
			result.get(itr%k).add(itr);  
		}
    	
    	int sum = 0;
    	for(int i=1;i<=k-i;i++) {
    		// i == k-i
    		// (i+i)%2
    		if((i+i)%k==0) {
    			if(result.get(i).size()!=0)
    				sum+=1;
    			continue;
    		}
    		if(i == k-i)
    			sum+=result.get(i).size();
    		else
    			 sum+=((result.get(i).size()>result.get(k-i).size())?result.get(i).size():result.get(k-i).size());
    		
    	}
    	if(result.get(0).size()!=0)
    		return sum+1;
		return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);
        System.out.println(result);

        scanner.close();
    }
}
