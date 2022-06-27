//Reverse a number.
#include<iostream>
using namespace std;
void reverse(int n)
{
    //Exit condition reverse(0) = 0.
    if(n == 0)
        return ;
    //Eg 198
    //prints 8 and calls reverse(19)
    cout<<(n % 10)<<" ";
    reverse((n / 10));
}
int main()
{
    int n;
    cout<<"Enter n: ";
    cin>>n;
    reverse(n);
    return 0;
}
