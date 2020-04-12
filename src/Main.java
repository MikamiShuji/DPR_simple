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

        if (getAnswer("Авторизован ли пользователь?")) {
            if (getAnswer("Есть ли в наличии химикат?")) {
                if (getAnswer("Относится ли химикат к опасным?")) {
                    if(getAnswer("Прошёл ли пользователь\nсоответствующую подготовку?")) {
                        System.out.println("Принять запрос");
                        return;
                    } else {
                        System.out.println("Отклонить запрос");
                        return;
                    }
                } else {
                    System.out.println("Принять запрос");
                    return;
                }
            } else {
                System.out.println("Отклонить запрос");
                return;
            }
        } else {
            System.out.println("Отклонить запрос");
            return;
        }

    }
}
