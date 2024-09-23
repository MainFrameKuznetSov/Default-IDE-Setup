#include <bits/stdc++.h>
#define ll long long
#define ull unsigned long long
#define MOD 1000000007
#define pb push_back
#define F first
#define S second
#define all(v) (v).begin(),(v).end()
#define rall(v) (v).rbegin(),(v).rend()
#define itrep(mp) for(auto iter:mp)
#define rep(i,n) for(int i=0;i<n;++i)
#define rrep(i,n) for(int i=n;i>=0;--i)
#define lloop(i,a,b) for(int i=a;i<=b;++i)
#define jloop(i,a,b,k) for(int i=a;i<=b;i+=k)
#define nlloop(i,a,b) for(int i=a;i>=b;--i)
#define njloop(i,a,b,k) for(int i=a;i>=b;i-=k)
#define vi vector<int>
#define vll vector<long long>
#define vpii vector<pair<int,int>>
#define vsi vector<set<int>>
#define vvi vector<vi>
#define vb vector<bool>
#define umii unordered_map<int,int>
using namespace std;
int BinarySearch(vi x,int t)
{
    /*
        For descending order,
            replace r & l
    */
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
vi seive(int n)
{
    vb check(n+1,true);
    check[0]=check[1]=false;
    for(int p=2;p*p<=n;++p) 
    {
        if(check[p]) 
        {
            jloop(i,p*p,n,p)
                check[i]=false;
        }   
    }
    vi prime;
    lloop(i,2,n)
    {
        if(check[i])
            prime.pb(i);
    }
    return prime;
}
ll exp(int a,int b)
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
ll selfPower(ll x,ll y,ll p) 
{ 
    ll res=1;
    x=x%p;   
    if(x==0) 
        return 0;
    while(y>0) 
    { 
        if(y&1) 
            res=(res*x)%p; 
        y=y>>1;
        x=(x*x)%p; 
    } 
    return res; 
}
void solve(int t,ifstream &file,ofstream &outfile)
{
    //Your Code starts here
    ll n,k;
    file>>n>>k;
    vll v(n);
    ll mn=INT_MAX;
    rep(i,n)
    {
        file>>v[i];
	mn=min(mn,v[i]);
    }
    //sort(all(v));
    ll sum=mn*(2*n-3);
    if(n==1)
        sum=v[0];
    //cout<<sum<<"\n";
    outfile<<"Case #"<<t<<": "<<(sum<=k?"YES\n":"NO\n");
}
int main() 
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	ifstream file("walk_the_line_input.txt");
	if(!file)
	{
	    cerr<<"Error opening file!\n";
	    return 1;
	}
	ofstream outfile("output.txt");
	if(!outfile)
	{
	    cerr<<"Error opening file!\n";
	    return 1;
	}
	int t;
	file>>t;
	for(int i=1;i<=t;++i)
	    solve(i,file,outfile);
	return 0;
}
