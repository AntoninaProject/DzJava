package Dz6;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class seminar6 {
    static int id = 1;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Notebook nb1 = new Notebook(id, "MSI", "GF75", "Black",
                                    8, 2400,
                                    "Intel", "Core i5 7500", 4, 3.2,
                                    1024,
                                    "IPS", 14.2);
        id++;

        Notebook nb2 = new Notebook(id, "Acer", "Aspire 3", "Black",
                                    8, 2400,
                                    "AMD", "Ryzen 5 3500U", 4, 2.1,
                                    256,
                                    "IPS", 15.6);
        id++;

        Notebook nb3 = new Notebook(id, "Apple", "MacBook Air", "Midnight",
                                    8, 3200,
                                    "Apple", "M2", 8, 3.5,
                                    256,
                                    "IPS", 13.6);
        id++;

        Notebook nb4 = new Notebook(id, "ASUS", "TUF Gaming F17", "Graphite Black",
                                    16, 3200,
                                    "Intel", "Core i5 11400H", 6, 2.7,
                                    512,
                                    "IPS", 17.3);
        id++;

        Notebook nb5 = new Notebook(id, "ASUS", "TUF Gaming F17", "Silver",
                                    16, 3200,
                                    "Intel", "Core i5 11400H", 6, 2.7,
                                    1024,
                                    "AMOLED", 17.3);
        id++;

        Set<Notebook> nbs = new HashSet<>(Arrays.asList(nb1, nb2, nb3, nb4, nb5));
        System.out.println("Ноутбуки загружены. Введите номер параметра для фильтрации:");
        System.out.println("1 - по вендору");
        System.out.println("2 - по CPU");
        System.out.println("3 - по объёму RAM");
        System.out.println("4 - по объёму HDD");

        System.out.print("Введите параметр: ");
        String param = input.nextLine();

        Set<Notebook> fnbs = filter(param, nbs);
        if (fnbs != null) {
            for (Notebook nb: fnbs) {
                System.out.println(nb + "\n");
            }
        }
    }

    public static Set<Notebook> filter(String param, Set<Notebook> nbs) {
        Set<Notebook> fnbs = new HashSet<>();
        int min, max;
        switch (param) {
            // по вендору
            case "1":
                System.out.print("Введите вендора: ");
                String vendor = input.nextLine().toLowerCase();
                for (Notebook nb: nbs) {
                    if (nb.vendor.toLowerCase().equals(vendor)) {
                        fnbs.add(nb);
                    }
                }
                break;

            // по CPU
            case "2":
                System.out.print("Введите производителя CPU: ");
                String CPUVendor = input.nextLine().toLowerCase();
                System.out.print("Введите модель CPU: ");
                String CPUModel = input.nextLine().toLowerCase();
                for (Notebook nb: nbs) {
                    if (nb.CPUVendor.toLowerCase().equals(CPUVendor) &&
                        nb.CPUModel.toLowerCase().equals(CPUModel)) {
                        fnbs.add(nb);
                    }
                }
                break;

            // по объёму RAM
            case "3":
                System.out.println("Введите диапазон [min, max]:");
                System.out.print("min: ");
                min = Integer.parseInt(input.nextLine());
                System.out.print("max: ");
                max = Integer.parseInt(input.nextLine());

                for (Notebook nb: nbs) {
                    if (min <= nb.RAMSize && nb.RAMSize <= max) {
                        fnbs.add(nb);
                    }
                }
                break;

            //по объёму HDD
            case "4":
                System.out.println("Введите диапазон [min, max]:");
                System.out.print("min: ");
                min = Integer.parseInt(input.nextLine());
                System.out.print("max: ");
                max = Integer.parseInt(input.nextLine());

                for (Notebook nb: nbs) {
                    if (min <= nb.HDDSize && nb.HDDSize <= max) {
                        fnbs.add(nb);
                    }
                }
                break;
            default:
                System.out.println("Неверный параметр");
                return null;
        }
        return fnbs;
    }
}
