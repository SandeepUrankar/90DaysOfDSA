// Program for binary search using recursion.
#include <iostream>
#include <string>
using namespace std;
int num[] = {5,6,7,8};
int mid;
int bs(int start, int end, int key)
{
    //If the key not found return -1.
    if(start > end)
        return -1;
    //Compute mid.
    mid = (start + (end - start)) / 2;
    //Key found at mid.
    if(num[mid] == key)
        return mid;
    //Key is in the right sub array.
    if(key > num[mid])
        return bs(mid + 1, end, key);
    //Key is in the left sub array.
    else
        return bs(start, mid - 1, key);
}
int main()
{
    int ans = bs(0,3,8);
    if(ans == -1)
        cout<<"Key not found"<<endl;
    else
        cout<<"5 is at "<<ans<<endl;
    return 0;
}

