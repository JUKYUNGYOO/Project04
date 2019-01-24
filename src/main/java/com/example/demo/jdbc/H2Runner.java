package com.example.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/*
URL "testdb"
USERNAME "sa"
password " "
application.properties에 등록하고 껐다가 켜야 됨.
spring.h2.console.enabled=true
 */

@Component //빈으로 등록
public class H2Runner implements ApplicationRunner {

    @Autowired //Datasource가 빈으로 자동 주입
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception{
        //Connect에 메타정보가 있음
        try(Connection connection = dataSource.getConnection()){
            System.out.println(connection.getMetaData().getURL()); //메타정보에서 URL을 확인 할 수 있음
            System.out.println(connection.getMetaData().getUserName());


            Statement statement = connection.createStatement();
            String sql =  "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255),PRIMARY KEY(id) )";
            statement.executeUpdate(sql);


        }
        jdbcTemplate.execute("INSERT INTO USER VALUES (1,'jukyung')");



    }


}

