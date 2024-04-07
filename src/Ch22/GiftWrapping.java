package Ch22;

import java.awt.Point;
import java.util.*;

public class GiftWrapping {
    public static void main(String[] args) {
        Point[] points1 = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        };

        Point[] points2 = {
                new Point(1, 0),
                new Point(3, 0),
                new Point(0, 1),
                new Point(2, 3),
                new Point(4, 2)
        };

        Point[] points3 = {
                new Point(0, 1),
                new Point(1, 0),
                new Point(2, 1),
                new Point(1, 2)
        };

        Point[] points4 = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 3),
                new Point(0, 4),
                new Point(1, 4),
                new Point(2, 4),
                new Point(3, 4),
                new Point(4, 4),
                new Point(4, 3),
                new Point(4, 2),
                new Point(4, 1),
                new Point(4, 0),
                new Point(3, 0),
                new Point(2, 0),
                new Point(1, 0)
        };

        Point[] points5 = {
                new Point(0, 3),
                new Point(1, 2),
                new Point(3, 2),
                new Point(4, 3),
                new Point(3, 4),
                new Point(1, 4)
        };


        System.out.println(outerTrees(points5));
    }
    public static List<Point> outerTrees(Point[] points){
        Set<Point> result = new LinkedHashSet<>();

        Point first = points[0];
        int firstIndex = 0;
        for(int i = 0; i < points.length; i++){
            if(points[i].x < first.x){
                first = points[i];
                firstIndex = i;
            }
        }

        result.add(first);

        Point cur = first;
        int curIndex = firstIndex;

        do{
            Point next = points[0];
            int nextIndex = 0;

            for(int i = 0; i < points.length; i++){
                if(i == curIndex) continue;
                int cross = crossProduct(cur, next, points[i]);

                if(cur == next || cross > 0){
                    next = points[i];
                    nextIndex = i;
                } else if (cross == 0 && distanceCheck(cur, next, points[i]) > 0){
                    next = points[i];
                    nextIndex = i;
                }
            }

            result.add(next);
            cur = next;
            curIndex = nextIndex;

        }while(curIndex != firstIndex);

        return new ArrayList<>(result);

    }

    private static int crossProduct(Point curPoint, Point nextPoint, Point checkPoint){

        int v1x = nextPoint.x - curPoint.x;
        int v1y = nextPoint.y - curPoint.y;
        int v2x = checkPoint.x - curPoint.x;
        int v2y = checkPoint.y - curPoint.y;

        return v1x * v2y - v1y * v2x;
    }

    private static int distanceCheck(Point curPoint, Point nextPoint, Point checkPoint){
        int x1 = curPoint.x - nextPoint.x;
        int y1 = curPoint.y - nextPoint.y;
        int x2 = curPoint.x - checkPoint.x;
        int y2 = curPoint.y - checkPoint.y;

        return Integer.compare(x1 * x1 + y1 * y1, x2 * x2 + y2 * y2);
    }

}
