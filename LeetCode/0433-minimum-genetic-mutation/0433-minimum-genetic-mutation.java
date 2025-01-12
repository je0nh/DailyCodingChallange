class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String[]> q = new LinkedList<>();
        // Stinrg[] -> {유전자, 변환 횟수}
        q.add(new String[]{startGene, "0"});
        List<String> visited = new ArrayList<>();

        while(!q.isEmpty()) {
            String[] tmp = q.poll();
            String gene = tmp[0];
            int count = Integer.parseInt(tmp[1]);

            if (gene.equals(endGene)) return count;
            
            for (String b : bank) {
                // 한번에 유전자가 두개 이상 변할 수 없음
                // 만약 같은 변이가 두번 이상 일어난다면 계속 반복하게 됨으로 endGene이 될 수 없음
                if (checkGene(gene, b) && !visited.contains(b)) {
                    q.add(new String[]{b, Integer.toString(count + 1)});
                    visited.add(b);
                }
            }
        }
        return -1;
    }

    private boolean checkGene(String start, String target) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (start.charAt(i) != target.charAt(i)) count++;
        }

        if (count == 1) return true;
        return false;
    }
}