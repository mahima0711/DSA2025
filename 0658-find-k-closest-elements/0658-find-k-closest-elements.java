class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int i = findFloor(arr, x);
        int j = i + 1;
        List<Integer> list = new ArrayList<>();

        while (k > 0 && i >= 0 && j < arr.length) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                list.add(arr[i]);
                i--;
            } else {
                list.add(arr[j]);
                j++;
            }
            k--;
        }

        while (k > 0 && i >= 0) {
            list.add(arr[i]);
            i--;

            k--;
        }

        while (k > 0 && j < arr.length) {
            list.add(arr[j]);
            j++;
            k--;
        }

        Collections.sort(list);

        return list;

    }

    public int findFloor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}