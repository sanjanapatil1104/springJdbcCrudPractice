package org.mapper;

import org.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class StudentRowMapper implements RowMapper<Student>
{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student std=new Student();
        std.setStd_roll(rs.getInt("std_roll"));
        std.setStd_name(rs.getString("std_name"));
        std.setStd_marks(rs.getFloat("std_marks"));
        return std;
    }
}
