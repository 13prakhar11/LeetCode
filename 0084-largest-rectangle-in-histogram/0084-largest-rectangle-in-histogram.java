class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int [] nse=findNSE(heights);
        int [] psee = findPSEE(heights);
        int m=0;
        for (int i=0;i<n;i++){
            int w=nse[i]-psee[i] -1;
            int a=w*heights[i];

            m=Math.max(m,a);
        }
        return m;
    }
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return res;
    }

    public int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }
}