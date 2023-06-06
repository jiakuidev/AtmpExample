package com.zixiapp.atmp.service;


import app.jiakui.letest.KeyEvent;
import app.jiakui.letest.Node;
import app.jiakui.letest.UiObject;
import app.jiakui.letest.service.LeTestService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DYService extends LeTestService {

    public static final Logger log = LogManager.getLogger(DYService.class.getName());

    protected Map<String, String> resultMap;

    public static String env;

    public int webViewWidth = 0;

    public int webViewHeight = 0;

    private static boolean debug = true;

    private static boolean isRemote = false;

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    public void tearDown() throws Exception {

    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DYService() {
        
    }

    public int getRandom(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public int timeCompare(List<Node> nodes, Date topDate, int nodeIndex) throws ParseException {
        log.info("不是置顶的第一个序号是："+nodeIndex);
        letest2.clickNode(nodes.get(nodeIndex));
        sleep(4000);
        letest2.clickScreen(300, 500);
        UiObject timeNode = letest2.findTextUiObject("IP属地");
        String timeLabel = timeNode.getText();
        timeLabel = timeLabel.substring(0, timeLabel.indexOf("IP") - 2);
        log.info(timeLabel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(timeLabel);
        letest2.sendKey(KeyEvent.KEYCODE_BACK);
        return date.compareTo(topDate);
    }

}
