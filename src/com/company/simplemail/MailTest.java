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
    * ���� 
 * @throws Exception 
    * */ 
  public static void testSingleSend() throws Exception{ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("asdfasdfasd"); 
    String str = ReadHtmlFile.getSource("http://www.yunyi001.com"); 
//    String str = ReadHtmlFile.readFile("C:/Users/yyhl002/Desktop/��ҽ��վ/pc/index/aboutyunyi.html"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("13683258518@163.com","101582026"); 
    try { 
      sms.send("849089789@qq.com", sm); 
      System.out.println("ִ����ɣ���"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
    
    
  /** 
    * Ⱥ�� 
 * @throws UnsupportedEncodingException 
    *    
    * */ 
  public void testMassSend() throws UnsupportedEncodingException{ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("��һ���ʼ�"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("������д��Ҫ���͵ı����ļ�·��"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("������д��ķ�����","������д��ķ���������"); 
    List<String> recipients=new ArrayList<String>(); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    try { 
      sms.send(recipients, sm); 
      System.out.println("ִ����ɣ���"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
} 