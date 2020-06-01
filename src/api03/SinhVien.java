package api03;

import constants.Const;
import io.ProcessHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


/**
 * Servlet implementation class Get
 */

@WebServlet("/api03/*")
public class SinhVien extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // java -classpath $path CheckSerVerLive $port

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVien() {
        super();
    }

    public static String removeForwardSlash(String str, String obj) {
        int idx = str.indexOf(obj);
        return str.substring(idx);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> list;
        String action = "sinhvien";

        // 103.81.86.156:8080/apiThitracnghiem/api03/SinhVien/postFavourite


        String servletPath = removeForwardSlash(request.getRequestURI(), "SinhVien");
        String[] pathParts = servletPath.split("/");
        if (pathParts.length == 2) {
            if (pathParts[1].equals("postFavourite")) {
                String doing = "postFavourite";
                String username = request.getParameter("userName");
                String pass = request.getParameter("pass");
                String idQuestion = request.getParameter("idQuestion");
                String isFavourite = request.getParameter("isFavourite");
                if (username == null || username.equals("")) {
                    username = "xxx";
                }
                if (pass == null || pass.equals("")) {
                    pass = "0";
                }
                if (idQuestion == null || idQuestion.equals("")) {
                    idQuestion = "129";
                }
                if (isFavourite == null || isFavourite.equals("")) {
                    isFavourite = "0";
                }

                list = Arrays.asList(action, doing, username, pass, idQuestion, isFavourite);
                out.println(ProcessHandle.newMyJavaHandleProcess(Const.INPUT_JAR_PATH, list));
            } else if (pathParts[1].equals("postDapAn_Bailam")) {
                String doing = "postDapAn_Bailam";
                // 103.81.86.156:8080/apiThitracnghiem/api01/SinhVien/postDapAn_Bailam

                String username = request.getParameter("userName");
                String pass = request.getParameter("pass");
                String bai_thi = request.getParameter("bai_thi");
                String dap_an_a = request.getParameter("dap_an_a");
                String dap_an_b = request.getParameter("dap_an_b");
                String dap_an_c = request.getParameter("dap_an_c");
                String dap_an_d = request.getParameter("dap_an_d");
                String dap_an_e = request.getParameter("dap_an_e");
                String dap_an_f = request.getParameter("dap_an_f");
                String isSubmited = request.getParameter("isSubmited");

                if (username == null || username.equals("")) {
                    username = "xxx";
                }
                if (pass == null || pass.equals("")) {
                    pass = "0";
                }
                if (bai_thi == null || bai_thi.equals("")) {
                    bai_thi = "0";
                }
                if (dap_an_a == null || dap_an_a.equals("")) {
                    dap_an_a = "null";
                }
                if (dap_an_b == null || dap_an_b.equals("")) {
                    dap_an_b = "null";
                }
                if (dap_an_c == null || dap_an_c.equals("")) {
                    dap_an_c = "null";
                }
                if (dap_an_d == null || dap_an_d.equals("")) {
                    dap_an_d = "null";
                }
                if (dap_an_e == null || dap_an_e.equals("")) {
                    dap_an_e = "null";
                }
                if (dap_an_f == null || dap_an_f.equals("")) {
                    dap_an_f = "null";
                }

                if (isSubmited == null || isSubmited.equals("")) {
                    isSubmited = "0";
                }

                list = Arrays.asList(action, doing, username, pass, bai_thi, dap_an_a, dap_an_b, dap_an_c, dap_an_d, dap_an_e, dap_an_f, isSubmited);
                out.println(ProcessHandle.newMyJavaHandleProcess(Const.INPUT_JAR_PATH, list));
            }
        } else {
            out.println("invalid");
        }
    }

}
