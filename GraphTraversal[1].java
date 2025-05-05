import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        Map<Integer, String> v = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] p = s.nextLine().split(":");
            int k = Integer.parseInt(p[0].trim());
            String name = p[1].trim();
            v.put(k, name);
        }
        int M = Integer.parseInt(s.nextLine());
        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, Integer> inD = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] e = s.nextLine().split(":");
            int f = Integer.parseInt(e[0].trim());
            int t = Integer.parseInt(e[1].trim());

            g.computeIfAbsent(f, k -> new ArrayList<>()).add(t);
            inD.put(t, inD.getOrDefault(t, 0) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int k : v.keySet()) {
            if (!inD.containsKey(k)) {
                q.offer(k);
            }
        }
        Set<Integer> visit = new HashSet<>();
        List<String> r = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                if (visit.contains(n)) continue;
                visit.add(n);
                r.add(v.get(n));
                cl.add(n);
            }
            for (int node : cl) {
                List<Integer> childs = g.getOrDefault(node, new ArrayList<>());
                for (int ch : childs) {
                    inD.put(ch, inD.get(ch) - 1);
                    if (inD.get(ch) == 0) {
                        q.offer(ch);
                    }
                }
            }
        }
        for (String Name : r) {
            System.out.println(Name);
        }
        System.out.println(r.size());
        s.close();
    }
}