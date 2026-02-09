class Pair {

    int freq;
    char c;

    Pair(int freq, char c) {
        this.freq = freq;
        this.c = c;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }

        int[] free = new int[26];

        for (int i = 0; i < free.length; i++) {
            free[i] = 1;
        }

        int count = 0;

        while (!pq.isEmpty()) {
            count++;
            boolean executed = false;
            Queue<Pair> queue = new LinkedList<>();

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int val = p.freq;
                char c = p.c;

                if (free[c - 'A'] <= count) {
                    val--;
                    free[c - 'A'] = count + n + 1;
                    if (val > 0) {
                        queue.offer(new Pair(val, c));
                    }
                    executed = true;
                    break;
                } else {
                    queue.offer(p);
                }
            }

            while (!queue.isEmpty()) {
                pq.add(queue.poll());
            }
            if (!executed) {
                continue;
            }
        }

        return count;
    }
}