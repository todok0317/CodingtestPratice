package codingtest.programmers.hash;

import java.util.*;

public class ArticleAccessChecker {

    static Map<String, List<String>> tree = new HashMap<>();
    static Map<String, Set<String>> memberAccessMap = new HashMap<>();

    public static void main(String[] args) {
        String[] category = {"a", "b", "c", "d", "e"};
        String[] relation = {"a b", "b c", "c d", "c e"};
        String[] member = {"A a", "B b", "C c", "D d", "E e"};
        String[] article = {"a", "a b", "c", "c d", "c e"};

        int[] result = solution(category, relation, member, article);
        System.out.println(Arrays.toString(result));  // [1, 2, 3, 4, 4]
    }

    public static int[] solution(String[] category, String[] relation, String[] member, String[] article) {
        // 1. 트리 구성
        for (String c : category) {
            tree.put(c, new ArrayList<>());
        }
        for (String r : relation) {
            String[] parts = r.split(" ");
            String parent = parts[0];
            String child = parts[1];
            tree.get(parent).add(child);
        }

        // 2. 각 멤버의 접근 가능한 카테고리 구하기
        for (String m : member) {
            String[] parts = m.split(" ");
            String memberName = parts[0];
            String startCategory = parts[1];
            Set<String> accessible = new HashSet<>();
            dfs(startCategory, accessible);
            memberAccessMap.put(memberName, accessible);
        }

        // 3. 기사별 접근 가능한 멤버 수 계산
        int[] result = new int[article.length];
        for (int i = 0; i < article.length; i++) {
            String[] neededCategories = article[i].split(" ");
            int count = 0;
            for (String m : memberAccessMap.keySet()) {
                Set<String> accessible = memberAccessMap.get(m);
                boolean canAccess = true;
                for (String need : neededCategories) {
                    if (!accessible.contains(need)) {
                        canAccess = false;
                        break;
                    }
                }
                if (canAccess) count++;
            }
            result[i] = count;
        }

        return result;
    }

    // DFS로 하위 카테고리 탐색
    public static void dfs(String current, Set<String> visited) {
        visited.add(current);
        for (String child : tree.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(child)) {
                dfs(child, visited);
            }
        }
    }
}
