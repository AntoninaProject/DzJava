// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее ариф. значение

import java.util.*;

public class Dz3 {

    static void udalChet(List<Integer> arrList) {
        for (int i=0; i < arrList.size()-1; i++) {
            if (arrList.get(i) % 2 == 0) {
                arrList.remove(i);
            }
        } 
        System.out.println("Остаток после удаления чётных: " + arrList);
        
    }
    static Integer MaxNum(List<Integer> arrList) {
        int max = arrList.get(0); 
        for (int i=0; i < arrList.size()-1; i++) {
            if (arrList.get(i) > max) {
                max = arrList.get(i);
            }
        } 
        return max;
    }
    static Integer MinNum(List<Integer> arrList) {
        int min = arrList.get(0); 
        for (int i=0; i < arrList.size()-1; i++) {
            if (arrList.get(i) < min) {
                min = arrList.get(i);
            }
        } 
        return min;
    }
     static Double Sredn(List<Integer> arrList) {
        int sum = 0; 
        double srednee;
        for (int i=0; i < arrList.size()-1; i++) {
            sum += arrList.get(i);
        } 
        srednee = sum / arrList.size();
        return srednee;
    }
    
    public static void main(String[] args) {
        List<Integer> list_num = new ArrayList(Arrays.asList(4, 23, 6, 9, 18, 39, 4, 37, 17, 3));
        System.out.println("Изначальный список: " + list_num);
        System.out.println("Минимальное значение: " + MinNum(list_num));
        System.out.println("Максимальное значение: " + MaxNum(list_num));
        System.out.println("Среднее значение: " + Sredn(list_num));
        udalChet(list_num);
    }
}