#include <bits/stdc++.h>
using namespace std;
int getIndexOfPeakElement(int x[],int size)
{
    int l=0,r=size-1,mid;
    while(l<=r)
    {
        mid=l+(r-l)/2;
        if(x[mid]>=x[(mid+size-1)%size] && x[mid]>=x[(mid+1)%size])
            return mid;
        if(x[(mid+1)%size]>x[mid])
            l=(mid+1)%size;
        else
            r=(mid+size-1)%size;
    }
    return -1;
}
int BinarySearchDescRec(int x[],int l,int r,int t)
{
    if(l>r)
        return -1;
    int mid=l+(r-l)/2;
    if(x[mid]==t)
        return mid;
    if(x[mid]>t)
        return BinarySearchDescRec(x,mid+1,r,t);
    else
        return BinarySearchDescRec(x,l,mid-1,t);
}
int BinarySearchRec(int x[],int l,int r,int t)
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
int BinarySearchBitonic(int x[],int size,int t)
{
    int temp=getIndexOfPeakElement(x,size);
    if(temp==-1)
        return -1;
    int prob1=-1,prob2=-1;
    prob1=BinarySearchRec(x,0,temp-1,t);
    prob2=BinarySearchDescRec(x,temp,size-1,t);
    if(prob1==-1 && prob2==-1)
        return -1;
    return((prob2>prob1)?prob2:prob1);
}
int BinarySearchDesc(int x[],int size,int t)
{
    int l=0,r=size-1,mid;
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
int BinarySearch(int x[],int size,int t)
{
    int l=0,r=size-1,mid;
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
void solve()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int i=1;
        int count=1;
        while(i<=n)
        {
            int j=1;
            count=i;
            while(j<=i)
            {
                cout<<count<<" ";
                count++;
                j++;
            }
            cout<<"\n";
            i++;
        }
        cout<<"\n"; 
    }
}
int main() 
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	//Pre-Computtion
	solve();
	return 0;
}