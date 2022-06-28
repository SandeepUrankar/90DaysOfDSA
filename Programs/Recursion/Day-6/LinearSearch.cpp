//Recursive program to peform linear search.
#include <iostream>
using namespace std;
int linearSearch(int arr[], int n, int key, int i)
{
    //if i is equals to n. That is last index. Then return -1.
    if(i == n)
    {
        return -1;
    }
    //If arr[i] is equals to key. Return the index. That is i.
    if(arr[i] == key)
    {
        return i;
    }
    //Perform linear search on remaining part of the array.
    return linearSearch(arr, n, key , i + 1);
}
int main() {
    int n;
    cout<<"Enter n: ";
    cin>>n;
    int arr[n];
    for(int i=0; i<n; i++)
        cin>>arr[i];
    int key;
    cout<<"Enter key to search: ";
    cin>>key;
    int result = linearSearch(arr, n, key, 0);
    if(result == -1)
        cout<<"Key not found"<<endl;
    else
        cout<<"Key is at index "<<result<<endl;
    return 0;
}
