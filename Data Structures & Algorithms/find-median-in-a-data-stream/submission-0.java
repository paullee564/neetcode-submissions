class MedianFinder {
    ArrayList<Integer> list;
    int count;
    public MedianFinder() {
        list = new ArrayList<>();
        count = 0;
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
        count++;
    }
    
    public double findMedian() {
        if(count % 2 == 1){
            return list.get(count/2);
        }
        else{
            return (list.get(count/2) + list.get(count/2 - 1)) / 2.0;
        }
    }
}
