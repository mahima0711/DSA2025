class Solution {
    public int largestInteger(int num) {

        char[] arr = Integer.toString(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] - '0') % 2 == (arr[j] - '0') % 2) {
                    if ((arr[k]) < (arr[j])) {
                        k = j;
                    }
                }
            }

            if (k != i) {
                char temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }

        }

        return Integer.parseInt(new String(arr));
    }
}