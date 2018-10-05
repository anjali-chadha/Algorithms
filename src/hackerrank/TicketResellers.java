class Result {

    /*
     * Complete the 'maximumAmount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. LONG_INTEGER k
     */

    public static long maximumAmount(List<Integer> a, long k) {
    // Write your code here
        if(k == 0 || a == null || a.size() == 0) return 0;
        
        long result = 0;
        Collections.sort(a, Collections.reverseOrder());
        int maxTicketsWithReseller = a.get(0);
        int[] ticketCount = new int[maxTicketsWithReseller + 1];
        for(int i: a) {
            ticketCount[i]++;
        }
        //System.out.println(a);
        for(int i = ticketCount.length-1; i > 0; i--) {
            if(ticketCount[i] > 0 && k > 0) {
                long maxCount = Math.min(k, ticketCount[i]);
                result += i * maxCount;
                k -= maxCount;
                ticketCount[i-1] += maxCount;
            }
            if(k == 0) return result;
        }
        return result;
    }

}

