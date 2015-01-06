import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by neteat on 29.12.2014.
 */
public  class VK {
    public static String access_token = "";
    public static final int client_id = 1;
    public static final String client_secret = "";
    private static boolean debug = false;
    public int test_mode = 0;

    public String getAccess_token() {
        return VK.access_token;
    }

    public void setAccess_token(String token) {
        VK.access_token = token;
    }

    protected static void Debug() {
        VK.debug = !VK.debug;
    }

    private static String readStreamToString(InputStream in, String encoding) throws IOException {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(in, encoding);
        int cur;
        while ((cur = reader.read()) != -1) {
            buffer.append((char) cur);
        }
        return buffer.toString();
    }

    public static String exec_method(String query, boolean is_token) throws IOException {
        if (is_token) query += "&access_token=" + access_token;
        String toURL = "https://api.vk.com/method/" + query;
        URLConnection connection = new URL(toURL).openConnection();
        String data = readStreamToString(connection.getInputStream(), "UTF-8");
        if (debug) System.out.println(toURL);
        return data;
    }

    static class users {

        public static String get(String u_ids, String fields, String name_case) throws IOException {
            String q = "users.get?user_id=" + u_ids + "&fields=" + fields + "&name_case=" + name_case;
            return exec_method(q, true);
        }

        public static  String get(String u_ids) throws IOException {
            String q = "users.get?user_id=" + u_ids;
            return exec_method(q, false);
        }

        /* public String search(String q,int sort,int offset,int count,String fields,int city,int country,String hometown,
                              int sex, int status, int age_from,int age_to,int b_day,int b_month,int b_year,int online,
                              int has_photo,String interests,int group_id) {
         }*/

        public static  String getSubscriptions(String u_id) throws IOException {
            String q = "users.getSubscriptions?user_id=" + u_id;
            return exec_method(q, false);
        }

        public static  String getSubscriptions(String u_id, String fields) throws IOException {
            String q = "users.getSubscriptions?user_id=" + u_id + "&fields=" + fields;
            return exec_method(q, false);
        }

        public static  String getSubscriptions(String u_id, int extended, int offset, int count, String fields) throws IOException {
            String q = "users.getSubscriptions?user_id=" + u_id + "&extended=" + extended + "&offset=" + offset + "&count=" + count + "&fields=" + fields;
            return exec_method(q, false);
        }

        public static  String getFollowers(String u_id) throws IOException {
            String q = "users.getFollowers?user_id=" + u_id;
            return exec_method(q, false);
        }

        public static  String getFollowers(String u_id, String fields, String name_case) throws IOException {
            String q = "users.getFollowers?user_id=" + u_id + "&fields=" + fields + "&name_case=" + name_case;
            return exec_method(q, false);
        }

        public static  String getFollowers(String u_id, int offset, int count, String fields, String name_case) throws IOException {
            String q = "users.getFollowers?user_id=" + u_id + "&offset=" + offset + "&count=" + count + "&fields=" + fields + "&name_case=" + name_case;
            return exec_method(q, false);
        }

        public static  String report(String u_id, String type, String comment) throws IOException {
            String q = "users.report?user_id=" + u_id + "&type=" + type + "&comment=" + comment;
            return exec_method(q, true);
        }

        public static  String report(String u_id, String type) throws IOException {
            String q = "users.report?user_id=" + u_id + "&type=" + type;
            return exec_method(q, true);
        }

        public static  String getNearby(Double latitude, Double longitude, int accuracy, int timeout, int radius, String fields, String name_case) throws IOException {
            String q = "users.getNearby?latitude=" + latitude + "&longitude=" + longitude + "&accuracy=" + accuracy + "&timeout=" + timeout + "&radius=" + radius + "&fields=" + fields + "&name_case=" + name_case;
            return exec_method(q, true);
        }

        public static  String getNearby(Double latitude, Double longitude, String fields, String name_case) throws IOException {
            String q = "users.getNearby?latitude=" + latitude + "&longitude=" + longitude + "&fields=" + fields + "&name_case=" + name_case;
            return exec_method(q, true);
        }
    }

    static  class auth {
        public static String checkPhone(String ph_no) throws IOException {
            String q = "auth.checkPhone?phone=" + ph_no + "&client_id=" + client_id + "&client_secret=" + client_secret;
            return exec_method(q, false);
        }

        public static  String signup(String f_name, String l_name, String ph_no, String pwd, boolean test_mode, boolean voice, int sex) throws IOException {
            String q = "auth.signup?first_name=" + f_name + "&last_name=" + l_name + "&client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&password=" + pwd + "&test_mode=" + test_mode + "&voice=" + voice + "&sex=" + sex;
            return exec_method(q, false);
        }

        public static  String signup(String f_name, String l_name, String ph_no, boolean test_mode, boolean voice, int sex) throws IOException {
            String q = "auth.signup?first_name=" + f_name + "&last_name=" + l_name + "&client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&test_mode=" + test_mode + "&voice=" + voice + "&sex=" + sex;
            return exec_method(q, false);
        }

        public static  String signup(String f_name, String l_name, String ph_no, String pwd, boolean test_mode, boolean voice, int sex, String sid) throws IOException {
            String q = "auth.signup?first_name=" + f_name + "&last_name=" + l_name + "&client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&password=" + pwd + "&test_mode=" + test_mode + "&voice=" + voice + "&sex=" + sex + "&sid=" + sid;
            return exec_method(q, false);
        }

