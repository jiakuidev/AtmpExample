package com.zixiapp.atmp.po;

import app.jiakui.letest.KeyEvent;
import app.jiakui.letest.Node;
import app.jiakui.letest.PropUtil;
import app.jiakui.letest.UiObject;
import com.zixiapp.atmp.service.DYService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DYScene extends DYService {

    public DYScene() {

    }


    public void fiveSuite() throws ParseException {
        String[] userIds = PropUtil.getInstance().getProp("userId").trim().split(",");
        for (int i = 0; i < userIds.length; i++) {
            todoWork(userIds[i]);
        }
    }


    public void todoWork(String userId) throws ParseException {
        letest2.startLauncherActivity("com.ss.android.ugc.aweme", ".splash.SplashActivity");

        List<Node> app = letest2.getNodeList("抖音");
        if (app.size() != 0) {
            letest2.clickNode(app.get(0));

        }
        sleep(15000);
        if (letest2.adbServce.checkUiHierarchyObject()) {
            Node live = letest2.getNodeFromElements("点击进入直播间");
        } else {
            letest2.clickScreen(300, 500);
        }

        letest2.clickUiObjectDesc("搜索");
        sleep(3000);

        letest2.inputText(userId);
        sleep(3000);
        letest2.clickUiObject("搜索");
        sleep(3000);
        letest2.clickUiObject(userId, 1);
        sleep(3000);

        letest2.swipeToUp(3, 1);
        letest2.swipeToUp(8, 1);

        List<Node> sets = letest2.getNodesByXpath("//node[@class='androidx.recyclerview.widget.RecyclerView']" +
                "/node[@class='android.widget.FrameLayout']/node[@class='android.widget.LinearLayout']/node[@class='androidx.recyclerview.widget.RecyclerView']");
        int offSet = 0;
        log.info("sets:" + sets.size());
        if (sets.size() > 0) {
            offSet = 1;
        }

        List<Node> nodes = letest2.getNodesByXpath("//node[@class='androidx.recyclerview.widget.RecyclerView']/node[@class='android.widget.FrameLayout']/node[@class='android.view.View']");
        log.info("nodes=" + nodes.size());
        List<Node> nodesTop = letest2.getNodesByXpath("//node[@class='androidx.recyclerview.widget.RecyclerView']/node[@class='android.widget.FrameLayout']/node[@class='android.widget.TextView' and @text='置顶']");
        log.info("nodesTop=" + nodesTop.size());
        int topNum = nodesTop.size();

        log.info("offset=" + offSet);
        letest2.clickNode(nodes.get(offSet));
        sleep(3000);
        letest2.clickScreen(300, 500);
        UiObject uiObject = letest2.findTextUiObject("IP属地");
        String timeLabel = uiObject.getText();
        timeLabel = timeLabel.substring(0, timeLabel.indexOf("IP") - 2);
        log.info(timeLabel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date topDate = sdf.parse(timeLabel);
        log.info(topDate.compareTo(new Date()));
        letest2.sendKey(KeyEvent.KEYCODE_BACK);

        if (timeCompare(nodes, topDate, topNum + offSet) > 0) {
            letest2.clickNode(nodes.get(topNum + offSet));
        } else {
            letest2.clickNode(nodes.get(offSet));
        }

        sleep(3000);
        letest2.clickScreen(300, 500);
        sleep(3000);
        if (letest2.findUiObjectDesc("未点赞") != null) {
            letest2.clickUiObjectDesc("点赞");
        }
        sleep(3000);
        if (letest2.findUiObjectDesc("评论") != null) {
            letest2.clickUiObjectDesc("评论");
        }

        PropUtil yuliao=new PropUtil("/main/resources/yu.properties",false);
        letest2.clickUiObject("善语结善缘，恶言伤人心");
        sleep(2000);
        letest2.setTextUiObject("善语结善缘，恶言伤人心",yuliao.getProp(Integer.toString(getRandom(1,9))).toString());
        sleep(2000);
        letest2.clickUiObject("发送");
        sleep(2000);
        letest2.sendKey(KeyEvent.KEYCODE_BACK);
        sleep(2000);
        if (letest2.findUiObjectDesc("未选中") != null) {
            letest2.clickUiObjectDesc("收藏");
        }
        sleep(2000);
        if (letest2.findUiObjectDesc("分享") != null) {
            letest2.clickUiObjectDesc("分享");
        }
        sleep(2000);
    }

}
