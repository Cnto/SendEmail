package com.company.simplemail; 

import java.io.UnsupportedEncodingException;
import java.util.ArrayList; 
import java.util.List; 





import com.company.util.ReadHtmlFile; 

public class MailTest { 
	public static void main(String[] args) throws Exception {
		testSingleSend();
	}
  /** 
    * 单发 
 * @throws Exception 
    * */ 
  public static void testSingleSend() throws Exception{ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("asdfasdfasd"); 
    String str = ReadHtmlFile.getSource("http://www.yunyi001.com"); 
//    String str = ReadHtmlFile.readFile("C:/Users/yyhl002/Desktop/云医网站/pc/index/aboutyunyi.html"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("13683258518@163.com","101582026"); 
    try { 
      sms.send("849089789@qq.com", sm); 
      System.out.println("执行完成！！"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
    
    
  /** 
    * 群发 
 * @throws UnsupportedEncodingException 
    *    
    * */ 
  public void testMassSend() throws UnsupportedEncodingException{ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("第一封邮件"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("这里填写需要发送的本地文件路径"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("这里填写你的发件箱","这里填写你的发件箱密码"); 
    List<String> recipients=new ArrayList<String>(); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    try { 
      sms.send(recipients, sm); 
      System.out.println("执行完成！！"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
} 