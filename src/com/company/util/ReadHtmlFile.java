package com.company.util; 

import java.io.BufferedInputStream; 
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.Reader; 
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.HttpException; 
import org.apache.commons.httpclient.methods.GetMethod; 

public class ReadHtmlFile { 

  public static HttpClient client = new HttpClient(); 
    
  //读取普通文件 
  public static String readFile(String filename) throws Exception { 
    File file = new File(filename); 
    FileInputStream in = new FileInputStream(file); 
    BufferedReader br = new BufferedReader(new InputStreamReader(in,  "UTF-8"));
    StringBuffer stb = new StringBuffer(); 
    while(br.readLine()!=null){
    	stb.append(br.readLine());
    }
    String str=stb.toString();
    return str; 
  } 

  /** 
    *    
    * 所要发送的网页中,不要使用外联样式，脚本等， 
    * 因为各大邮箱后台的过滤算法会过滤掉css,script等 
    * 样式用标签style属性写 
    * 图片、链接必须使用绝对地址 （http://.....） 形式才能接收显示 
 * @throws UnsupportedEncodingException 
    * */ 
  public static String getSource(String url) throws UnsupportedEncodingException { 

    GetMethod method = new GetMethod(url); 

    try { 
      client.executeMethod(method); 
    } catch (HttpException e) { 
      e.printStackTrace(); 
    } catch (IOException e) { 
      e.printStackTrace(); 
    } 
    InputStream in = null; 
    try { 
      in = method.getResponseBodyAsStream(); 
    } catch (IOException e1) { 

      // e1.printStackTrace(); 
    } 
    in = new BufferedInputStream(in); 
    Reader r = new InputStreamReader(in,"UTF-8"); 
    int c; 
    StringBuffer buffer = new StringBuffer(); 

    try { 
      while ((c = r.read()) != -1) 
        buffer.append((char) c); 
    } catch (IOException e) { 
      e.printStackTrace(); 
    } 
    try { 
      in.close(); 
    } catch (IOException e) { 
      e.printStackTrace(); 
    } 
    method.releaseConnection(); 

    return buffer.toString(); 
  } 
} 