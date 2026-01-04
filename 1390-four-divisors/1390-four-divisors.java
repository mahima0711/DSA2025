class Solution {
    public int sumFourDivisors(int[] nums) {

        int totalSum = 0;

        for (int n : nums) {

            int count = 0;
            int sum = 0;

            // Check divisors only till sqrt(n)
            for (int d = 1; d * d <= n; d++) {

                if (n % d == 0) {
                    int d1 = d;
                    int d2 = n / d;

                    // count d
                    count++;
                    sum += d1;

                    // count paired divisor if different
                    if (d1 != d2) {
                        count++;
                        sum += d2;
                    }

                    // Early exit if more than 4 divisors
                    if (count > 4)
                        break;
                }
            }

            // Only add sum if exactly 4 divisors
            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}