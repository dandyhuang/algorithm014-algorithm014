class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> resList = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticketList : tickets) {
            String ticket1 = ticketList.get(0);
            String ticket2 = ticketList.get(1);
            PriorityQueue<String> pq = new PriorityQueue<>();
            if (!map.containsKey(ticket1)) {
                map.put(ticket1, pq);
            } else {
                pq = map.get(ticket1);
            }
            pq.add(ticket2);
        }

        dfsItinerary("JFK", map, resList);
        Collections.reverse(resList);
        return resList;
    }

    private void dfsItinerary(String start, Map<String, PriorityQueue<String>> map, List<String> resList) {
        Queue<String> q = map.get(start);
        while (q!=null && !q.isEmpty()) {
            String ticket = q.poll();
            dfsItinerary(ticket, map, resList);
        }

        resList.add(start);
    }
}