package com.zixiapp.atmp.test;

import app.jiakui.letest.*;
import com.zixiapp.atmp.po.DYScene;
import com.zixiapp.atmp.service.DYService;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestClassOrder(ClassOrderer.ClassName.class)
public class Test_01_图文 extends DYService {

    /**
     * 五件套操作配置需要通过参数设置
     */
    @Order(1)
    @Test
    public void test_01_点赞() throws ParseException {
        DYScene douYinScene=new DYScene();
        douYinScene.fiveSuite();
    }


    @Order(2)
    @Test
    public void test_03_拉拉手() throws ParseException {
        letest2.clickScreen(180,LeTest.height-80);
        letest2.sleep(1000);
//        letest2.setTextUiObject(0,"lls");
        //letest2.setTextUiObject("说点什么...",0,new int[]{0},"拉拉手拉拉手拉拉手拉拉手拉拉手拉拉手拉拉手拉拉手拉拉手！！");
        //letest2.sleep(6000);
        letest2.setTextUiObject("说点什么...",0,new int[]{0},"你好！！");
        letest2.sleep(1000);
        letest2.clickUiObject("发送");
    }

}