        public static  String signup(String f_name, String l_name, String ph_no, boolean test_mode, boolean voice, int sex, String sid) throws IOException {
            String q = "auth.signup?first_name=" + f_name + "&last_name=" + l_name + "&client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&test_mode=" + test_mode + "&voice=" + voice + "&sex=" + sex + "&sid=" + sid;
            return exec_method(q, false);
        }

        public static  String confirm(String ph_no, String code, String pwd, boolean test_mode, int intro) throws IOException {
            String q = "auth.conform?client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&code=" + code + "&password=" + pwd + "&test_mode=" + test_mode + "intro=" + intro;
            return exec_method(q, false);
        }

        public static  String confirm(String ph_no, String code, boolean test_mode, int intro) throws IOException {
            String q = "auth.conform?client_id=" + client_id + "&client_secret=" + client_secret + "&phone=" + ph_no + "&code=" + code + "&test_mode=" + test_mode + "intro=" + intro;
            return exec_method(q, false);
        }
    }

    static  class wall {
        public static  String get(String u_id, String domain, int offset, int count, String filter, boolean extended) throws IOException {
            String q = "wall.get?owner_id=" + u_id + "&domain=" + domain + "&offset=" + offset + "&count=" + count + "&filter=" + filter + "extended=" + extended;
            return exec_method(q, true);
        }

        public static  String get(String u_id) throws IOException {
            String q = "wall.get?owner_id=" + u_id;
            return exec_method(q, true);
        }

        public static  String get(String u_id, int offset, int count, String filter) throws IOException {
            String q = "wall.get?owner_id=" + u_id + "&offset=" + offset + "&count=" + count + "&filter=" + filter;
            return exec_method(q, true);
        }
        public static String search(String owner_id,String query,boolean own_only,int count,int offset,boolean extended) throws IOException {
            String q="wall.search?owner_id="+owner_id+"&query="+query+"&owners_only="+own_only+"&count="+count+"&offset="+offset+"&extended="+extended;
            return exec_method(q,false);
        }
        public static String search(String domain,String query,boolean own_only,boolean extended) throws IOException {
            String q="wall.search?domain="+domain+"&query="+query+"&owners_only="+own_only+"&extended="+extended;
            return exec_method(q,false);
        }
        public static String getById(String posts, boolean extended,int copy_h_depth) throws IOException {
            String q="wall.getById?posts="+posts+"&extended="+extended+"&copy_history_depth="+copy_h_depth;
            return exec_method(q,false);
        }
        public static String post(String owner_id,boolean fr_only,boolean from_group, String msg, String attach,String services,boolean signed,long pdate,double lat,double lng) throws IOException {
            String q="wall.post?owner_id="+owner_id+"&friends_only="+fr_only+"&from_group="+from_group+"&message="+msg+
                    "&attachments="+attach+"&services="+services+"&signed="+signed+"&publish_date="+pdate+"&lat="+lat+
                    "&long="+lng;
            return exec_method(q,true);
        }
        public static String post(String owner_id,boolean fr_only,boolean from_group,String msg) throws IOException {
            String q="wall.post?owner_id="+owner_id+"&friends_only="+fr_only+"&from_group="+from_group+"&message="+msg;
            return exec_method(q,true);
        }
        public static String post(String owner_id,long pdate,long post_id) throws IOException {
            String q="wall.post?owner_id="+owner_id+"&publish_date="+pdate+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static String repost(String obj,String msg,long group_id) throws IOException {
            String q="wall.repost?object="+obj+"&message="+msg+"&group_id="+group_id;
            return exec_method(q,true);
        }
        public static String repost(String obj,String msg) throws IOException {
            String q="wall.repost?object="+obj+"&message="+msg;
            return exec_method(q,true);
        }
        public static String repost(String obj,long group_id) throws IOException {
            String q="wall.repost?object="+obj+"&group_id="+group_id;
            return exec_method(q,true);
        }
        public static String repost(String obj) throws IOException {
            String q="wall.repost?object="+obj;
            return exec_method(q,true);
        }
        public static String getReposts(String owner_id,long post_id,long offset,int count) throws IOException {
            String q="wall.getReposts?owner_id="+owner_id+"&post_id="+post_id+"&offset="+offset+"&count="+count;
            return exec_method(q,true);
        }
        public static String getReposts(String owner_id,long post_id) throws IOException {
            String q="wall.getReposts?owner_id="+owner_id+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static String delete(String owner_id,long post_id) throws IOException {
            String q="wall.delete?owner_id="+owner_id+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static  String restore(String owner_id,long post_id) throws IOException {
            String q="wall.restore?owner_id="+owner_id+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static  String pin(String owner_id,long post_id) throws IOException {
            String q="wall.pin?owner_id="+owner_id+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static  String unpin(String owner_id,long post_id) throws IOException {
            String q="wall.unpin?owner_id="+owner_id+"&post_id="+post_id;
            return exec_method(q,true);
        }
        public static String getComments(String owner_id,long post_id,boolean need_likes,int offset,int count,String sort,int length,boolean extended) throws IOException {
            String q="wall.getComments?owner_id="+owner_id+"&post_id="+post_id+"&need_likes="+need_likes+"&offset="+offset+"&count="+count+"&sort="+sort+"&preview_length="+length+"&extended="+extended;
            return exec_method(q,true);
        }
        public static String editComment(String owner_id,long comment_id,String msg,String attach) throws IOException {
            String q="wall.editComment?owner_id="+owner_id+"&comment_id="+comment_id+"&message="+msg+"&attachments="+attach;
            return exec_method(q,true);
        }


    }

}