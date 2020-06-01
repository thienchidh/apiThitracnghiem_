package api02;

import constants.Const;
import io.ProcessHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;


/**
 * Servlet implementation class Get
 */

@WebServlet("/api02/*")
public class GiangVien extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // java -classpath $path CheckSerVerLive $port

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiangVien() {
        super();
    }

    public static String removeForwardSlash(String str, String obj) {
        int idx = str.indexOf(obj);
        return str.substring(idx);
    }

    public static String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> args;
        String action = "giangvien";

        // 103.81.86.156:8080/apiThitracnghiem/api02/GiangVien/postLichThi_Lop_BaiThi


        String servletPath = removeForwardSlash(request.getRequestURI(), "GiangVien");
        String[] pathParts = servletPath.split("/");
        if (pathParts.length == 2) {
            if (pathParts[1].equals("postLichThi_Lop_BaiThi")) {
                String doing = "postLichThi_Lop_BaiThi";

                String thoi_gian_bat_dau = request.getParameter("thoi_gian_bat_dau"); //"2019-07-24 11:00:00";
                String bao_lau = request.getParameter("bao_lau");
                String lop = request.getParameter("lop");
                String ten_bai_thi = request.getParameter("ten_bai_thi");
                String username = request.getParameter("userName");
                String pass = request.getParameter("pass");
                if (thoi_gian_bat_dau == null) {
                    thoi_gian_bat_dau = "2019-07-24 11:00:00";
                }
                if (bao_lau == null || bao_lau.equals("")) {
                    bao_lau = "0";
                }
                if (lop == null || lop.equals("")) {
                    lop = "0";
                }
                if (ten_bai_thi == null || ten_bai_thi.equals("")) {
                    ten_bai_thi = "0";
                }
                if (username == null || username.equals("")) {
                    username = "0";
                }
                if (pass == null || pass.equals("")) {
                    pass = "0";
                }

                args = Arrays.asList(action, doing, encode(thoi_gian_bat_dau), encode(bao_lau), encode(lop), encode(ten_bai_thi), encode(username), encode(pass));
                out.println(ProcessHandle.newMyJavaHandleProcess(Const.INPUT_JAR_PATH, args));
                //out.println("{" + result + "}");
            }

        } else {
            out.println("invalid");
        }
    }

}
