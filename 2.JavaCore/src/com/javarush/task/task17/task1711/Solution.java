package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, NullPointerException {

        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j = j + 3) {
                        if (args[j+1].equals("м")) allPeople.add(Person.createMale(args[j], Parsindate(args[j+2])));
                        else if (args[j+1].equals("ж")) allPeople.add(Person.createFemale(args[j], Parsindate(args[j+2])));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople){
                    for (int j = 1; j < args.length ; j= j + 4) {
                        if (args[j+2].equals("м")) allPeople.set(Integer.parseInt(args[j]), Person.createMale(args[j+1], Parsindate(args[j+3])));
                        else if (args[j+2].equals("ж")) allPeople.set(Integer.parseInt(args[j]), Person.createFemale(args[j+1], Parsindate(args[j+3])));
                    }
                    break;
                }

            case "-d":
                synchronized (allPeople){
                    for (int j = 1; j < args.length ; j++) {
                    allPeople.get(Integer.parseInt(args[j])).setName(null);
                    allPeople.get(Integer.parseInt(args[j])).setSex(null);
                    allPeople.get(Integer.parseInt(args[j])).setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople){
                    for (int j = 1; j < args.length ; j++) {
                    Person person = allPeople.get(Integer.parseInt(args[j]));
                    String sex = (person.getSex().equals(Sex.MALE)) ? " м " : " ж ";
                    System.out.println(person.getName() + sex + Printdate(person.getBirthDate()));
                    }
                }
                break;
        }
    }

    public synchronized static Date Parsindate(String date) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
        String str = date;
        Date parsingDate = input.parse(str);
        return parsingDate;
    }

    public synchronized static String Printdate(Date date){
        SimpleDateFormat output = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return output.format(date);
    }
}
