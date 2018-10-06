class Solution {
    public static void main(String[] args) {
       
        String[] content = {
                "1, 28, 300.6, San Francisco",
                "4, 5, 209.1, San Francisco",
                "20, 7, 203.4, Oakland",
                "6, 8, 202.9, San Francisco",
                "6, 10, 199.8, San Francisco",
                "1, 16, 190.5, San Francisco",
                "6, 29, 185.3, San Francisco",
                "7, 20, 180.0, Oakland",
                "6, 21, 162.2, San Francisco",
                "2, 18, 161.7, San Jose",
                "2, 30, 149.8, San Jose",
                "3, 76, 146.7, San Francisco",
                "2, 14, 141.8, San Jose"
        };

        String[] result = paginateHostListings(5, content);
    }

    public static String[] paginateHostListings(int n, String[] content) {
        //Tracks current hosts in a single page
		Set<String> hostPage = new HashSet<>();
        
        ArrayList<String> input = new ArrayList<>(Arrays.asList(content));
        List<String> result = new ArrayList<>();

        int inputSize = content.length;
		int inputIndex = 0;
		int itemsInOnePage = 0;
	    while(input.size() > 0) {
    		//Check if the current Page is filled already
			if(itemsInOnePage == inputSize) {
				itemsInOnePage = 0;
				inputIndex = 0; //Reset the index of the input list. Start traversal from the beginning
                hostPage.clear();
			}    
				
			//Check if inputIndex has reached the end of the list
			int size = input.size();
			if(inputIndex + 1 >= size) {
				//Reset the listIndex
				inputIndex = 0; 
                hostPage.clear();
			}	   
			String[] item = input.get(inputIndex).split(",");
			String hostId = item[0];
			
			//Check if hostId is already present in the current list
			if(hostPage.contains(hostId)) {
				inputIndex++;
			} else {
				result.add(input.get(inputIndex));
				input.remove(inputIndex);
				hostPage.add(hostId);
				itemsInOnePage++;
			}	
        }
        for(String s: result)
            System.out.println(s);
        return result.stream().toArray(String[]::new);
    }

    //Optimized implementation using LinkedList-
    public static String[] paginateHostListings_v2(int n, String[] content) {
        //Tracks current hosts in a single page
		Set<String> hostPage = new HashSet<>();
        
        LinkedList<String> input = new LinkedList<>(Arrays.asList(content));
        List<String> result = new ArrayList<>();

        int inputSize = content.length;
		int itemsInOnePage = 0;
        
	    while(input.size() > 0) {
            //Create a new iterator
            Iterator<String> iter = input.iterator();
           
            while(iter.hasNext()) {
                //Check if the current Page is filled already
                if(itemsInOnePage == inputSize) {
                    itemsInOnePage = 0;
                    break; //Start traversal from the beginning by creating new iterator.
                }      
                
                String e = iter.next();
                String[] item = e.split(",");
                String hostId = item[0];

                //Check if hostId is already present in the current list
                if(hostPage.contains(hostId)) {
                    continue;
                } else {
                    result.add(e);
                    iter.remove();
                    hostPage.add(hostId);
                    itemsInOnePage++;
                }	
            }
            hostPage.clear(); 
        }
        for(String s: result)
            System.out.println(s);
        return result.stream().toArray(String[]::new);
    }
}
   
