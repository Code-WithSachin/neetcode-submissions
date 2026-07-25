class Solution {
    public void reverseString(char[] arr) {
        // swap first & last element 
        
        int n = arr.length;
        int i = 0, j = n-1;
        
        while(i<j) 
        {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        } 
    }
}