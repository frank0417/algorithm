import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    /*
     * 题 目：模拟行走机器人
     * 链 接: https://leetcode-cn.com/problems/walking-robot-simulation/
     * 描 述：机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }


    public static int robotSimII(int[] commands, int[][] obstacles) {
        HashSet<Pair<Integer, Integer>> obstaclesHashSet = new HashSet<>();
        for (int[] t : obstacles) {
            obstaclesHashSet.add(new Pair<>(t[0], t[1]));
        }
        int x = 0, y = 0, maxDistance = 0, heading = 0;
        for (int command : commands) {
            if (command < 0) {
                heading = getHeading(heading, command);
            } else {
                movement:
                for (int i = 0; i < command; i++) {
                    switch (heading) {
                        case 0:
                            if (isPathBlocked(x, y + 1, obstaclesHashSet)) {
                                break movement;
                            } else {
                                y++;
                            }
                            break;
                        case 1:
                            if (isPathBlocked(x + 1, y, obstaclesHashSet)) {
                                break movement;
                            } else {
                                x++;
                            }
                            break;
                        case 2:
                            if (isPathBlocked(x, y - 1, obstaclesHashSet)) {
                                break movement;
                            } else {
                                y--;
                            }
                            break;
                        case 3:
                            if (isPathBlocked(x - 1, y, obstaclesHashSet)) {
                                break movement;
                            } else {
                                x--;
                            }
                            break;
                    }
                }
                maxDistance = Math.max(calculateDistance(x, y), maxDistance);
            }
        }
        return maxDistance;
    }

    private static int calculateDistance(int x, int y) {
        return (x * x) + (y * y);
    }

    private static boolean isPathBlocked(int x, int y, HashSet<Pair<Integer, Integer>> obstacles) {
        return obstacles.contains(new Pair<Integer, Integer>(x, y));
    }

    private static int getHeading(int heading, int command) {
        if (command == -2) {
            switch (heading) {
                case 0://North
                    return 3;
                case 1://East
                    return 0;
                case 2://South
                    return 1;
                case 3://West
                    return 2;
            }
        } else {
            switch (heading) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 0;
            }
        }
        return heading;
    }

    private static class Pair<T, T1> {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
