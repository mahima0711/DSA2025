class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxTriplet = new int[3];
        boolean ans = false;

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                maxTriplet[0] = Math.max(maxTriplet[0], triplet[0]);
                maxTriplet[1] = Math.max(maxTriplet[1], triplet[1]);
                maxTriplet[2] = Math.max(maxTriplet[2], triplet[2]);
            }
        }

        if (maxTriplet[0] == target[0] && maxTriplet[1] == target[1] && maxTriplet[2] == target[2]) {
            ans = true;
        }
        return ans;
    }
}