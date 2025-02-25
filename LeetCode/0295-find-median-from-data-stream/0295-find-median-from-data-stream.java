class MedianFinder {
    // 반보다 큰값
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 반보다 작은값
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((prev, next) -> next - prev);
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */