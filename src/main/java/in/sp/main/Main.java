package in.sp.main;

import in.sp.resource.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.security.spec.NamedParameterSpec;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        NamedParameterJdbcTemplate namedParameterS = applicationContext.getBean(NamedParameterJdbcTemplate.class);
        Map<String, Object> map = new HashMap<>();
        map.put("key_roll", 104);
        map.put("key_name", "Rajni");
        map.put("key_marks", 90.9f);

//        Insert Opration .................."
       /*String insert_sql_query ="insert into student values (:key_roll,:key_name,:key_marks)";
      int count= namedParameterS.update(insert_sql_query,map);
      if(count>0)
      {
          System.out.println("insert succesfully");
      }
      else
      {
          System.out.println("insertion failed");
      }*/

        //"Update Opration ......................."

       /*String update_sql_query ="update  student set  std_marks=:key_marks where std_roll=:key_roll";
       int count= namedParameterS.update(update_sql_query,map);
       if(count>0)
       {
           System.out.println("update succesfully");
       }
       else
       {
           System.out.println("update failed");
       }*/

        /* Deletion Opration.................. */
       /* String delete_sql_query="delete from student where std_roll= :key_roll";
        int count=namedParameterS.update(delete_sql_query,map);
        if(count>0)
        {
            System.out.println("delete succesfully");
        }
        else
        {
            System.out.println("delete failed");
        }*/

//        "............Read opration"
        String select_sql_query="select * from student";
        namedParameterS.query(select_sql_query,map, (rs, rowNum) -> {
            System.out.println("roll:"+rs.getInt("std_roll"));
            System.out.println("name:"+rs.getString("std_name"));
            System.out.println("marks:"+rs.getFloat("std_marks"));
            return null;
        });

    }
}
