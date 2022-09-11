import com.sun.jdi.DoubleValue;

import java.util.*;

public class Java1 {

    /**
     * Первое задание под вариантом 29 (номер по писку 4, номер группы 191):
     * Даны вещественное число а и натуральное число n.
     * Вычислить: Р = а(а+1)...(а+n+-1)
     */
    private static void First (double a, int n){
        double p = 1;
        for (int i = 0; i<= n-1; i++){
            p = p*(a+i);
        }
        System.out.print(p);
    }
    /**
     * Второе задание под вариантом 54 (номер по писку 4, номер группы 191):
     * Вычислить сумму: 1+1/2+1/3+...+1/n
     */
    private static void Second (int n){
        double r = 0;
        for (int i = 1; i<=n; i++){
            r += 1.0/i;
        }
        System.out.print(r);
    }
    /**
     * Третье задание под вариантом 79 (номер по писку 4, номер группы 191):
     * Вычислить приближённую площадь фигуры, образованной кривой у=0,3(х-1)^2+4, осью абсцисс и двумя прямыми -
     * у = 1 и у = 3.
     * Первый метод ниже комментария- функция кривой, второй метод ниже комментария - непосредственно расчет площади.
     */
    private static double function_for_third(double x){
        double f = 0.3*(Math.pow((x-1.0),2.0))+4.0;
        return f;
    }
    private static void Third(double x){
        int y1 = 1;
        int y2 = 3;
        double l = 0.001;
        double sq = 0;
        double h,m;
        while (x <= y2){
            m = (function_for_third(x) + function_for_third(x - l)) / 2.0;
            h = l;
            sq = sq + m * h;
            x = x+1;
        }
        System.out.print(sq);
    }
    /**
     * Четвертое задание под вариантом 104 (номер по писку 4, номер группы 191):
     * В области К районов. Известны количество жителей (в тыс. человек) и плостность населения (тыс. чел/км2) каждого района.
     * Определить самый густонаселённый район области.
     */
    private static void Fourth(int k, int [] people, int [] plotnost){
        double [] res = new double[k];
        OptionalInt max = Arrays.stream(plotnost).max();
        for (int i = 0; i < k; i++){
            if (plotnost[i] == max.getAsInt())
                System.out.println("District number " + i + " with population " + people[i] + " thousand people" + " and with population density " + plotnost[i] + " thousand people/km2");
        }
    }
    /**
     * Пятое задание под вариантом 129 (номер по писку 4, номер группы 191):
     * Проверить, существует ли четырехзначное натуральное число, сумма пятых степеней цифр которого равна самому числу.
     */
    private static void Fifth() {
        var fff = false;
        int n3, d;
        for (int i = 1000; i < 10000; i++) {
            n3 = i;
            int j = 0;
            int s = 0;
            while (j < 4) {
                d = n3 % 10;
                s += Math.pow(d, 5);
                j += 1;
                n3 /= 10;
            }

            if (s == i) {
                fff = true;
                System.out.println("YES! The number is " + i);
            }
        }
        if (!fff)
            System.out.println("The number from the task does not exist.");
    }

    public static void main (String[] args){
        System.out.println("TASK 29");
        double a = (double) (Math.random());
        int n = 1 + (int) (Math.random()*10);
        System.out.println("A Real Number A = " + a);
        System.out.println("A Natural Number N = " + n);
        System.out.println("The result: ");
        First(a,n);

        System.out.println("\n\nTASK 54");
        int n2 = 3 + (int) (Math.random()*10);
        System.out.println("A Natural Number N = " + n2);
        System.out.println("The result: ");
        Second(n2);

        System.out.println("\n\nTASK 79");
        double x = (Math.random());
        System.out.println("The X = " + x);
        System.out.println("The Figure Square is: ");
        //double x = 1.001;
        Third(x);

        System.out.println("\n\nTASK 104");
        int k = (int) (Math.random()*20);
        int [] people = new int[k];
        int [] plotnost = new int[k];
        for (int i = 0; i < k; i++){
            people[i] = 100 + (int) (Math.random()*30);
            plotnost[i] = 10 + (int)(Math.random()*30);
        }
        System.out.println("Number K of districts: " + k);
        System.out.println("The Population of each district (thousands people):");
        System.out.println(Arrays.toString(people));
        System.out.println("Population Density of each district (thousand people/km2):");
        System.out.println(Arrays.toString(plotnost));
        System.out.println("The most densely populated district:");
        Fourth(k,people,plotnost);

        System.out.println("\n\nTASK 129");
        System.out.println("Does the numbber from the task exist?");
        Fifth();
    }
}
