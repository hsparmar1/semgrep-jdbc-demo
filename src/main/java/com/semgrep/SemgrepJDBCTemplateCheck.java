package com.semgrep;

import java.sql.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jdbc.core.*;
import org.springframework.dao.DataAccessException;

public class SemgrepJDBCTemplateCheck
{
    String maliciousCode = "";
    
    public void testCase1(JdbcTemplate jdbcTemplate, String input) throws DataAccessException
    {
        jdbcTemplate.execute("select * from dual where dummy = '" + maliciousCode + "'");
    }

    public void testCase2(JdbcTemplate jdbcTemplate, String input) throws DataAccessException 
    {
        String sql = "select * from dual where dummy = '" + maliciousCode + "'";
        jdbcTemplate.execute(sql);
    }

    public void testCase3(JdbcTemplate jdbcTemplate, String input) throws DataAccessException
    {
        jdbcTemplate.execute(String.format("select * from dual where dummy = '%s'", maliciousCode) );
    }

    public void testCase4(JdbcTemplate jdbcTemplate, String input) throws DataAccessException
    {
        String sql = "select * from dual where dummy = '%s'";
        jdbcTemplate.execute(String.format(sql,input));
    }

    public void testCaseList3(JdbcTemplate jdbcTemplate, String sql) throws DataAccessException
    {
        List list1 = jdbcTemplate.queryForList(sql);
        List list2 = jdbcTemplate.queryForList(sql, Dual.class);
    }
}
