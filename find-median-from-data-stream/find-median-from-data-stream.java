// LeetCode: Find Median from Data Stream (find-median-from-data-stream)
// Submission ID: 1718120275
// Language: java
// Timestamp (UTC): 2025-07-31T09:11:42Z

class MedianFinder {
    // Max-heap for the lower half
    private PriorityQueue<Integer> lowers;
    // Min-heap for the upper half
    private PriorityQueue<Integer> highers;

    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to one of the heaps
        if (lowers.isEmpty() || num <= lowers.peek()) {
            lowers.offer(num);
        } else {
            highers.offer(num);
        }
        // Rebalance so that sizes differ at most by 1
        if (lowers.size() - highers.size() > 1) {
            highers.offer(lowers.poll());
        } else if (highers.size() - lowers.size() > 1) {
            lowers.offer(highers.poll());
        }
    }

    public double findMedian() {
        if (lowers.size() == highers.size()) {
            if (lowers.isEmpty()) {
                return 0.0;
            }
            return (lowers.peek() + highers.peek()) / 2.0;
        } else if (lowers.size() > highers.size()) {
            return lowers.peek();
        } else {
            return highers.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
