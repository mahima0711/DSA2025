class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> y.value - x.value);

        Pair a_pair = new Pair(a, 'a');
        Pair b_pair = new Pair(b, 'b');
        Pair c_pair = new Pair(c, 'c');

        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair maxEle = pq.poll();

            int count = maxEle.value;
            char cc = maxEle.ch;

            if (ans.length() >= 2 && (ans.charAt(ans.length() - 1) == cc && ans.charAt(ans.length() - 2) == cc)) {
                if (pq.isEmpty()) {
                    break;
                } else {
                    Pair secondMaxEle = pq.poll();

                    int sCount = secondMaxEle.value;
                    char sC = secondMaxEle.ch;

                    ans.append(sC);

                    sCount--;

                    if (sCount > 0) {
                        pq.add(new Pair(sCount, sC));
                    }
                }
            } else {
                ans.append(cc);
                count--;
            }

            if (count > 0) {
                pq.add(new Pair(count, cc));
            }
        }

        return ans.toString();

    }
}

class Pair {

    int value;
    char ch;

    Pair(int value, char ch) {
        this.ch = ch;
        this.value = value;
    }
}