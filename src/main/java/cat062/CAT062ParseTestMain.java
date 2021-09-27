package cat062;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cat062.conf.Constant;
import cat062.decoder.CAT062Data;
import cat062.decoder.CAT062KafkaMsgNew;
import cat062.decoder.CommonUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CAT062ParseTestMain {


    private static final Logger log = LoggerFactory.getLogger(CAT062ParseTestMain.class);

    private static long startTime = System.currentTimeMillis();

    private static String appId = System.getProperty(Constant.SYSPROP_APP_ID);


    static String textFromKafka = "{\"data\":{\"data\":{\"type\":1,\"value\":\"PgPuv1//CwIBAQAU8OkAWrPpAU2kIvRXYgKKvAAn/MIABe8l8Y54An4NUHXnbeCEwAGSY9gD2CDg/9IAI8AAfiAHOBas+lNpCAEYAFMD9Ql+AREBSHEg/wMD//DzfV9B4AP//wMDAwMD/wMDAwMDA/8DAwMD2A9Fg/EAAP+gAQFDVUE1OTY3AAAA5ABCNzM4TVpCQURaU1FaA9gBEvzcFlsSbErcA9gABaAO/iAgIAPYA/KD8gPYAL9f/wsCAQEAFPDpAFpxegFQhuT3QzgCI4D8/P+sD+LvJfGOeAKxDFT535xgwMABlGMUAxQg4AD2AcmAArwgBrgWnF9UIbkBNwBRA/UIhQERAUhxIP8DA//0831fQeAD//8DAwMDA/8DAwMDAwP/AwMDAswLMILNAOz/gAEBQ0VTOTc5MQAAAH0AQTMyMU1aU05KWkpTWQERCtwWW0YlRegCzA/ioA7+ICAgAswCzILMAswAv1//CwIBAQAU8OkAWmtAAVGtqvhulAIUZP3CAAkP6O8l8Y54EWQNUHLjLCDE4AEeYsQCxCDgAmEANcAAwQAE6Baa0FRrawD9ADgEDQpsAREBSHEg/wME//TzfV9B4AP//wMEBAQE/wQEBAQEBP8EBAQBSwUpgU0Cif+AAQFDVUEyODIwAAAEDQBCNzM4TVpTTkpaQkRTARTY3BZbWpxEqgFLD+igDv4gICABTQFLgUsBSwC/X/8LAgEBABTw6QBaNDIBTZH99D9UAfNwA30BNw2O7yXxjngOORCyMcctIDigAa5kKAQoIOAABQQwgAQ0gAg3Fo0MU2R/ASQAWgP1BkABEQFIcSD/BQb/8PN9X0HgBf//BQYGBgb/BgYGBgYG/wYGBgQnELiEQQAA/6ABAURLSDExMjQAAASnAEEzMjFNWkdIQVpTU1MEJwEMgNwW2U3lvRoEJw2OoA7+ICAgBCcEQYRBBCcAv1/9CwIBAQAU8OkAWn5bAVoXgAD7MAIUYP3a/1MFmwEBAYAWn5dWheABugEBAVhxIP8M///w8RkBQAz//wz///8AXAFrgHMAAAEDdNwWWCqW+RtAXAWbQA7+ICBAAFtAdIB0QFwAv1//CwIBAQAU8OkAWmIPAVJFBfkIJgIF7ADgAOYCLu8l8Y54BGsNNrnXbWAfwACsYAMB2CDgAT32hkDoHEAC8xaYhFSRQQCpACIEDQrFAREBSHEg/woK//TzfV9B4Ar//woKCgoK/woKCgoKCv8KCgoAZQGggGUBPv+gAQFDU1o5NTY1AAAATgBCNzM4TVpTTkpaVVVVAxMBFYrcFlwF4iahAGUCLqAO/iAgIABlAGWAZQBlAA==\"}},\"dataLength\":1374,\"dataType\":\"cat062_1_15\",\"encode\":\"None\",\"hashCode\":\"63f23767bea78f0dbf1ecdc6be5e80a6\",\"receiveTime\":1606705122540,\"sendTime\":0,\"seqNo\":21249794,\"serviceId\":\"atcs_track_cat062\",\"serviceIp\":\"172.24.61.2\",\"serviceVersion\":\"1.1.2011\",\"sourcePort\":0}";


    public static String parseStr(String kafkaMsgStr) {

        CAT062KafkaMsgNew cAT062KafkaMsg = JSONObject.parseObject(kafkaMsgStr, CAT062KafkaMsgNew.class);
        String data = cAT062KafkaMsg.getData().getData().getValue();

//        try {
//            System.out.println((new String(Base64.decodeBase64(data), "UTF-8")));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        System.out.println(Base64.decodeBase64(data));
        //data是编码后的字符串
        //   bytes2hex02吧byte[]=》十六进制的字符串  decodeBase64把String转化成16进制的int[]数组
        System.out.println("十六进制"+bytes2hex02(Base64.decodeBase64(data)));


        // base64 encode 之后的
        int[] bytesInt = CommonUtil.base64ToIntArray(data);


        try {
            CAT062Data cAT062Data = new CAT062Data(bytesInt, 0, cAT062KafkaMsg.getDataLength(), cAT062KafkaMsg.getReceiveTime());

            System.out.println(JSON.toJSONString(cAT062Data));

            System.out.println(cAT062Data.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


//        System.out.println("length=" + bytesInt.length);

//        System.out.println(Arrays.toString(bytesInt));

        return null;


    }


    public static String bytes2hex02(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1)// 每个字节8为，转为16进制标志，2个16进制位
            {
                tmp = "0" + tmp;
            }
            sb.append(tmp);
        }

        return sb.toString();

    }


    public static void main(String[] args) {

//        // 记录启动日志
//        log.info("应用程序 {} 于 {} 启动。", appId, Constant.DATE_FORMAT.format(new Date(startTime)));
//
//        // 读取、加载配置信息到 appProp 中
//        ApplicationProperties appProp = ApplicationProperties.loadConfig();
//
//        log.info("the conf is: --->"+appProp.toString());
//
//        KafkaConsumer<String, String> kafkaConsumer = KafkaMessageUtil.createKafkaConsumer(appProp.sourceKafka);
//
//        kafkaConsumer.subscribe(Arrays.asList(appProp.sourceKafka.topic));
//
//        OrdinaryConsumer ordinaryConsumer = new OrdinaryConsumer(kafkaConsumer,1000000);
//
//        ordinaryConsumer.run();

        System.out.println(parseStr(textFromKafka));

//        byte b = -7; //1000 0111
//
//        int bi = b;
//
//        System.out.println();
//
//        print(bi);
//
//        System.out.println();
//
//        print(bi & 0xFF);
//
//
//        byte c = (byte) (bi & 0xFF);
//
//        System.out.println();
//
//        System.out.println(c);
    }


    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            String j = ((num & 1 << i)) == 0 ? "0" : "1";
            System.out.print(j);
        }
    }
}
