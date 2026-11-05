class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else if (src.equals(dst)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double product, Set<String> visited) {
        visited.add(curr);

        if (curr.equals(target)) {
            return product;
        }
        Map<String, Double> neighbors = graph.get(curr);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            double weight = entry.getValue();

            if (!visited.contains(next)) {
                double ans = dfs(graph, next, target, product * weight, visited);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }

        return -1.0;
    }
}