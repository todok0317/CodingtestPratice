package codingtest.programmers;

public class WallpaperCleaner {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }

    public static void main(String[] args) {
        WallpaperCleaner solver = new WallpaperCleaner();

        String[] wallpaper1 = {
            ".........",
            "...#.....",
            "....##...",
            "........."
        };

        int[] result = solver.solution(wallpaper1);
        for (int r : result) {
            System.out.print(r + " ");
        }
        // 출력 예시: 1 3 3 5
    }
}

