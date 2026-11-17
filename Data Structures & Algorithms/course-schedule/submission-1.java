class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> map = new HashMap<>();
        for(int[] prereq: prerequisites){
            int val = prereq[0];
            int neighbor = prereq[1];
            if(!map.containsKey(val)){
                map.put(val, new Node(val, new ArrayList<>()));
            }
            if(!map.containsKey(neighbor)){
                map.put(neighbor, new Node(neighbor, new ArrayList<>()));
            }
            map.get(val).neighbors.add(map.get(neighbor));
        }
        HashSet<Node> safe = new HashSet<>();
        HashSet<Node> seen = new HashSet<>();
        for(Node n: map.values()){
            boolean cycle = dfs(n, seen, safe);
            if(!cycle){
                return false;
            }
        }
        return true;
        
    }
    
    public boolean dfs(Node n, HashSet<Node> seen, HashSet<Node> safe) {
        if (seen.contains(n)) {
            return false;
        }

        if(safe.contains(n)){
            return true;
        }

        seen.add(n);

        for (Node neighbor : n.neighbors) {
            if (!dfs(neighbor, seen, safe)) {
                return false;
            }
        }

        seen.remove(n);
        safe.add(n);
        return true;
    }

}

class Node{
    int value;
    List<Node> neighbors;

    Node(int value, List<Node> neighbors){
        this.value = value;
        this.neighbors = neighbors;
    }
}
