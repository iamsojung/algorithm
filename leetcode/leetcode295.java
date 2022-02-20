class MedianFinder {
    private Queue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> bigger = new PriorityQueue<>();

    public void addNum(int num) {
        bigger.offer(num);
        smaller.offer(bigger.poll());

        if(smaller.size() - bigger.size() > 1) {
            bigger.offer(smaller.poll());
        }
    }

    public double findMedian() {
        return (smaller.size() - bigger.size() > 0) ?
                smaller.peek() : ((double)(smaller.peek() + bigger.peek()))/ 2;
    }
}
