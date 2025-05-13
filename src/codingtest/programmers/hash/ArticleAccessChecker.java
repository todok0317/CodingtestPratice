package codingtest.programmers.hash;

import java.util.*;

public class ArticleAccessChecker {

    public static void main(String[] args) {
        String[] category = {"a", "b", "c", "d", "e"};
        String[] relation = {"a b", "b c", "c d", "c e"};
        String[] member = {"A a", "B b", "C c", "D d", "E e"};
        String[] article = {"a", "a b", "c", "c d", "c e"};

        int[] result = solution(category, relation, member, article);
        System.out.println(Arrays.toString(result));  // [1, 2, 3, 4, 4]
    }

    public static int[] solution(String[] category, String[] relation, String[] member, String[] article) {
        // 1. 카테고리 관계 트리 구성: 부모 → 자식 카테고리 리스트
        Map<String, List<String>> tree = new HashMap<>();
        for (String rel : relation) {
            String[] parts = rel.split(" ");
            String parent = parts[0];
            String child = parts[1];
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        // 2. 각 카테고리의 모든 하위 카테고리들 구하기
        Map<String, Set<String>> categoryToAllDescendants = new HashMap<>();
        for (String cat : category) {
            Set<String> reachable = new HashSet<>();
            dfs(cat, tree, reachable);
            reachable.add(cat); // 자기 자신 포함
            categoryToAllDescendants.put(cat, reachable);
        }

        // 3. 각 멤버가 접근할 수 있는 카테고리들 구하기
        Map<String, Set<String>> memberAccess = new HashMap<>();
        for (String m : member) {
            String[] parts = m.split(" ");
            String memberName = parts[0];       // 멤버 이름
            String rootCategory = parts[1];     // 멤버가 속한 카테고리
            Set<String> accessSet = categoryToAllDescendants.get(rootCategory);
            memberAccess.put(memberName, new HashSet<>(accessSet));  // 복사본 저장
        }

        // 4. 각 기사에 대해 접근할 수 있는 멤버 수 계산
        int[] answer = new int[article.length];
        for (int i = 0; i < article.length; i++) {
            String[] neededCategories = article[i].split(" ");
            int count = 0;

            for (String memberName : memberAccess.keySet()) {
                Set<String> accessSet = memberAccess.get(memberName);
                boolean canAccess = true;

                // 기사에 필요한 모든 카테고리를 멤버가 접근할 수 있는지 확인
                for (String cat : neededCategories) {
                    if (!accessSet.contains(cat)) {
                        canAccess = false;
                        break;
                    }
                }

                if (canAccess) count++;
            }

            answer[i] = count;
        }

        return answer;
    }

    // DFS로 각 카테고리의 하위 카테고리를 모두 구하기
    private static void dfs(String current, Map<String, List<String>> tree, Set<String> visited) {
        if (!tree.containsKey(current)) return;

        for (String child : tree.get(current)) {
            if (visited.add(child)) {
                dfs(child, tree, visited);
            }
        }
    }
}
