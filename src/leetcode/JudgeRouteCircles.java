package leetcode;

public class JudgeRouteCircles {
    public boolean judgeCircle(String moves) {
        Position p = new Position();
        for(char c: moves.toCharArray()) {
            switch(c) {
                case 'U':
                    p.x --;
                    break;
                case 'D':
                    p.x ++;
                    break;
                case 'L':
                    p.y--;
                    break;
                case 'R':
                    p.y ++;
                    break;
            }
        }
        return p.x == 0 && p.y == 0;
    }

    class Position {
        private int x;
        private int y;

    }
}
