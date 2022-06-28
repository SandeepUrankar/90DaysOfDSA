// Find whether an array is Sorted array
#include <iostream>
using namespace std;
bool sorted(int arr[], int i, int n)
{
    if(i == n - 1)
        return true;
    if(arr[i] < arr[i + 1] && sorted(arr, i + 1, n))
        return true;
    return false;
}
int main() {
    //int arr[] = {9, 2,3,4,5,6};
    int n;
    cout<<"Enter n: ";
    cin>>n;
    int arr[n];
    for(int i=0; i < n; i++)
        cin>>arr[i];
    if(sorted(arr, 0, n))
        cout<<"Array is sorted"<<endl;
    else
        cout<<"Array is not sorted"<<endl;
    return 0;
}
