//Runtime 22ms, Memory 47.9 MB

class StockSpanner {
    
    List<Integer> prices;
    List<Integer> historySpan;

    public StockSpanner() {
        prices = new ArrayList<Integer>();
        historySpan = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        int yesterday = prices.size() > 0 ? prices.get(prices.size() - 1) : 0;
        if(yesterday > price || prices.size() == 0) {
            prices.add(price);
            historySpan.add(1);
            return 1;
        }
        
        int jumpBack = historySpan.get(historySpan.size() - 1);
        
        while(jumpBack < prices.size()) {
            int landed = prices.get(prices.size() - 1 - jumpBack);
            if(landed <= price) {
                jumpBack += historySpan.get(historySpan.size() - 1 - jumpBack);
            }
            else {
                break;
            }
        }
        
        prices.add(price);
        historySpan.add(jumpBack + 1);
        
        return jumpBack + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */