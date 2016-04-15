package com.ajax.servlets;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;
class web
{
  public static void main(String args[]) throws Exception
  {
  System.out.println("started");
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String str=br.readLine();
  try
  {
  Class.forName("com.mysql.jdbc.Driver");
  System.out.println("creating db connection");
  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "");
  Statement st=conn.createStatement();
  st.executeQuery("use webcrawler");
  System.out.println("db connection created");
  PreparedStatement st2=conn.prepareStatement("select crawled from url2 "
  		+ " where crawled= ? ");
  st2.setString(1,str);
  ResultSet rs1=st2.executeQuery();
  if(rs1.next())
  {
    System.out.println("Already Crawled");
    System.exit(0);
  }
  PreparedStatement st1=conn.prepareStatement("insert into url1 values( ? )");
  st1.setString(1,str);
  st1.executeUpdate();
  ResultSet rs=st.executeQuery("select tocrawl from url1 limit 0,100");
  while(rs.next())
  {
  crawl(rs,conn,st,st1);
  System.out.println("crawling");
  }
  }
   catch(Exception ex)
  {
    System.out.println("out"+ex);
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
    Statement st=conn.createStatement();
    st.executeQuery("use webcrawler");
    PreparedStatement st1=null;
    ResultSet rs=null;
    crawl(rs,conn,st,st1);
  }
   
  }
  static void crawl(ResultSet rs,Connection conn,Statement st,PreparedStatement st1) throws Exception
  {
    int c;
    String str1;
    String a,c1,d,e;
    int q,q1;
    InputStream i;
    FileReader fr;
    BufferedReader br2;
    rs=st.executeQuery("select tocrawl from url1 limit 0,100");
     while(rs.next())
     {
       str1=rs.getString("tocrawl");
       PreparedStatement st5=conn.prepareStatement("select crawled from url2 where crawled= ? ");
       st5.setString(1,str1);
       ResultSet rs5=st5.executeQuery();
       if(rs5.next())
       {
         System.out.println("Already Crawled");
         PreparedStatement st4=conn.prepareStatement("delete from url1 where tocrawl= ? ");
         st4.setString(1,str1);
         st4.executeUpdate();
         continue;
       }
      try
      {
  URL hp=new URL("http://"+str1);
  URLConnection hpcon=hp.openConnection();
  System.out.println("Downloading HTML file "+str1);
  i=hpcon.getInputStream();
  FileOutputStream fo=new FileOutputStream("G:/crawled sites/"+str1+".html");
  while(((c=i.read())!=-1))
   {
      //System.out.println((char)c);     
      fo.write(c);
   }
   i.close();
  }
  catch(Exception ex)
    {
       System.out.println("inside"+ex);
       st1=conn.prepareStatement("delete from url1 where tocrawl= ? ");
       st1.setString(1,str1);
       st1.executeUpdate();
       crawl(rs,conn,st,st1);
       //st1=conn.prepareStatement("insert into url2 values( ? )");
       //st1.setString(1,str1);
       //st1.executeUpdate();
    }
    try
    {
   fr=new FileReader("G:/crawled sites/"+str1+".html");
    br2=new BufferedReader(fr);
    }
    catch(Exception ex)
    {
       System.out.println(ex);
       continue;
    }
   while((a=br2.readLine())!=null)
   {
       q=a.indexOf("http://");
       while(q!=-1)
       {   
         c1=a.substring(q+7);
         StringTokenizer stok=new StringTokenizer(c1,"<>/'\"");
         if(stok.hasMoreTokens())
         {
            d=stok.nextToken();
            PreparedStatement st6=conn.prepareStatement("select tocrawl from url1 where tocrawl= ? ");
            st6.setString(1,d);
            ResultSet rs6=st6.executeQuery();
            if(rs6.next())
            {
              q=a.indexOf("http://",++q);
              continue;
            }
            else
            {
            try
            {
            PreparedStatement st3=conn.prepareStatement("insert into url1 values( ? )");
            st3.setString(1,d);
            st3.executeUpdate();
            }
            catch(Exception ex)
            {
               System.out.println("hi1"+ex);
               q=a.indexOf("http://",++q);
               continue;
            }  
            }
         }
         q=a.indexOf("http://",++q);
       }   
   }

   st1=conn.prepareStatement("insert into url2 values( ? )");
   st1.setString(1,str1);
   st1.executeUpdate();
   st1=conn.prepareStatement("delete from url1 where tocrawl= ? ");
   st1.setString(1,str1);
   st1.executeUpdate();
   rs=st.executeQuery("select tocrawl from url1 limit 0,100");
  
  
  }

  }
 
}