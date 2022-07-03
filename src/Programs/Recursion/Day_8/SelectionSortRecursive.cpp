#include<iostream>
using namespace std;
void selectionSort(int arr[], int r, int c, int max)
{
    if(r == 0)
    {
        return;
    }
    if(c < r){
        if(arr[c] > arr[max])
            selectionSort(arr,r,c+1, c);
        else
            selectionSort(arr,r,c+1, max);
    }
    else{
        int temp = arr[max];
        arr[max] = arr[r - 1];
        arr[r - 1] = temp;
        selectionSort(arr, r-1, 0, 0);   
    }
}
int main() {
    int n;
    cout<<"Enter n: ";
    cin>>n;
    int arr[n];
    for(int i=0; i<n; i++)
        cin>>arr[i];
    for(int i=0; i<n; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    selectionSort(arr, n, 0, 0);
    for(int i=0; i<n; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    return 0;
}
