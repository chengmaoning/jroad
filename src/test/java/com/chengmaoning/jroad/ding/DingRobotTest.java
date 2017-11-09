/**
 * 
 */
package com.chengmaoning.jroad.ding;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * DingRobotTest.java
 * @author chengmaoning
 *
 * 2017年10月10日上午10:53:22
 */
public class DingRobotTest {
	private static  final String DING_ROBOT_API = "https://oapi.dingtalk.com/robot/send?access_token=1f14f610f320baa2701403c8acfcafce92097be4641249c6c2318c6d043cffc8";

    @Test
    public void sendDingRobot() {

        StringBuffer content = new StringBuffer("[10-10 09:36 fincorecheck 核对失败](dev) 指令数量不相等!, FinacoreMinitransRedeemInstructionChecker, check-zfqs-zfqs_paycore-zfqs_paycore_pay-040029, 0ad1515c1507599363800339613140, null, 类似处理： ddd - 义方, null");
//        content.append(checkAlarmInfo.getTitle()).append(" ")
//                .append(checkAlarmInfo.getErrMsg()).append(", ")
//                .append(checkAlarmInfo.getCheckerClassName()).append(", ")
//                .append(checkAlarmInfo.getRuleId()).append(", ")
////                .append(checkAlarmInfo.getRuleName()).append(", ")
//                .append(checkAlarmInfo.getTraceId()).append(", ")
//                .append(checkAlarmInfo.getBizNo()).append(", ");
//        if (checkAlarmInfo.getProposals() != null) {
//            CheckerSimilarErrorModel model = checkAlarmInfo.getProposals().get(0);
//            content.append("类似处理： ").append(model.getProcessMsg()).append(" - ")
//                    .append(model.getProcessorNickName()).append(", ");
//        }
//        content.append(checkAlarmInfo.getDetailUrl());

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DING_ROBOT_API);
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");


        JSONObject text = new JSONObject();
        text.put("content", content.toString());
        JSONObject object = new JSONObject();
        object.put("msgtype", "text");
        object.put("text", text);

        System.out.println();
        
        StringEntity se = new StringEntity(object.toJSONString(), "utf-8");
        httpPost.setEntity(se);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
