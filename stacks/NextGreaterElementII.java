
// Next Greater Element II - Stack-based solution
import java.util.Stack;

class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		Stack<Integer> st = new Stack<Integer>();
		int[] arr = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			st.push(nums[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= nums[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				arr[i] = -1;
			} else {
				arr[i] = st.peek();
			}
			st.push(nums[i]);
		}
		return arr;
	}
}

