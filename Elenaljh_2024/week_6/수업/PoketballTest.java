package 수업;

import java.util.Scanner;

//목표: 내 공을 가+나 방향으로 d만큼 보내기
public class PoketballTest {
    static double r = 5.73/2;

    static class Location {
        public double x, y;
        public Location(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Location myBall = new Location(sc.nextInt(), sc.nextInt());
        Location hole = new Location(sc.nextInt(), sc.nextInt());
        Location target = new Location(sc.nextInt(), sc.nextInt());

        double a = length(myBall, hole); //myball과 hole 사이 거리 (a)
        double b = length(hole, target); //hole과 target 사이 거리
        double c = length(myBall, target); //myball과 target 사이 거리
        double x = Math.abs(hole.x-myBall.x);
        double y = Math.abs(hole.y-myBall.y);
        System.out.println("a: " + a + " b: " + b + " c: " + c + " x: " + x + " y: " + y);

        double distance = getDistance(a, b, c); //공을 보낼 길이
        double direction = getDirection(x, y, a, b, distance); //공을 보낼 방향

        System.out.printf("공을 각도 %.2f도 방향으로 %.2f만큼 보내라", direction, distance);
    }

    //두 좌표 사이 거리 구하는 함수
    static double length(Location l1, Location l2) {
        double x1 = l1.x; double x2 = l2.x;
        double y1 = l1.y; double y2 = l2.y;
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    // d 구하기
    static double getDistance(double a, double b, double c) {
        double aSquare = Math.pow(a, 2);
        double bSquare = Math.pow(b, 2);
        double cSquare = Math.pow(c, 2);
        System.out.println((aSquare + bSquare - cSquare)/(2*a*b));
        double theta = Math.acos((aSquare + bSquare - cSquare)/(2*a*b));
        System.out.println("각도 다(라디안): " + theta);

        double a1 = Math.cos(theta) * (b+2*r);
        double b1 = Math.sin(theta) * (b+2*r);
        System.out.println("길이 d: " + (Math.sqrt(Math.pow(b1, 2) + Math.pow(a-a1, 2))));
        return Math.sqrt(Math.pow(b1, 2) + Math.pow(a-a1, 2));
    }

    // 각도(방향) 구하기 - 단위: degrees
    static double getDirection(double x, double y, double a, double b, double d) {
        //가 구하기
        double theta1 = Math.atan(x/y);
        System.out.println("각도 가(라디안): " + theta1);

        //나 구하기
        double aSquare = Math.pow(a, 2);
        double dSquare = Math.pow(d, 2);
        double theta2 = Math.acos((aSquare+dSquare-Math.pow(b+2*r, 2))/(2*a*d));
        System.out.println("각도 나(라디안): " + theta2);
        System.out.println("각도 가+나(degrees): " + (Math.toDegrees(theta1) + Math.toDegrees(theta2)));
        return Math.toDegrees(theta1) + Math.toDegrees(theta2);
    }


}
