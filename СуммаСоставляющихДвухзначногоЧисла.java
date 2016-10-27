
public class СуммаСоставляющихДвухзначногоЧисла {
    public static void main(String[] args) {
        int a = 45; //вводим здесь двухзначное число
        System.out.println ("Вы задали число "+a+", а сумма его составных будет "+ ((a%10)+((a/10)%10)));
    }
}
