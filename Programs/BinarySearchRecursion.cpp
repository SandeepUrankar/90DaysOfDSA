// Program for binary search using recursion.
#include <iostream>
#include <string>
using namespace std;
int num[] = {5,6,7,8};
int mid;
int bs(int start, int end, int key)
{
    if(start > end)
        return -1;
    mid = (start + (end - start)) / 2;
    if(num[mid] == key)
        return mid;
    else if(key > num[mid])
        return bs(mid+1, end, key);
    else if(key < num[mid])
        return bs(start, mid - 1, key);
}
int main()
{
    int ans = bs(0,3,2);
    cout<<"5 is at "<<ans;
}

