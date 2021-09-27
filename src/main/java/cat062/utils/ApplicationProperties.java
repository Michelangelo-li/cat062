/**
 * Data Fusion Platform
 *
 * @author Andy Zheng (shzheng@ronglian.com)
 * Project: interface-reader
 * File: ApplicationProperties.java
 * Package: com.uec.dfp.utils.config
 * @version 1.1.2009
 * @date 2020年9月16日
 */
package cat062.utils;

import cat062.conf.Constant;
import cat062.conf.KafkaProperties;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

@ToString
public class ApplicationProperties{

    private static final Logger log = LoggerFactory.getLogger(ApplicationProperties.class);

    private static final String  configFilename = System.getProperty(Constant.SYSPROP_CONFIG_FILE);

    public String svcId;                        // 服务ID，用于在监控消息中采用
    public String svcVer;                        // 服务程序版本，用于在监控消息中采用
    public String svcIp;                        // 服务所在的服务器的IP地址，用在监控消息中


    public KafkaProperties sourceKafka;            // 目标Kafka


    public static ApplicationProperties loadConfig() {
        log.debug("准备加载配置文件：{}", configFilename);
        File configFile = getConfigFile();
        if (null == configFile) {
            log.error("指定的配置文件 {} 不存在，系统退出！", configFilename);
            return null;
        }
        log.info("读取项目配置：{}。", configFile.getAbsolutePath());
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            log.error("读入配置文件异常，：{}。异常信息：{}", configFile.getAbsolutePath(),
                    e.getLocalizedMessage());
            return null;
        }


        Yaml yaml = new Yaml();

        ApplicationProperties appProp = yaml.loadAs(inputStream, ApplicationProperties.class);


        log.info("从配置文件 {} 中加载参数：\n", configFile.getAbsolutePath());
        try {
            inputStream.close();
        } catch (IOException e) {
            log.error("关闭配置文件 {} 失败：{}\n{}", configFile.getAbsolutePath(), e.getLocalizedMessage(),
                    e.getStackTrace());
        }
        return appProp;
    }



    private static File getConfigFile() {
        File configFile = null;
        if (null == configFilename) {
            System.err.format("未指定配置文件，请配置 %s 参数", Constant.SYSPROP_CONFIG_FILE);
        } else {
            configFile = new File(configFilename);
            if (null != configFile) {
                if (!configFile.exists()) {
                    System.err.format("指定的配置文件 %s 不存在！", configFilename);
                    configFile = null;
                }
                if (!configFile.isFile()) {
                    System.err.format("指定的配置文件名 %s 不是有效文件！", configFilename);
                    configFile = null;
                }
                if (!configFile.canRead()) {
                    System.err.format("对指定的配置文件 %s 没有读取的权限！", configFilename);
                    configFile = null;
                }
            }
        }
        return configFile;
    }
}
