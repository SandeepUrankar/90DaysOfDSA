//Check a Palindrome.
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
bool palindrome(int n)
{
    reverse(n);
    if(n == sum)
        return true;
    return false;
}
int main()
{
    int n;
    cout<<"Enter n: ";
    cin>>n;
    if(palindrome(n))
        cout<<"Number is palindrome."<<endl;
    else
        cout<<"Number is not a palindrome."<<endl;
    return 0;
}
