import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static final String[] POSITIVE_ANSWER = {"YES","Y","ДА","Д","+"};

    public static final String[] NEGATIVE_ANSSWER = {"NO","N","НЕТ","Н","-"};

    public static boolean getAnswer(String question) {
        while (true) {
            System.out.println(question);
            Scanner in = new Scanner(System.in);
            String answer = in.nextLine();
            if (Stream.of(POSITIVE_ANSWER).anyMatch(answer::equalsIgnoreCase)) {
                return true;
            }
            if (Stream.of(NEGATIVE_ANSSWER).anyMatch(answer::equalsIgnoreCase)) {
                return false;
            }
            System.out.println("Отвечайте только да или нет");
        }
    }
    
    public static void main(String[] args) {

        if (getAnswer("Двигатель не заводится?")) {
            if (getAnswer("Искра есть?")) {
                if (getAnswer("Неисправна система питания\nБензин есть?")) {
                    if(getAnswer("Бензин в карбюратор поступает?")) {
                        System.out.println("Неисправность в карбюраторе");
                        return;
                    }
                    System.out.println("Неисправность в бензонасосе");
                    return;
                }
                System.out.println("Необходимо заправиться");
                return;
            }
            if (getAnswer("Неисправна система зажигания\nЦепь низкого напряжения функционирует?")) {
                System.out.println("Неисправность в катушке зажигания");
                return;
            }
            if(getAnswer("Замена комутатора устраняет неисправность?")) {
                System.out.println("Неисправность в коммутаторе");
                return;
            }
            System.out.println("Неисправность в датчике распределителе");
            return;
        }
        System.out.println("Машина исправна можно ехать");

    }
}
