//Recursive program for Rotated Binary Search.
#include <iostream>
using namespace std;
int rotatedBinarySearch(int arr[],int start, int end, int key)
{
    if(start > end)
        return -1;
    int mid = start + (end - start) / 2;
    if(key == arr[mid])
        return mid;
    if(arr[start] < arr[mid])
    {
        if(key < arr[mid] && key > arr[start]) 
        {
            return rotatedBinarySearch(arr, start, mid -1, key);
        }
        else
        {
            return rotatedBinarySearch(arr, mid + 1, end, key);
        }
    }
    if(key > arr[mid] && key <= arr[end])
    {
        return rotatedBinarySearch(arr, mid + 1, end, key);
    }
    else
        return rotatedBinarySearch(arr, start, mid -1, key);
    
    return 0;
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
    int result = rotatedBinarySearch(arr, 0, n -1, key);
    if(result == -1)
        cout<<"Key not found"<<endl;
    else
        cout<<"Key is at index "<<result<<endl;
    return 0;
}
