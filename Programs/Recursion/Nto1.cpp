// Example program prints n to 1.
#include <iostream>
#include <string>
using namespace std;
void fun(int n)
{
    //Exit condition.
    if(n==0)
        return;
    cout<<n<<" ";
    fun(n-1);
}
int main()
{
    fun(5);
    return 0;
}
