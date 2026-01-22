class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if (maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }

        if (maxHeap.size() == minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);

                maxHeap.add(minHeap.poll());
            }else
            {
                maxHeap.add(num);
            }
        } else {
            maxHeap.add(num);

            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */