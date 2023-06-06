package com.zixiapp.atmp.test;

import app.jiakui.letest.service.WebTestService;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestClassOrder(ClassOrderer.ClassName.class)
public class Test_02_AAA extends WebTestService {

    private String token;

    private  String rdate = "20210630";

    private  String shop_code = "2002, 2003, 2004, 2005, 2006, 2009, 2017, 2018, 2023, 2024, 2025, 2028, 2038, 2039";

    private final String datatype = "10,11";

    @BeforeEach
    public void setUp() throws Exception {

    }

    @Order(1)
    @Test
    public void Test_01_Wo_CASE() throws SQLException, IOException {
        log.info("ssssssssssss");
    }

    @AfterEach
    public void tearDown() throws Exception {
        // TODO Auto-generated method stub
    }

}
