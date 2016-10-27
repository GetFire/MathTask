
public class ОкруглениеЧисла {
    public static void main(String[] args) {
        double a;
        a = 4.5; // тут вводим любое вещественное число
    double n = a -(int)a;
        System.out.print(a+ " округляем и получается - ");
        if (n>=0.5){
a++;   }
else a = (int) a;
System.out.print((int)a);
}
}