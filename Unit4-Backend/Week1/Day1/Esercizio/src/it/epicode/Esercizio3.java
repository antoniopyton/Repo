package it.epicode;

public class Esercizio3 {

    public static void main(String[] args) {
        double perimetro =  perimetroRettangolo(4, 7);
        System.out.println(perimetro);
        byte b = pariDispari(5);
        System.out.println(b);
        double area = areaTriangolo(4,6,8);
        System.out.println(area);
    }

    public static double perimetroRettangolo(double base, double altezza) {
        return base*2+altezza*2;
    }

    public static byte pariDispari (int x) {
        if (x%2==0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static double areaTriangolo(double c1, double c2, double c3) {
        double p = (c1 + c2 + c3)/2;
        double area = Math.sqrt(p*(p-c1)*(p-c2)*(p-c3));
        return area;
    }

}
