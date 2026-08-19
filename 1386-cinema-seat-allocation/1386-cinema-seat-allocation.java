class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(seat);
        }

        int ans = 0;

        //If none of the seats in the row is reserved
        int unreservedRows = n - map.size();
        ans += unreservedRows * 2;

        for (int k: map.keySet()) {
            HashSet <Integer> s = map.get(k);
            //Both blocks are unreserved
            if ((!s.contains(2) && !s.contains(3) && !s.contains(4) && !s.contains(5)) && (!s.contains(6) && !s.contains(7) && !s.contains(8) && !s.contains(9))) {
                ans += 2;
            }

            //Any one block is unreserved: either left or right
            else if ((!s.contains(2) && !s.contains(3) && !s.contains(4) && !s.contains(5)) || (!s.contains(6) && !s.contains(7) && !s.contains(8) && !s.contains(9))) {
                ans += 1;
            }

            //Only middle part is unreserved
            else if (!s.contains(4) && !s.contains(5) && !s.contains(6) && !s.contains(7)) {
                ans += 1;
            }
        }
        return ans;
    }
}