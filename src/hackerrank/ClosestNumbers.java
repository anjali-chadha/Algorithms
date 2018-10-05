    // Complete the closestNumbers function below.
    static void closestNumbers(List<Integer> numbers) {
        if(numbers == null || numbers.size() <= 1) return;
        
        Collections.sort(numbers);
        int n = numbers.size();
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n-1; i++) {
            //System.out.println("hi");
            int a = numbers.get(i+1), b = numbers.get(i);;
            int diff =  a - b;
            if(min >= diff) {
                min = diff;
                if(!map.containsKey(diff)){
                    List<Integer> l = new ArrayList<>();
                     map.put(diff, l);
                }
                map.get(diff).add(b);
                map.get(diff).add(a);
            }
        }
        
        //Print
        List<Integer> result = map.get(min);

        for(int i = 0; i <= result.size() - 2; i+=2) {
           System.out.println(result.get(i) + " " + result.get(i+1));    
        }
    }

