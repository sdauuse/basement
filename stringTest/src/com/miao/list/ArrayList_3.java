package com.miao.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_3 {

    public static void main(String[] args) {
        StudentEnhanceId stu1 = new StudentEnhanceId();
        stu1.setId(1);
        stu1.setName("lky");
        stu1.setAge(23);

        StudentEnhanceId stu2 = new StudentEnhanceId();
        stu2.setId(2);
        stu2.setName("miaoyin");
        stu2.setAge(22);

        List<StudentEnhanceId> list  = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);

        int searchCode = 1;
        for (StudentEnhanceId student : list) {
            if (student.getId() == searchCode){
                System.out.println(student.getName());
            }
        }
    }
}
