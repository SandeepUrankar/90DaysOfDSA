//Sum of digits.
#include<iostream>
using namespace std;
int sumOfDigits(int n)
{
    //Exit condition sumOfDigits(0) = 0.
    if(n == 0)
        return 0;
    // Eg 22 -
    // return 2 + sumOfDigits(2);
    return (n % 10) + sumOfDigits((n / 10));
}
int main()
{
    int n;
    cout<<"Enter n: ";
    cin>>n;
    cout<<sumOfDigits(n);
    return 0;
}
