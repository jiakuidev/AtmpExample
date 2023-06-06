package com.zixiapp.atmp.test;

import app.jiakui.letest.service.AppiumService;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestClassOrder(ClassOrderer.ClassName.class)
public class Test_Appium extends AppiumService {

    @BeforeEach
    public void setUp() throws Exception{
        super.beforeTest();
        startLauncherActivity("com.tencent.wework",".launch.LaunchSplashActivity");
    }

    @Order(1)
    @Test
    public void Test_01_Wo_CASE() throws SQLException, IOException {
        util.clickTextByXPath("测试");
    }

}
