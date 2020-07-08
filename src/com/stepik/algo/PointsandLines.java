import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PointsandLines implements Comparable<PointsandLines> {
    private int a;
    private int b;

    public PointsandLines(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointsandLines that = (PointsandLines) o;

        if (a != that.a) return false;
        return b == that.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    @Override
    public int compareTo(PointsandLines pointsandLines) {
        if (pointsandLines.a > this.a) return -1;
        else if (pointsandLines.a < this.a) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "PointsandLines{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    private static int runLeft(int i, List<PointsandLines> list) { // Points point
        int l = 0;
        int r = list.size();
        while (l <= r) {
            int m = (l + r) / 2;
            if (m >= list.size()) return list.size() - 1;
            else if (m < 0) return -1;
            // else if (l == 0 && r == 0) {

            // if (list.get(m).a > i) return -1;


            // else return m;
            // }
            if (list.get(m).a == i) {
                if ((m + 1) < list.size()) {
                    if (list.get(m + 1).a == i) {
                        l = m + 1;
                    } else return m;
                } else return m;

            } else if (list.get(m).a > i) {
                r = m - 1;
            } else l = m + 1;
            if (r < 0) return -1;
        }
        return (r + l) / 2;
    }

    private static int runRight(int i, List<PointsandLines> list) { // Points point
        int l = 0;
        int r = list.size();
        while (l <= r) {
            int m = (l + r) / 2;
//            if (l == r) return m;
            if (m >= list.size()) return list.size() - 1;
            else if (m < 0) return -1;

            if (list.get(m).b >= i) {
                r = m - 1;

            } else l = m + 1;
            if (r < 0) return -1;
        }

        return (l + r) / 2;
    }

    private static void Test() {
        Random random = new Random();
        List<PointsandLines> listLines = new ArrayList<>();
        List<Points> listPoints = new ArrayList<>();
        for (int o = 0; o < 3; o++) {


            for (int i = 0; i < 5; i++) {
                int a = random.nextInt(10);
                int b = random.nextInt(10 - a) + a;
                listLines.add(new PointsandLines(a, b));
                listPoints.add(new Points(i, random.nextInt(10)));
            }
            listLines.sort(Comparator.comparingInt(x -> x.a));

            List<PointsandLines> listLinesR = new ArrayList<>(listLines);
            listLinesR.sort(Comparator.comparingInt(x -> x.b));

            int left;
            int right;
            for (Points point : listPoints) {
                left = runLeft(point.coord, listLines) + 1;
                right = runRight(point.coord, listLinesR) + 1;
                point.linesNumber = left - right;
            }
            List<Points> points = new ArrayList<>(listPoints);
            points.sort(Comparator.comparingInt(x -> x.coord));
            int k = 0;
            nextPoint:
            for (int i = 0; i < points.size(); i++) {


                for (int j = k; j < listLines.size(); j++) {


                    if (points.get(i).coord >= listLines.get(j).a && points.get(i).coord <= listLines.get(j).b) {
                        points.get(i).linesNumber++;
                    } else {
                        if ((i + 1) < points.size() && points.get(i + 1).coord > points.get(i).coord) {
                            k = j;
                            continue nextPoint;
                        } else {
                            continue nextPoint;
                        }
                    }
                }
            }
            points.sort(Comparator.comparingInt(x -> x.place));
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i).coord == listPoints.get(i).coord) {
                    System.out.println("TRUE");

                } else {
                    System.out.println("ОСТОРОЖНО, ЗАЛУПА!!!!!");
                    for (PointsandLines listLine : listLines) {
                        System.out.print(listLine.toString() + "         ");

                    }
                    System.out.println();
                    for (int j = 0; j < points.size(); j++) {
                        System.out.print(points.get(j).coord + "       " + listPoints.get(j).coord);
                    }
                }
            }


        }
    }

    public static void main(String[] args) throws IOException {


        List<PointsandLines> listLines = new ArrayList<>();
        List<Points> listPoints = new ArrayList<>();
        int n, m;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputLine1 = reader.readLine().split(" ");
            n = Integer.parseInt(inputLine1[0]);
            m = Integer.parseInt(inputLine1[1]);
            for (int i = 0; i < n; i++) {
                String[] inputLineN = reader.readLine().split(" ");
                listLines.add(new PointsandLines(Integer.parseInt(inputLineN[0]), Integer.parseInt(inputLineN[1])));
            }

            String[] inputLineM = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                listPoints.add(new Points(i, Integer.parseInt(inputLineM[i])));
            }
        }
        listLines.sort(Comparator.comparingInt(x -> x.a));
//            listPoints.sort(Comparator.comparingInt(x -> x.coord));
        List<PointsandLines> listLinesR = new ArrayList<>(listLines);
        listLinesR.sort(Comparator.comparingInt(x -> x.b));

        int left;
        int right;
        for (Points point : listPoints) {
            left = runLeft(point.coord, listLines) + 1;
            right = runRight(point.coord, listLinesR) + 1;
            point.linesNumber = left - right;
        }


//        for (Points P: listPoints
//             ) {
//            for (PointsandLines listLine : listLines) {
//                if (listLine.a <= P.coord) left++;
//            }
//            for (PointsandLines pointsandLines : listLinesR) {
//                if (pointsandLines.b < P.coord) right++;
//            }
//            P.linesNumber = left - right;
//            left = 0;
//            right = 0;
//        }

//        int k = 0;
//        nextPoint:
//        for (int i = 0; i < listPoints.size(); i++) {
//
//
//            for (int j = k; j < listLines.size(); j++) {
//
//
//                if (listPoints.get(i).coord >= listLines.get(j).a && listPoints.get(i).coord <= listLines.get(j).b) {
//                    listPoints.get(i).linesNumber++;
//                } else {
//                    if ((i + 1) < listPoints.size() && listPoints.get(i + 1).coord > listPoints.get(i).coord) {
//                        k = j;
//                        continue nextPoint;
//                    }
//                    else {
//                        continue nextPoint;
//                    }
//                    }
//                }
//            }
        //listPoints.sort(Comparator.comparingInt(x ->x.place));
        for (Points P : listPoints
        ) {
            System.out.print(P.linesNumber + " ");
        }

    }

    static class Points implements Comparable<Points> {
        private int place;
        private int coord;
        private int linesNumber;

        public Points(int place, int coord) {
            this.place = place;
            this.coord = coord;
        }

        public int getLinesNumber() {
            return linesNumber;
        }

        public void setLinesNumber(int linesNumber) {
            this.linesNumber = linesNumber;
        }

        public int getPlace() {
            return place;
        }

        public void setPlace(int place) {
            this.place = place;
        }

        public int getCoord() {
            return coord;
        }

        public void setCoord(int coord) {
            this.coord = coord;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Points points = (Points) o;

            if (place != points.place) return false;
            return coord == points.coord;
        }

        @Override
        public int hashCode() {
            int result = place;
            result = 31 * result + coord;
            return result;
        }

        @Override
        public int compareTo(Points points) {
            if (this.coord < points.coord) return -1;
            else if (this.coord > points.coord) return 1;
            return 0;
        }
    }

}



