#include<iostream>
using namespace std;
void bubbleSort(int arr[], int r, int c)
{
    if(r == 0)
    {
        return;
    }
    if(c < r){
        if(arr[c] > arr[c+1])
        {
            int temp = arr[c];
            arr[c] = arr[c+1];
            arr[c+1] = temp;
        }
        bubbleSort(arr,r,c+1);
    }
    else{
        bubbleSort(arr, r-1, 0);   
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
    bubbleSort(arr, n -1, 0);
    for(int i=0; i<n; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    return 0;
}
