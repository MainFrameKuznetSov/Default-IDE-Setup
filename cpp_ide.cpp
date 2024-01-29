#include <bits/stdc++.h>
using namespace std;
int BinarySearchDesc(vector<int> x,int t)
{
    int l=0,r=x.size()-1,mid;
    while(l<=r)
    {
        mid=l+(r-l)/2;
        if(x[mid]==t)
            return mid;
        if(x[mid]>t)
            l=mid+1;
        else
            r=mid-1;
    }
    return -1;
}
int BinarySearch(vector<int> x,int t)
{
    int l=0,r=x.size()-1,mid;
    while(l<=r)
    {
        mid=l+(r-l)/2;
        if(x[mid]==t)
            return mid;
        if(x[mid]>t)
            r=mid-1;
        else
            l=mid+1;
    }
    return -1;
}
vector<int> getSieve(int n)
{
    vector<bool> isPrime(n+1,1);
    vector<int> getPrime;
    isPrime[0]=0;
    isPrime[1]=0;
    for(int i=2;i*i<=n;i++)
    {
        if(isPrime[i])
        for(int j=i*i;j<=n;j+=i)
            isPrime[j]=0;
    }
    for(int i=2;i<=n;i++)
    {
        if(isPrime[i])
            getPrime.push_back(i);
    }
    return getPrime;
}
long long exp(int a,int b)
{
    if(b==0)
        return 1;
    if(b==1)
        return a;
    if(b%2==0)
        return exp(a,b/2)*exp(a,b/2);
    else
        return a*exp(a*a,(b-1)/2);
}
void solve()
{
    /*Your Code starts here*/
    int n;
    cin>>n;
}
int main() 
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin>>t;
	while(t--)
	{
	   solve();
	}
	return 0;
}
