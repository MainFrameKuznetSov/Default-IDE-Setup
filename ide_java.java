import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
class 
{
	public static void main(String[] args) 
	{
		MainframeScanner ms=new MainframeScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=ms.nextInt();
		while(t-->0)
		{
		    int n=ms.nextInt();
		    
		}
		pw.close();
	}
	static ArrayList<Integer> getSieve(int n)
	{
	    boolean isPrime[]=new boolean[n+1];
	    Arrays.fill(isPrime,true);
	    isPrime[0]=false;
	    isPrime[1]=false;
	    for(int i=2;i*i<=n;i++)
	    {
	        if(isPrime[i])
	        {
	            for(int j=i*i;j<=n;j+=i)
	                isPrime[j]=false;
	        }
	    }
	    ArrayList<Integer>al=new ArrayList<>();
	    for(int i=2;i<=n;i++)
	    {
	        if(isPrime[i])
	            al.add(i);
	    }
	    return al;
	}
	static int getMax(int x[])
	{
	    sort(x);
	    return x[x.length-1];
	}
	static void BinarySearch2D(int x[][],int t)
	{
	    int i=0,j=x[0].length-1;
	    while(i<=x.length-1 && j>=0)
	    {
	        if(x[i][j]==t)
	        {
	            System.out.println(i+" "+j);
	            return ;
	        }
	        if(x[i][j]>t)
	            --j;
	        else
	            ++i;
	    }
	    System.out.println("NO");
	}
	static int BinarySearchBitonic(int x[],int t)
	{
	    int temp=getIndexOfPeakElement(x);
		int prob1=BinarySearchRec(x,0,temp-1,t);
	    int prob2=BinarySearchRecDesc(x,temp,x.length-1,t);
	    if(prob1==-1 && prob2==-1)
	        return -1;
		else if(prob1!=-1)
	        return prob1;
	    else
	        return prob2;
	}
	static int getIndexOfPeakElement(int x[])
	{
	    int l=0,size=x.length,r=size-1,mid;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]>=x[(mid+1)%size] && x[mid]>=x[(mid+size-1)%size])
	            return mid;
	        else if(x[mid]>x[(mid+size-1)%size] && x[mid]<x[(mid+1)%size])
	            l=mid+1;
	        else
	            r=mid-1;
	    }
	    return -1_000_000_007;
	}
	static int getIndexOfCeil(int x[],int t)
	{
	    int temp=getCeil(x,t);
	    return BinarySearchRec(x,0,x.length-1,temp);
	}
	static int getPeakElement(int x[])
	{
	    int l=0,size=x.length,r=size-1,mid;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]>=x[(mid+1)%size] && x[mid]>=x[(mid+size-1)%size])
	            return x[mid];
	        else if(x[mid]>x[(mid+size-1)%size] && x[mid]<x[(mid+1)%size])
	            l=mid+1;
	        else
	            r=mid-1;
	    }
	    return -1;
	}
	static int getClosest(int x[],int t)
	{
	    int l=0,r=x.length-1,mid;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(x[mid]==t)
                return x[mid];
            if(x[mid]>t)
                r=mid-1;
            else    
                l=mid+1;
        }
        return (Math.abs(x[r]-t)<Math.abs(x[l]-t)?x[r]:x[l]);
	}
	static int getCeil(int x[],int t)
	{
	    int l=0,size=x.length,r=size-1,mid,res=1_000_000_007;
	    if(t>x[size-1])
	        return -1;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]>=t)
	        {
	            r=mid-1;
	            res=Math.min(x[mid],res);
	        }
	        else
	            l=mid+1;
	    }
	    return res;
	}
	static int getFloor(int x[],int t)
	{
	    int l=0,size=x.length,r=size-1,mid,res=-1;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]<=t)
	        {
	            l=mid+1;
	            res=Math.max(x[mid],res);
	        }
	        else
	            r=mid-1;
	    }
	    return res;
	}
	static int ModifiedBS(int x[],int t)//Nearly Sorted Array
	{
	    int l=0,size=x.length,r=size-1,mid;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]==t)
	            return mid;
	        if(x[(mid+1)%size]==t)
	            return (mid+1)%size;
	        if(x[(mid+size-1)%size]==t)
	            return (mid+size-1)%size;
	        if(x[mid]>t)
	            r=(mid+size-2)%size;
	        else
	            l=(mid+2)%size;
	    }
	    return -1;
	}
	static int BinarySearchinSRA(int x[],int t)
	{
	    int l=0,size=x.length,r=size-1,mid;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]==t)
	            return mid;
	        if(x[mid]>t)
	            r=(mid+size-1)%size;
	        if(x[mid]<t)
	            l=(mid+1)%size;
	    }
	    return -1;
	}
	static int numRot(int x[])
	{
	    int size=x.length;
	    return (size-findSmallest(x));
	}
	static int findSmallest(int x[])//Unique Arrays only
	{
	    int l=0,r=x.length-1;
	    int mid,size=x.length;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]<x[(mid+size-1)%size])
	            return mid;
	        if(x[(mid+1)%size]<x[mid])
	            return (mid+1)%size;
	        if(x[r]>x[mid])
	            r=(mid+size-1)%size;
	        if(x[r]<x[mid])
	            l=(mid+1)%size;
	    }
	    return -1;
	}
	static int FirstOccurence(int x[],int t)
	{
	    int l=0,r=x.length-1,mid,res=-1;
        while(l<=r)
        {
            mid=l+((r-l)/2);
            if(x[mid]==t)
            {
                res=mid;
                r=mid-1;
            }
            if(x[mid]>t)
                r=mid-1;
            if(x[mid]<t)    
                l=mid+1;
        }
        return res;
	}
	static int LastOccurence(int x[],int t)
	{
	    int l=0,r=x.length-1,mid,res=-1;
        while(l<=r)
        {
            mid=l+((r-l)/2);
            if(x[mid]==t)
            {
                res=mid;
                l=mid+1;
            }
            if(x[mid]>t)
                r=mid-1;
            if(x[mid]<t)    
                l=mid+1;
        }
        return res;
	}
	static int BinarySearchRec(int x[],int l,int r,int t)
	{
	    if(l>r)
	        return -1;
	    int mid=l+(r-l)/2;
	    if(x[mid]==t)
	        return mid;
	    if(x[mid]>t)
	        return BinarySearchRec(x,l,mid-1,t);
	    else
	        return BinarySearchRec(x,mid+1,r,t);
	}
	static int BinarySearchRecDesc(int x[],int l,int r,int t)
	{
	    if(l>r)
	        return -1;
	    int mid=l+(r-l)/2;
	    if(x[mid]==t)
	        return mid;
	    if(x[mid]>t)
	        return BinarySearchRec(x,mid+1,r,t);
	    else
	        return BinarySearchRec(x,l,mid-1,t);
	}
	static int charBinarySearch(char x[],char t)
	{
	    int l=0,r=x.length-1,mid;
	    while(l<=r)
	    {
	        mid=l+(r-l)/2;
	        if(x[mid]==t)
	            return mid;
	        if((int)x[mid]>(int)t)
	            r=mid-1;
	        else
	            l=mid+1;
	    }
	    return -1;
	}
    static long[] prefixSum(int x[])
    {
        long psum[]=new long[x.length];
        psum[0]=x[0];
        for(int i=1;i<x.length;i++)
            psum[i]=psum[i-1]+x[i];
        return psum;
    }
	static int reverse(int x)
	{
	    int rev=0;
	    while(x!=0)
	    {
	        rev=rev*10+(x%10);
	        x/=10;
	    }
	    return rev;
	}
	static long reverselong(long x)
	{
	    long rev=0;
	    while(x!=0)
	    {
	        rev=rev*10+(x%10);
	        x/=10;
	    }
	    return rev;
	}
	static int __gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return __gcd(b%a, a);
    }
    static int countDigit(int x)
    {
        return (int)Math.log10(x)+1;
    }
    static boolean isPowerOf2(int x)
    {
        return (x!=0 && (x&(x-1))==0);
    }
	static final Random random=new Random();
	static final int mod=1_000_000_007;
	static long add(long a, long b) 
	{
		return (a+b)%mod;
	}
	static long sub(long a, long b) 
	{
		return ((a-b)%mod+mod)%mod;
	}
	static long mul(long a, long b) 
	{
		return (a*b)%mod;
	}
	static long exp(long base, long exp) 
	{
		if (exp==0) 
		    return 1;
		return (exp%2==0?exp(base*base,exp/2):base*exp(base*base,exp/2));
	}
	static long[] factorials=new long[2_000_001];
	static long[] invFactorials=new long[2_000_001];
	static void precompFacts() 
	{
		factorials[0]=invFactorials[0]=1;
		for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
		invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
		for (int i=invFactorials.length-2; i>=0; i--)
			invFactorials[i]=mul(invFactorials[i+1], i+1);
	}
	static long nCk(int n, int k) 
	{
		return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
	}
	static void print2DArray(int [][]x)
	{
	    for(int i=0;i<x.length;i++)
	    {
	        for(int j=0;j<x[0].length;j++)
	            System.out.print(x[i][j]+" ");
	        System.out.println();
	    }
	}
	static void printArray(int[] x)
	{
	    for(int i:x)
	    System.out.print(i+" ");
	    System.out.println();
	}
	static void sort(int[] a) 
	{
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static void sortrev(int[] a) 
	{
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l,Collections.reverseOrder());
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static class MainframeScanner 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() 
		{
			while (!st.hasMoreTokens())
				try 
				{
					st=new StringTokenizer(br.readLine());
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt() 
		{
			return Integer.parseInt(next());
		}
		char[] readCharArray(int n)
		{
		    char[] a=new char[n];
		    for(int i=0;i<n;i++) a[i]=next().charAt(0);
		    return a;
		}
		int[] readArray(int n) 
		{
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long[] readLongArray(int n)
		{
		    long[] a=new long[n];
		    for(int i=0;i<n;i++) a[i]=nextLong();
		    return a;
		}
		int[][] read2DArray(int n,int m)
		{
		    int [][]a=new int[n][m];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<m;j++)
		            a[i][j]=nextInt();
		    }
		    return a;
		}
		long nextLong() 
		{
			return Long.parseLong(next());
		}
		double nextDouble()
		{
		    return Double.parseDouble(next());
		}
	}
}
