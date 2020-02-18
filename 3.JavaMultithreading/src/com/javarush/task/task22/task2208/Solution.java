package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE

Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        getQuery(map);
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,String> pair: params.entrySet()){
            if(pair.getValue() != null) {
                sb.append(" and "+ pair.getKey() + " = '" + pair.getValue()+"'");
            }
        }

        return sb.replace(0,5,"").toString();
    }
}
