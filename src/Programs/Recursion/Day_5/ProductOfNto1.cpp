//Product of n to 1 (Factorial)
#include<iostream>
using namespace std;
int fact(int n)
{
    //Exit condition fact(1) = 1.
    if(n == 1)
        return 1;
    return n * fact(n-1);
}
int main()
{
    int n;
    cout<<"Enter n: ";
    cin>>n;
    cout<<fact(n);
    return 0;
}
