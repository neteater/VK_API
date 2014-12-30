import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by neteat on 29.12.2014.
 */
public class vk_api {
    /*public boolean oauth() throws IOException {
        String q="client_id="+this.client_id+"&scope="+this.scope+"&redirect_uri="+this.redirect_uri+"&display="+this.display+"&v="+this.v;
        URLConnection connection=new URL("https://oauth.vk.com/authorize?"+q).openConnection();
        String data = readStreamToString(connection.getInputStream(), "UTF-8");
        return true;
    }*/
    public String exec_method(String query,boolean is_token) throws IOException {
        if (is_token) query+="&access_token="+access_token;
        URLConnection connection = new URL("https://api.vk.com/method/"+query).openConnection();
        String data = readStreamToString(connection.getInputStream(), "UTF-8");
        if (debug) System.out.println(data);
        return  data;
    }

        public static String access_token="";
        public static int client_id=1;
        public static String client_secret="";
        private boolean debug=false;
        public int test_mode=0;
        public String getAccess_token() {
        return access_token;
    }
        protected void Debug() {
            this.debug=!this.debug;
        }

    private String readStreamToString(InputStream in,String encoding) throws IOException {
        StringBuffer buffer=new StringBuffer();
        InputStreamReader reader=new InputStreamReader(in,encoding);
        int cur;
        while ((cur=reader.read())!=-1) {
            buffer.append((char)cur);
        }
        return buffer.toString();
    }

}

class users extends vk_api {
         public String get(String u_ids,String fields,String name_case) throws IOException {
             String q="users.get?user_id="+u_ids+"&fields="+fields+"&name_case="+name_case;
             return exec_method(q, true);
         }
         public  String get(String u_ids) throws IOException {
             String q="users.get?user_id="+u_ids;
             return exec_method(q, false);
          }

        /* public String search(String q,int sort,int offset,int count,String fields,int city,int country,String hometown,
                              int sex, int status, int age_from,int age_to,int b_day,int b_month,int b_year,int online,
                              int has_photo,String interests,int group_id) {
                 String s_q;
                         if (q!=null) s_q="q="+q; else s_q="";
                 String srt="&sort";

         }*/
         public String getSubscriptions(String u_id) throws IOException {
             String q="users.getSubscriptions?user_id="+u_id;
             return exec_method(q, false);
         }
         public String getSubscriptions(String u_id,String fields) throws IOException {
             String q="users.getSubscriptions?user_id="+u_id+"&fields="+fields;
             return exec_method(q, false);
         }
         public String getSubscriptions(String u_id,int extended,int offset,int count,String fields) throws IOException {
             String q="users.getSubscriptions?user_id="+u_id+"&extended="+extended+"&offset="+offset+"&count="+count+"&fields="+fields;
             return exec_method(q,false);
         }
         public String getFollowers(String u_id) throws IOException {
             String q="users.getFollowers?user_id="+u_id;
             return exec_method(q, false);
         }
         public String getFollowers(String u_id,String fields,String name_case) throws IOException {
             String q="users.getFollowers?user_id="+u_id+"&fields="+fields+"&name_case="+name_case;
             return exec_method(q, false);
         }
         public String getFollowers(String u_id,int offset,int count,String fields,String name_case) throws IOException {
             String q="users.getFollowers?user_id="+u_id+"&offset="+offset+"&count="+count+"&fields="+fields+"&name_case="+name_case;
             return exec_method(q, false);
         }
         public String report(String u_id,String type,String comment) throws IOException {
             String q="users.report?user_id="+u_id+"&type="+type+"&comment="+comment;
             return exec_method(q, true);
         }
         public String report(String u_id,String type) throws IOException {
             String q="users.report?user_id="+u_id+"&type="+type;
             return exec_method(q, true);
         }
         public String getNearby(Double latitude, Double longitude,int accuracy,int timeout,int radius,String fields,String name_case) throws IOException {
             String q="users.getNearby?latitude="+latitude+"&longitude="+longitude+"&accuracy="+accuracy+"&timeout="+timeout+"&radius="+radius+"&fields="+fields+"&name_case="+name_case;
             return exec_method(q, true);
         }
         public String getNearby(Double latitude, Double longitude,String fields,String name_case) throws IOException {
             String q="users.getNearby?latitude="+latitude+"&longitude="+longitude+"&fields="+fields+"&name_case="+name_case;
             return exec_method(q, true);
         }
      }

class auth extends vk_api {
      public String checkPhone(String ph_no) throws IOException {
          String q="auth.checkPhone?phone="+ph_no+"&client_id="+client_id+"&client_secret="+client_secret;
          return exec_method(q,false);
      }
      public String signup(String f_name,String l_name,String ph_no,String pwd,boolean test_mode,boolean voice,int sex) throws IOException {
          String q="auth.signup?first_name="+f_name+"&last_name="+l_name+"&client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&password="+pwd+"&test_mode="+test_mode+"&voice="+voice+"&sex="+sex;
          return exec_method(q,false);
      }
      public String signup(String f_name,String l_name,String ph_no,boolean test_mode,boolean voice,int sex) throws IOException {
          String q="auth.signup?first_name="+f_name+"&last_name="+l_name+"&client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&test_mode="+test_mode+"&voice="+voice+"&sex="+sex;
          return exec_method(q,false);
      }
      public String signup(String f_name,String l_name,String ph_no,String pwd,boolean test_mode,boolean voice,int sex,String sid) throws IOException {
          String q="auth.signup?first_name="+f_name+"&last_name="+l_name+"&client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&password="+pwd+"&test_mode="+test_mode+"&voice="+voice+"&sex="+sex+"&sid="+sid;
          return exec_method(q,false);
      }
      public String signup(String f_name,String l_name,String ph_no,boolean test_mode,boolean voice,int sex,String sid) throws IOException {
          String q="auth.signup?first_name="+f_name+"&last_name="+l_name+"&client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&test_mode="+test_mode+"&voice="+voice+"&sex="+sex+"&sid="+sid;
          return exec_method(q,false);
      }
      public String confirm(String ph_no,String code,String pwd,boolean test_mode,int intro) throws IOException {
          String q="auth.conform?client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&code="+code+"&password="+pwd+"&test_mode="+test_mode+"intro="+intro;
          return exec_method(q,false);
      }
      public String confirm(String ph_no,String code,boolean test_mode,int intro) throws IOException {
          String q="auth.conform?client_id="+client_id+"&client_secret="+client_secret+"&phone="+ph_no+"&code="+code+"&test_mode="+test_mode+"intro="+intro;
          return exec_method(q,false);
      }
      //restore will be here
  }
