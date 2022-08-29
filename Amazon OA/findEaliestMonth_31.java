
// 股票stock[]切一刀，切在哪里时左半边Avg和右半边Avg的差值最小，注意数组0-index，返回月份要+1

// https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=49829dd06006467996df67eb68603ea9&pm=s

// Idea: prefix sum
public class Main {
    public static int findEaliestMonth(int[] stockPrices) {
        int n = stockPrices.length;
        long[] prefixSum = new long[n];
        prefixSum[0] =  stockPrices[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + stockPrices[i];
        }
        long minDif = Integer.MAX_VALUE;
        int monthIdx = -1;
        for(int i = 0; i< n-1; i++){
            long leftAvg = prefixSum[i]/(long)(i+1);
            long rightAvg = (prefixSum[n-1]-prefixSum[i])/(long)(n-i-1);
            long curDif = Math.abs(leftAvg - rightAvg);
            if(minDif > curDif){
                minDif = curDif;
                monthIdx = i;
            }  
        }
        return monthIdx +1;
    }
    
    public static void main(String[] args) {
        
        System.out.println(findEaliestMonth(new int[] {1,3, 2, 3})); 
        System.out.println(findEaliestMonth(new int[] {1,3, 2, 4,5})); 
        System.out.println(findEaliestMonth(new int[] {1,1, 1, 1,1,1})); 
    }
}
