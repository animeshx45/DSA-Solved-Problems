import java.util.Stack;  // Importing Stack class from java.util package

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;                  // Get the length of the input array
        Stack<Integer> st = new Stack<Integer>(); // Create a stack to store elements
        int [] arr = new int[n];              // Result array to store next greater elements

        // Push all elements once to handle the circular nature of the array
        for(int i = n-1; i>=0; i--){
            st.push(nums[i]);                 // Push elements into stack
        }

        // Traverse the array from right to left
        for(int i = n-1; i>=0; i--){
            // Pop elements from stack that are smaller or equal to current element
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            // If stack is empty, no greater element exists
            if(st.isEmpty()){
                arr[i]= -1;
            }
            // Otherwise, the top of stack is the next greater element
            else{
                arr[i]=st.peek();
            }
            // Push current element back to stack for future comparisons
            st.push(nums[i]);
        }
        return arr;   // Return the result array
    }
}