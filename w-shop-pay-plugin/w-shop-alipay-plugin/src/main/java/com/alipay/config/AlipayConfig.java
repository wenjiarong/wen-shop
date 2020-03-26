package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101600696973";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDERwuO9XA1RfyYGawsdMSMjOT20Qcob07kgjwJ0w4mN9XIiki3Q9N2x4xI34Y7V6fzZm9AnMNLJXUQkc6kYYG5pdb1vX3aVe3xMNfQAf2PdrJ7ZlS4nmBs3jyb6Ic3cgs/lnJTCO3Zf+6lXwm0FHiud2YHmTF3GCa3ezJjfM0eSr/LaNlRshqSv15vSDDwniD8xHkFR1tRlIEAk87yjqwDrR0UFjxM5PJOnuFXVSznqtHxjJ2+1En9rKxpN9VYxV1KBScU2230TSfq1nIDdHywM26dgWZPEQVeddTwAALP1lJfLyhlubnzW9+Xfh74/3KQzSjRvO3KMiIAXkj3TWB7AgMBAAECggEBAJlW57DIDuGPy8cIR3pzvxoO+NHae70bOIdNN5p1SJiTBnGllymV0574RqCoADZcRNnjLQdNcUVD/jDzuHyzsKVY6pcRc0Ef4MSNZA0dgPqTwNynFYkmMi7bcH5dK0Yl0qPa5XX5g9hoGgkYNnx5gc7LeOp2xC5Gr/ioRrVyyszeOOIzRUCD2685KpVJAIZ/6kXU/C4HYTiJvq0sSkFTD3fUSo499+Yni7rJMke4mEgI2gjbYM3AQS3br43MgGmEhp5qXB/X8ec6xkWuhtGQbrJlfApEebU7Cd4zssD4/xucbZ8k/+aSzVglzzhyyPzHKBLXPv7ntKuyz8iia4XiQAECgYEA+Fgi4GJuOL3rWpeySQvP7ZSDmG16m0PEsv53qaizKeRy2g9troMNv9YurHwdPhihIA/qiCqUReBZU4lc4m8+oRwJS4xGPZ7f0Yim4kbkWWayDwQm3uBs3kEKgsovMKSUS+89aG9mfol7ze9M8S+6SgyaT/fTTPj1EoNRREOabdcCgYEAylQDNxNhLmA+cit81jdc/zfv6EIFoktbXl+ntWFkEHewVHIOSHziJdGdGeRIu5sIPpfEHbGGV2dr1xEnrYWpX9hMhlzNa4mvB6lII5N8ndU+lMze/TlB6tQmwZB6Gb710ajPrLRPxcJCbqAunJahIk5xKGujnD2FZzD1t7NPZf0CgYBXCr0enCE5rgchd227gHJeOOFuuWBxruzwN5RFWKWDF1jR6PpuYeydwjoVpmKxcvx2Ol3fX90cKKfmSYzOqGLxINx5KC8uRdL4o8aqJGLAmufpr3DYSRyfQXinoqmriOOZQb7qLbFkxFcqNKdpGWtXrNchFCFxJwjudiwzmuYzfQKBgQC7nH+GuH+qozAEafLOKHQhbFsXgPD8duf4cLZwaCiDZJirFT/NU4/YBbCpa5dN7woMEGqYJh8uOQY0XQHv0zslVspO5QrOJtOYRQ5RftdU+4GWNQqowEkxWRu+7RtreDk0+lXoDSLTe7hiIEJYjQxJZXdkRbtmi12CPFH8z1ZWeQKBgQDzSIs8JbQakG7G1AjWXUTUcgFW1fHH6sBWZYuxZrdbd/INiJjJS30QF2LSIVYRgUoww53qbE03AyMHdCen6lBG0FWvKKY+ogyNHsglypyGR+XrFQl2bc4fo47FJqt65M12NQ+mgSfcoIsqVnS+qciW96pEPkAIbv+/TJGo01MULQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA488m4u8G959B1S04hryCy7VKW1A2sLnMpf4cMaNMht4zJ/NmThmBqCCjGpxWzlapI68FNNzXIeeSIaiwAheULwRPysZCVTxoCB5DPaV4vdVpWquqU9J2H2xvQMp6dD9ZxKzl+UlB02d3bd4W44qGFPbAnIsDp/RwiOZIQ5ytCao4VvdNigaxwML7anE5xtO6KrUIL0P9IHWgqUpdfnA4pFxrqnemfoD3ZMzA4P5JhdLd5ZQ5mGFTMOASByYixxpN2UNAHAOZWcQMooC0RFH75aiwZUAeZlaF++1sBdg/0k+cmYCnYoFnS+w+JkHngQketbTNwYTXUNI/qRfI4VnAnwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

