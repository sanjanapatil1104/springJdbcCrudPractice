package org.example;

import org.bean.Student;
import org.in.resource.SpringConfigFile;
import org.mapper.StudentRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;

public class App {

    public static void main(String[] args) {


        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfigFile.class);
      JdbcTemplate jdbcTemplate= applicationContext.getBean(JdbcTemplate.class);

      // 1.Insert query>>>>>>>............................//
        int std_roll=102;
        String std_name="sourabh";
        float std_marks=90.1f;
      String insert_sql_query="insert into student values(?,?,?)";
    int count=  jdbcTemplate.update(insert_sql_query,std_roll,std_name,std_marks);
    if(count>0)
    {
        System.out.println("insertion succesfull");
    }
    else
    {
        System.out.println("insertion fail");
    }
        // 2. update query.........................//
        int std_roll1=101;
        float std_marks1=70.0f;
        String update_query="update student set std_marks=? where std_roll=?";
        int count1=jdbcTemplate.update(update_query,std_marks1,std_roll1);
        if(count1>0)
        {
            System.out.println("update succesfull");
        }
        else
        {
            System.out.println("update  fail");
        }


        //  3.Delete opration ........................

            int std_roll2=101;
            String delete_query="delete from student where std_roll=?";
            int count2=jdbcTemplate.update(delete_query,std_roll2);
            if(count2>0)
            {
                System.out.println("delete succesfull");
            }
            else
            {
                System.out.println("deletion  fail");
            }

        // 4. Read Opration ..................................//
        String select_data="select * from student";
        ResultSetExtractor<? extends List<Student>> StudentRowMapper;
        List<Student> list=  jdbcTemplate.query(select_data,  new StudentRowMapper());
        for(Student std:list)
        {
            System.out.println("std_roll  "+std.getStd_roll());
            System.out.println("std_name  "+std.getStd_name());
            System.out.println("std_marks "+std.getStd_marks());
            System.out.println("..............................");
        }


        }
    }
