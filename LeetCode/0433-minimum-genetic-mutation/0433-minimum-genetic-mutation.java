class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{startGene, "0"});
        boolean[] visited = new boolean[bank.length];

        while (!q.isEmpty()) {
            String[] a = q.poll();
            String gene = a[0];
            int count = Integer.parseInt(a[1]);

            if (gene.equals(endGene)) return count;

            for (int i = 0; i < bank.length; i++) {
                if (checkGene(gene, bank[i]) && !visited[i]) {
                    String[] next = new String[]{bank[i], String.valueOf(count + 1)};
                    q.add(next);
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    private boolean checkGene(String target, String mutate) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (target.charAt(i) != mutate.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}