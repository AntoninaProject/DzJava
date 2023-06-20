import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Dz2 {
    private static Scanner scaner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(Dz2.class.getName());
    private static SimpleFormatter simple_formatter = new SimpleFormatter();

    public static void main(String[] args) {
        try {
            FileHandler fileH = new FileHandler("Dz2_log.log");
            fileH.setFormatter(simple_formatter);
            logger.addHandler(fileH);
            // task1();
            // task2();
            // task3();
            // task4();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }





    // 1) Дана строка sql-запроса "select * from students WHERE ".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    // Данные для фильтрации приведены ниже в виде json-строки:
    // (Если значение null, то параметр не должен попадать в запрос)

    // String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"

    // вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
    // если все значения null - то оставить просто строку "select * from students"
    public static void task1() {
        String query = "select * from students WHERE ";
        String obj = "{\"name\":\"Ivanov\",\"thname\":\"null\",\"surname\":\"Ivan\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":20}";

        StringBuilder querysb = new StringBuilder(query);
        querysb.append(jsonToSQL(obj));
        System.out.println(querysb.toString());
    }

    private static StringBuilder jsonToSQL(String obj){
        obj = obj.replaceAll("[{}]", "");
        StringBuilder objsb = new StringBuilder();
        String[] fields = obj.split(",");
        for (String field : fields) {
            if (field != null) {
                String[] k_v = field.split(":");
                if (k_v.length == 2 && k_v[0] != null && k_v[1] != null && !k_v[1].equals("\"null\"")) {
                    objsb.append(k_v[0].replaceAll("\"", ""))
                         .append("=")
                         .append(k_v[1])
                         .append(" AND ");
                }
            }
        }
        if (objsb.toString().endsWith(" AND ")) {
            objsb.delete(objsb.length() - 5, objsb.length());
        }
        return objsb;
    }





    // 2) Реализуйте алгоритм сортировки пузырьком числового массива,
    // результат после каждой итерации запишите в лог-файл.
    public static void task2() {
        int[] arr = {5, 2, 6, 8, 3, 4, 1, 6, 0};

        logger.info(Arrays.toString(arr) + " исходное состояние\n");
        // сортировка пузырьком
        int tmp;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            logger.info(Arrays.toString(arr) + " итерация " + j + "\n");
        }
    }



 // 3) Дана строка (сохранить в файл и читать из файла):

    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

    // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    // Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.
    public static void task3() {
        int i;
        String[] word = {"\u0421\u0442\u0443\u0434\u0435\u043D\u0442", " \u043F\u043E\u043B\u0443\u0447\u0438\u043B", " \u043F\u043E \u043F\u0440\u0435\u0434\u043C\u0435\u0442\u0443"};
        StringBuilder strbld = new StringBuilder();
        try {
            String[] objs = FileReader("task3.data", StandardCharsets.UTF_8).replace("[", "")
                                                                                 .replace("]", "")
                                                                                 .split("},");
            for (String obj : objs) {
                String[] fields = obj.replaceAll("[{}\"]", "").split(",");
                i = 0;
                for (String field : fields) {
                    strbld.append(word[i]);
                    i++;
                    strbld.append(" " + field.split(":")[1]);
                }
                System.out.println(strbld.toString());
                strbld.delete(0, strbld.length());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String FileReader(String path, Charset encoding) throws IOException {
        File file = new File(path);
        InputStream inStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];

        int offset = 0;
        while (offset < bytes.length) {
            int result = inStream.read(bytes, offset, bytes.length - offset);
            if (result == -1) {
                break;
            }
            offset += result;
        }
        inStream.close();
        return new String(bytes, encoding);
    }





    // 4) К калькулятору из предыдущего ДЗ добавить логирование.
    // 4+2=6
    // 6-1=5
    public static void task4() {
        StringBuilder strbld = new StringBuilder();

        System.out.print("Введите первое число: ");
        String str_a = scaner.nextLine();
        double a = Double.parseDouble(str_a);

        System.out.print("Введите оператор: ");
        String op = scaner.nextLine();

        System.out.print("Введите второе число: ");
        String str_b = scaner.nextLine();
        double b = Double.parseDouble(str_b);

        double res = 0;

        strbld.append(str_a)
              .append(op)
              .append(str_b)
              .append("=");

        if (op.equals("+")) {
            res = a + b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("-")) {
            res = a - b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("*")) {
            res = a * b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("/")) {
            res = a / b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else {
            logger.log(Level.WARNING, "unsupported operator " + op);
        }
        strbld.delete(0, strbld.length());
    }
}