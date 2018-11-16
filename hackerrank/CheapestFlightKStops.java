// You are given a huge list of airline ticket prices between different cities around the world on a given day. These are all direct flights(no connections).

// Each element in list is of the format : [source_city, destination, price].

// We have a user who is willing to take *up to* K connections from his origin city Paris to destination city Tokyo. Find the cheapest fare we can for his journey and print the itinerary for that journey. Travel time is not a constraint here.

// [
//   [ "Paris", "London", "150" ],
//   [ "Paris", "Istanbul", "1100" ],
//   [ "Paris", "Dubai", "400" ],
//   [ "London", "Tokyo", "1000" ],
//   [ "Istanbul", "Dubai", "200" ],
//   [ "Dubai", "Tokyo", "200" ],
//   [ "Beijing", "Shanghai", "50" ],
//   [ "Shanghai", "Beijing", "55" ],
//   [ "London", "Beijing", "300" ],
//   [ "Beijing", "Tokyo", "120" ],
//   [ "Shanghai", "Tokyo", "65" ]
// ]

// From Paris to Tokyo with up to 4 connection => [565, ["Paris -> London", "London -> Beijing", "Beijing -> Shanghai", "Shanghai -> Tokyo"]]



/*
Src, Dest, K stops


*/
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public int findCheapestFlights(String src, String dst, int k, List<List<String>> input) {
    if(input == null ||input.size() == 0) return 0;
    
    
    //Build the graph
    Map<String, CityFlight> graph = new HashMap<>();
    
    for(List<String> flight: input) {
      String fromCity = flight.get(0);
      String toCity = flight.get(1);
      int price = Integer.parseInt(flight.get(2));
      if(!graph.containsKey(fromCity)) graph.put(fromCity, new CityFlight(fromCity));
      if(!graph.containsKey(toCity)) graph.put(toCity, new CityFlight(toCity));
      graph.get(fromCity).neighbours.put(toCity, price);
    }
    
    
    //Perform BFS
    Queue<String> bfsQ = new LinkedList<>();
    Queue<Integer> minCostQ = new LinkedList<>(); 
    bfsQ.offer(src);
    minCostQ.offer(0); //cost 0 to start from src
    
    boolean isPathAvailable = false;
    int stops = -1;
    while(!bfsQ.isEmpty()) {
      stops++;
      if(stops > k + 1) {
       //Stop here
        break;
        
      }
    
      for(int i = 0; i < bfsQ.size(); i++) {
        CityFlight currCity = graph.get(bfsQ.poll());
        int currCost = minCostQ.poll();
        currCity.minCost = Math.min(currCity.minCost, currCost);
        
        if(currCity.city.equals(dst)) {
            isPathAvailable = true;
            continue; 
        }
        
        for(String neighbour: currCity.neighbours.keySet()) {
          int nextPrice = currCost + currCity.neighbours.get(neighbour);
          if(nextPrice < graph.get(neighbour).minCost &&
             (stops < k || stops == k && neighbour.equals(dst))) {
                bfsQ.offer(neighbour);
                minCostQ.offer(nextPrice);   
            }
        } 
      }
    }
    return isPathAvailable? graph.get(dst).minCost: -1;
  }
  
  
  class CityFlight {
   private String city;
   private int minCost;
   private Map<String, Integer> neighbours;
    CityFlight(String city) {
      this.city = city;
      minCost = Integer.MAX_VALUE;
      this.neighbours = new HashMap<>();
    }
    
  }
//   [ "Paris", "London", "150" ],
//   [ "Paris", "Istanbul", "1100" ],
//   [ "Paris", "Dubai", "400" ],
//   [ "London", "Tokyo", "1000" ],
//   [ "Istanbul", "Dubai", "200" ],
//   [ "Dubai", "Tokyo", "200" ],
//   [ "Beijing", "Shanghai", "50" ],
//   [ "Shanghai", "Beijing", "55" ],
//   [ "London", "Beijing", "300" ],
//   [ "Beijing", "Tokyo", "120" ],
//   [ "Shanghai", "Tokyo", "65" ]  
  public static void main(String[] args) {
    Solution cheapFlights = new Solution();
    String src = "Paris";
    String dst = "Tokyo";
    List<List<String>> input = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    list1.add("Paris"); list1.add("London");list1.add("150");
    
    List<String> list2 = new ArrayList<>();
    list2.add("Paris"); list2.add("Istanbul");list2.add("1100");
    
    List<String> list3 = new ArrayList<>();
    list3.add("Paris"); list3.add("Dubai");list3.add("400");
    
    List<String> list4 = new ArrayList<>();
    list4.add("London"); list4.add("Tokyo");list4.add("1000");
    
    
    List<String> list5 = new ArrayList<>();
    list5.add("Istanbul"); list5.add("Dubai");list5.add("200");
    
      List<String> list11 = new ArrayList<>();
    list11.add("Dubai"); list11.add("Tokyo");list11.add("200");
   //   [ "Beijing", "Shanghai", "50" ],
//   [ "Shanghai", "Beijing", "55" ],
//   [ "London", "Beijing", "300" ],
//   [ "Beijing", "Tokyo", "120" ],
//   [ "Shanghai", "Tokyo", "65" ]   
        
    List<String> list6 = new ArrayList<>();
    list6.add("Beijing"); list6.add("Shanghai");list6.add("50");
    
        
    List<String> list7 = new ArrayList<>();
    list7.add("Shanghai"); list7.add("Beijing");list7.add("55");
    
        
    List<String> list8 = new ArrayList<>();
    list8.add("London"); list8.add("Beijing");list8.add("300");
    
        
    List<String> list9 = new ArrayList<>();
    list9.add("Beijing"); list9.add("Tokyo");list9.add("120");
    
     List<String> list10 = new ArrayList<>();
    list10.add("Shanghai"); list10.add("Tokyo");list10.add("65");
    
    input.add(list1);
    input.add(list2);
    input.add(list3);//input.add(list1);
    input.add(list4);
    input.add(list5);
    input.add(list6);
    input.add(list7);
    input.add(list8);
    input.add(list9);
    input.add(list10);
    input.add(list11);
    System.out.println(cheapFlights.findCheapestFlights(src, dst,  4,input));
}
  
}
