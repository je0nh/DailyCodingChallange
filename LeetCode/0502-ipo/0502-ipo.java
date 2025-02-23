/**
 * k : 실행할 수 있는 프로젝트
 * w : 초기 자본
 * profits : 수익
 * capital : 사업에 필요한 자본
 */
class Solution {
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            Project project = new Project(capital[i], profits[i]);
            projects.add(project);
        }

        // lambda 식에서 값이 음수일 경우 prev를 앞에 next를 뒤에, 양수일 경우 next를 앞에 prev를 뒤에
        Collections.sort(projects, (prev, next) -> prev.capital - next.capital);

        // lambda 식에서 값이 음수일 경우 next 앞에 prev를 뒤에, 양수일 경우 prev를 앞에 next를 뒤에
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((prev, next) -> next - prev);

        int i = 0;
        for (int j = 0; j < k; j++) {
            // 가지고 있는 자본보다 같거나 작은 프로젝트의 수익을 우선순위 큐에 넣어줌 -> 수익이 큰 순서대로 정렬됨
            while (i < profits.length && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
}