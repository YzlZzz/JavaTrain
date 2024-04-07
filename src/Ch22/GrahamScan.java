package Ch22;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GrahamScan{
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

        points.add(new Point(1,1));
        points.add(new Point(4,4));
        points.add(new Point(3,3));
        points.add(new Point(2,2));
        points.add(new Point(3,1));
        points.add(new Point(3,0));
        points.add(new Point(0,0));

        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0,0));
        points1.add(new Point(1,0));
        points1.add(new Point(1,1));
        points1.add(new Point(0,1));

        Stack<Point> a = graham(points);
        System.out.println(a);
    }

    public static Stack<Point> graham (List<Point> points){
        points.sort(new PointComparator());

        Stack<Point> result = new Stack<>();

        result.push(points.get(0));
        result.push(points.get(1));
        result.push(points.get(2));

        //当i到n时，反过来遍历
        int sig = 0;

        int i = 3;
        while(result.peek().x == points.get(0).x && result.peek().y == points.get(0).y){


            if(result.size() < 2) {
                result.push(points.get(i));
                i++;
            }
           Point t1 = result.pop();
            Point t2 = result.pop();

            result.push(t2);
            result.push(t1);

            if(crossProduct(t2, t1, points.get(i)) <= 0){
                result.push(points.get(i));
                if(sig == 0) i++;
                else i--;
            }
            else {
                result.pop();

            }

            if(i == points.size()) {
                sig = -1;
                i--;
            }
        }
        return result;
    }

    public static int crossProduct(Point p1, Point p2, Point p3){
        return (p2.x - p1.x) * (p3.y - p1 .y) - (p2.y - p1.y) * (p3.x - p1.x);
    }



    public static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            if(a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        }
    }
}



