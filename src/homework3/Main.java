package homework3;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        System.out.println("Добавляем в различных вариациях.");
        myList.addFirst(2);
        myList.add(3);
        myList.add(5,2);
        myList.add(4, 2);
        myList.addFirst(1);

        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Разворот массива");
        myList.reverse();
        System.out.println(myList);
        System.out.println();

        System.out.println("Обратный разворот массива");
        myList.reverse();
        System.out.println(myList);
        System.out.println();

        System.out.println("Получение элемента по индексу");
        //System.out.println(myList.get(-1)); // выход за пределы
        System.out.println(myList.get(0));
        System.out.println(myList.get(2));
        System.out.println(myList.get(4));
        //System.out.println(myList.get(5));  // выход за пределы
        System.out.println();

        System.out.println("Удаление элемента с конца");
        myList.remove();
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Удаление элемента с начала");
        myList.removeFirst();
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Удаление элемента с середины");
        myList.remove(1);
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Очистка списка");
        myList.clear();
        System.out.println(myList);
        System.out.println(myList.size());
    }
}
