//Reverse a number.
#include<iostream>
using namespace std;
int sum = 0;
void reverse(int n)
{
    //Exit condition reverse(0) = 0.
    if(n == 0)
        return ;
    //Eg 198
    // 0 + 8
    // 80 + 9
    // 890 + 1
    sum = (sum * 10) + (n % 10);
    reverse(n / 10);
}
int main()
{
    int n;
    cout<<"Enter n: ";
    cin>>n;
    reverse(n);
    cout<<sum;
    return 0;
}
