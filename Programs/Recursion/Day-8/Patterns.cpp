//Recursive program for Rotated Binary Search.
#include <iostream>
using namespace std;
void pattern1(int r, int c)
{
    // * * *
    // * *
    // *
    if(r == c)
    {
        cout<<endl;
        pattern1(r-1, 0);
    }
    if(r == 0 || c >= r) 
        return;
    else{
        cout<<"* ";
        pattern1(r,c+1);
    }
}
int main() {
    int n;
    cin>>n;
    pattern1(n, 0);
    return 0;
}
