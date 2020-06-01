package api01;

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

@WebServlet("/api01/*")
public class General extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // java -classpath $path CheckSerVerLive $port

    /**
     * @see HttpServlet#HttpServlet()
     */
    public General() {
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

    public static String compound2Unicode(String str) {
        str = str.replaceAll("\u0065\u0309", "\u1EBB"); // ẻ
        str = str.replaceAll("\u0065\u0301", "\u00E9"); // é
        str = str.replaceAll("\u0065\u0300", "\u00E8"); // è
        str = str.replaceAll("\u0065\u0323", "\u1EB9"); // ẹ
        str = str.replaceAll("\u0065\u0303", "\u1EBD"); // ẽ
        str = str.replaceAll("\u00EA\u0309", "\u1EC3"); // ể
        str = str.replaceAll("\u00EA\u0301", "\u1EBF"); // ế
        str = str.replaceAll("\u00EA\u0300", "\u1EC1"); // ề
        str = str.replaceAll("\u00EA\u0323", "\u1EC7"); // ệ
        str = str.replaceAll("\u00EA\u0303", "\u1EC5"); // ễ
        str = str.replaceAll("\u0079\u0309", "\u1EF7"); // ỷ
        str = str.replaceAll("\u0079\u0301", "\u00FD"); // ý
        str = str.replaceAll("\u0079\u0300", "\u1EF3"); // ỳ
        str = str.replaceAll("\u0079\u0323", "\u1EF5"); // ỵ
        str = str.replaceAll("\u0079\u0303", "\u1EF9"); // ỹ
        str = str.replaceAll("\u0075\u0309", "\u1EE7"); // ủ
        str = str.replaceAll("\u0075\u0301", "\u00FA"); // ú
        str = str.replaceAll("\u0075\u0300", "\u00F9"); // ù
        str = str.replaceAll("\u0075\u0323", "\u1EE5"); // ụ
        str = str.replaceAll("\u0075\u0303", "\u0169"); // ũ
        str = str.replaceAll("\u01B0\u0309", "\u1EED"); // ử
        str = str.replaceAll("\u01B0\u0301", "\u1EE9"); // ứ
        str = str.replaceAll("\u01B0\u0300", "\u1EEB"); // ừ
        str = str.replaceAll("\u01B0\u0323", "\u1EF1"); // ự
        str = str.replaceAll("\u01B0\u0303", "\u1EEF"); // ữ
        str = str.replaceAll("\u0069\u0309", "\u1EC9"); // ỉ
        str = str.replaceAll("\u0069\u0301", "\u00ED"); // í
        str = str.replaceAll("\u0069\u0300", "\u00EC"); // ì
        str = str.replaceAll("\u0069\u0323", "\u1ECB"); // ị
        str = str.replaceAll("\u0069\u0303", "\u0129"); // ĩ
        str = str.replaceAll("\u006F\u0309", "\u1ECF"); // ỏ
        str = str.replaceAll("\u006F\u0301", "\u00F3"); // ó
        str = str.replaceAll("\u006F\u0300", "\u00F2"); // ò
        str = str.replaceAll("\u006F\u0323", "\u1ECD"); // ọ
        str = str.replaceAll("\u006F\u0303", "\u00F5"); // õ
        str = str.replaceAll("\u01A1\u0309", "\u1EDF"); // ở
        str = str.replaceAll("\u01A1\u0301", "\u1EDB"); // ớ
        str = str.replaceAll("\u01A1\u0300", "\u1EDD"); // ờ
        str = str.replaceAll("\u01A1\u0323", "\u1EE3"); // ợ
        str = str.replaceAll("\u01A1\u0303", "\u1EE1"); // ỡ
        str = str.replaceAll("\u00F4\u0309", "\u1ED5"); // ổ
        str = str.replaceAll("\u00F4\u0301", "\u1ED1"); // ố
        str = str.replaceAll("\u00F4\u0300", "\u1ED3"); // ồ
        str = str.replaceAll("\u00F4\u0323", "\u1ED9"); // ộ
        str = str.replaceAll("\u00F4\u0303", "\u1ED7"); // ỗ
        str = str.replaceAll("\u0061\u0309", "\u1EA3"); // ả
        str = str.replaceAll("\u0061\u0301", "\u00E1"); // á
        str = str.replaceAll("\u0061\u0300", "\u00E0"); // à
        str = str.replaceAll("\u0061\u0323", "\u1EA1"); // ạ
        str = str.replaceAll("\u0061\u0303", "\u00E3"); // ã
        str = str.replaceAll("\u0103\u0309", "\u1EB3"); // ẳ
        str = str.replaceAll("\u0103\u0301", "\u1EAF"); // ắ
        str = str.replaceAll("\u0103\u0300", "\u1EB1"); // ằ
        str = str.replaceAll("\u0103\u0323", "\u1EB7"); // ặ
        str = str.replaceAll("\u0103\u0303", "\u1EB5"); // ẵ
        str = str.replaceAll("\u00E2\u0309", "\u1EA9"); // ẩ
        str = str.replaceAll("\u00E2\u0301", "\u1EA5"); // ấ
        str = str.replaceAll("\u00E2\u0300", "\u1EA7"); // ầ
        str = str.replaceAll("\u00E2\u0323", "\u1EAD"); // ậ
        str = str.replaceAll("\u00E2\u0303", "\u1EAB"); // ẫ
        str = str.replaceAll("\u0045\u0309", "\u1EBA"); // Ẻ
        str = str.replaceAll("\u0045\u0301", "\u00C9"); // É
        str = str.replaceAll("\u0045\u0300", "\u00C8"); // È
        str = str.replaceAll("\u0045\u0323", "\u1EB8"); // Ẹ
        str = str.replaceAll("\u0045\u0303", "\u1EBC"); // Ẽ
        str = str.replaceAll("\u00CA\u0309", "\u1EC2"); // Ể
        str = str.replaceAll("\u00CA\u0301", "\u1EBE"); // Ế
        str = str.replaceAll("\u00CA\u0300", "\u1EC0"); // Ề
        str = str.replaceAll("\u00CA\u0323", "\u1EC6"); // Ệ
        str = str.replaceAll("\u00CA\u0303", "\u1EC4"); // Ễ
        str = str.replaceAll("\u0059\u0309", "\u1EF6"); // Ỷ
        str = str.replaceAll("\u0059\u0301", "\u00DD"); // Ý
        str = str.replaceAll("\u0059\u0300", "\u1EF2"); // Ỳ
        str = str.replaceAll("\u0059\u0323", "\u1EF4"); // Ỵ
        str = str.replaceAll("\u0059\u0303", "\u1EF8"); // Ỹ
        str = str.replaceAll("\u0055\u0309", "\u1EE6"); // Ủ
        str = str.replaceAll("\u0055\u0301", "\u00DA"); // Ú
        str = str.replaceAll("\u0055\u0300", "\u00D9"); // Ù
        str = str.replaceAll("\u0055\u0323", "\u1EE4"); // Ụ
        str = str.replaceAll("\u0055\u0303", "\u0168"); // Ũ
        str = str.replaceAll("\u01AF\u0309", "\u1EEC"); // Ử
        str = str.replaceAll("\u01AF\u0301", "\u1EE8"); // Ứ
        str = str.replaceAll("\u01AF\u0300", "\u1EEA"); // Ừ
        str = str.replaceAll("\u01AF\u0323", "\u1EF0"); // Ự
        str = str.replaceAll("\u01AF\u0303", "\u1EEE"); // Ữ
        str = str.replaceAll("\u0049\u0309", "\u1EC8"); // Ỉ
        str = str.replaceAll("\u0049\u0301", "\u00CD"); // Í
        str = str.replaceAll("\u0049\u0300", "\u00CC"); // Ì
        str = str.replaceAll("\u0049\u0323", "\u1ECA"); // Ị
        str = str.replaceAll("\u0049\u0303", "\u0128"); // Ĩ
        str = str.replaceAll("\u004F\u0309", "\u1ECE"); // Ỏ
        str = str.replaceAll("\u004F\u0301", "\u00D3"); // Ó
        str = str.replaceAll("\u004F\u0300", "\u00D2"); // Ò
        str = str.replaceAll("\u004F\u0323", "\u1ECC"); // Ọ
        str = str.replaceAll("\u004F\u0303", "\u00D5"); // Õ
        str = str.replaceAll("\u01A0\u0309", "\u1EDE"); // Ở
        str = str.replaceAll("\u01A0\u0301", "\u1EDA"); // Ớ
        str = str.replaceAll("\u01A0\u0300", "\u1EDC"); // Ờ
        str = str.replaceAll("\u01A0\u0323", "\u1EE2"); // Ợ
        str = str.replaceAll("\u01A0\u0303", "\u1EE0"); // Ỡ
        str = str.replaceAll("\u00D4\u0309", "\u1ED4"); // Ổ
        str = str.replaceAll("\u00D4\u0301", "\u1ED0"); // Ố
        str = str.replaceAll("\u00D4\u0300", "\u1ED2"); // Ồ
        str = str.replaceAll("\u00D4\u0323", "\u1ED8"); // Ộ
        str = str.replaceAll("\u00D4\u0303", "\u1ED6"); // Ỗ
        str = str.replaceAll("\u0041\u0309", "\u1EA2"); // Ả
        str = str.replaceAll("\u0041\u0301", "\u00C1"); // Á
        str = str.replaceAll("\u0041\u0300", "\u00C0"); // À
        str = str.replaceAll("\u0041\u0323", "\u1EA0"); // Ạ
        str = str.replaceAll("\u0041\u0303", "\u00C3"); // Ã
        str = str.replaceAll("\u0102\u0309", "\u1EB2"); // Ẳ
        str = str.replaceAll("\u0102\u0301", "\u1EAE"); // Ắ
        str = str.replaceAll("\u0102\u0300", "\u1EB0"); // Ằ
        str = str.replaceAll("\u0102\u0323", "\u1EB6"); // Ặ
        str = str.replaceAll("\u0102\u0303", "\u1EB4"); // Ẵ
        str = str.replaceAll("\u00C2\u0309", "\u1EA8"); // Ẩ
        str = str.replaceAll("\u00C2\u0301", "\u1EA4"); // Ấ
        str = str.replaceAll("\u00C2\u0300", "\u1EA6"); // Ầ
        str = str.replaceAll("\u00C2\u0323", "\u1EAC"); // Ậ
        str = str.replaceAll("\u00C2\u0303", "\u1EAA"); // Ẫ
        return str;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> args = null;
        String action = "general";

        // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getListQuestion&key=%C4%90i%E1%BB%87n%20Bi%C3%AAn%20Ph%E1%BB%A7&startId=0

        String doing = request.getParameter("doing");
        String key = request.getParameter("key");
        String startId = request.getParameter("startId");
        String mssv = request.getParameter("mssv");

        if (doing == null) {
            doing = "getListQuestion";
        }
        if (startId == null) {
            startId = "0";
        }
        if (key == null || key.equals("")) {
            key = "null";
        }
        if (mssv == null || mssv.equals("")) {
            mssv = "null";
        }


        key = compound2Unicode(key);
        key = encode(key);

        String servletPath = removeForwardSlash(request.getRequestURI(), "General");
        String[] pathParts = servletPath.split("/");
        if (pathParts.length > 1) {
            out.println("invalid");
            return;
        }
        if (doing.equals("getListQuestion")) {
            args = Arrays.asList(action, doing, key, startId, mssv);
        } else if (doing.equals("getInfo")) {
            // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getDSLop
            // getDSLop

            String actionInfo = request.getParameter("actionInfo");

            if (actionInfo == null || actionInfo.equals("")) {
                actionInfo = "getDSLop";
            }

            if (actionInfo.equals("getDSLop")) {
                args = Arrays.asList(action, doing, actionInfo);
            } else if (actionInfo.equals("getListInfoOfLop")) {
                // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getListInfoOfLop&lop=18CT2

                String lop = request.getParameter("lop");
                mssv = request.getParameter("mssv");

                if (lop == null || lop.equals("")) {
                    lop = "";
                }
                if (mssv == null || mssv.equals("")) {
                    mssv = "0";
                }

                args = Arrays.asList(action, doing, actionInfo, lop, mssv);
            } else if (actionInfo.equals("getFavourite")) {
                // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getFavourite&mssv=1851220146&startId=0

                mssv = request.getParameter("mssv");
                String startIdForFavourite = request.getParameter("startId");

                if (mssv == null || mssv.equals("")) {
                    mssv = "0";
                }
                if (startIdForFavourite == null || startIdForFavourite.equals("")) {
                    startIdForFavourite = "0";
                }


                args = Arrays.asList(action, doing, actionInfo, mssv, startIdForFavourite);
            } else if (actionInfo.equals("getDethi") || actionInfo.equals("getDiem_Baithi")) {
                // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getDethi&mssv=1851220140&bai_thi=18CT2_oXUdgL
                // 103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getDiem_Baithi&mssv=1851220140&bai_thi=18CT2_oXUdgL

                mssv = request.getParameter("mssv");
                String bai_thi = request.getParameter("bai_thi");

                if (mssv == null || mssv.equals("")) {
                    mssv = "0";
                }
                if (bai_thi == null || bai_thi.equals("")) {
                    bai_thi = "0";
                }

                args = Arrays.asList(action, doing, actionInfo, mssv, bai_thi);
            } else if (actionInfo.equals("getInfoDethiOfLopBaithi")) {
                //http://103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getInfoDethiOfLopBaithi&lop=16CT&bai_thi=16CT_rfGH3I&startId=0

                String lop = request.getParameter("lop");
                String bai_thi = request.getParameter("bai_thi");
                startId = request.getParameter("startId");

                if (lop == null || lop.equals("")) {
                    lop = "0";
                }
                if (bai_thi == null || bai_thi.equals("")) {
                    bai_thi = "0";
                }
                if (startId == null || startId.equals("")) {
                    startId = "0";
                }

                args = Arrays.asList(action, doing, actionInfo, lop, bai_thi, startId);
            } else if (actionInfo.equals("getInfoDethiOfMSSVBaithi")) {
                //http://103.81.86.156:8080/apiThitracnghiem/api01/General?doing=getInfo&actionInfo=getInfoDethiOfMSSVBaithi&mssv=1651220013&startId=0

                mssv = request.getParameter("mssv");
                startId = request.getParameter("startId");

                if (mssv == null || mssv.equals("")) {
                    mssv = "0";
                }
                if (startId == null || startId.equals("")) {
                    startId = "0";
                }

                args = Arrays.asList(action, doing, actionInfo, mssv, startId);
            }
        }

        if (args != null) {
            out.println(ProcessHandle.newMyJavaHandleProcess(Const.INPUT_JAR_PATH, args));
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> args;
        String action = "general";
        String doing = "getAuthen";

        // 103.81.86.156:8080/apiThitracnghiem/api01/General/getAuthen

        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");

        if (userName == null) {
            userName = "xxx";
        }
        if (pass == null) {
            pass = "0";
        }
        String servletPath = removeForwardSlash(request.getRequestURI(), "General");
        String[] pathParts = servletPath.split("/");
        if (pathParts.length == 2) {
            if (pathParts[1].equals("getAuthen")) {
                args = Arrays.asList(action, doing, userName, pass);
                out.println(ProcessHandle.newMyJavaHandleProcess(Const.INPUT_JAR_PATH, args));
            }
        } else {
            out.println("invalid");
        }
    }

}
