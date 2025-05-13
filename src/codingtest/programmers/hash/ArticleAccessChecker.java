package codingtest.programmers;

import java.util.*;

public class ArticleAccessChecker {
    public int[] solution(String[] category, String[] relation, String[] member, String[] article) {
        // 1. 트리 구조 구성
        Map<String, List<String>> tree = new HashMap<>();
        for (String c : category) tree.put(c, new ArrayList<>());
        for (String r : relation) {
            String[] parts = r.split(" ");
            tree.get(parts[0]).add(parts[1]);
        }

        // 2. 각 카테고리의 하위 카테고리 포함한 전체 접근 가능 카테고리 구성
        Map<String, Set<String>> allDescendants = new HashMap<>();
        for (String c : category) {
            Set<String> set = new HashSet<>();
            dfs(c, tree, set);
            set.add(c);
            allDescendants.put(c, set);
        }

        // 3. 각 멤버의 접근 가능한 카테고리 집합
        Map<String, Set<String>> memberAccess = new HashMap<>();
        for (String m : member) {
            String[] parts = m.split(" ");
            String name = parts[0];
            String accessRoot = parts[1];
            memberAccess.put(name, allDescendants.get(accessRoot));
        }

        // 4. 기사별 접근 가능한 멤버 수 계산
        int[] result = new int[article.length];
        for (int i = 0; i < article.length; i++) {
            String[] articleCategories = article[i].split(" ");
            int count = 0;
            for (Map.Entry<String, Set<String>> entry : memberAccess.entrySet()) {
                Set<String> access = entry.getValue();
                boolean canRead = true;
                for (String cat : articleCategories) {
                    if (!access.contains(cat)) {
                        canRead = false;
                        break;
                    }

