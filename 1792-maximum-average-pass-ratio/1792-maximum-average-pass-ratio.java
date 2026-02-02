class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double gain = gain(c[0], c[1]);
            pq.add(new double[] { gain, c[0], c[1] });
        }

        while (extraStudents-- > 0) {

            double[] cur = pq.poll();
            double pass = cur[1];
            double total = cur[2];

            pass++;
            total++;

            pq.add(new double[] {
                    gain((int) pass, (int) total),
                    pass,
                    total
            });
        }

        double sum = 0;

        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            sum += c[1] / c[2];
        }

        return sum / classes.length;
    }

    public double gain(double a, double b) {
        return (double) (a + 1) / (b + 1) - (double) a / b;
    }
}