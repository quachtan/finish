package fpt.finish.severlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import fpt.finish.Dao.UserDao;
import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;


@WebServlet(urlPatterns = { "/huyphong" })
public class Huyphong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Huyphong() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response1)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String id = request.getParameter("id");

		String errorString = null;

		try {
			DBUtils.huyphong(conn, id);
			final String APIKey = "BAB12D0B7ABC291AB754A3EFE8DAE8";// Dang ky
																	// tai
			// khoan tai
			// esms.vn de
			// lay Key
			final String SecretKey = "B1FEDE65E059C17CAB657E91BE4BB7";
		
			
		
			// mail
			response1.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response1.getWriter();
			List<User_haui> user_haui = UserDao.findAll1(conn);
			for (int i = 0; i < user_haui.size(); i++) {
				User_haui usermail = new User_haui();
				usermail.setEmail(user_haui.get(i).getEmail());

				/*String to = usermail.getEmail();
				String subject = "xin chao!";
				String message = "toi vua huy phong" + pm.getTenphong() + "ca" + ca;
				String user = "choanhbenemnhe83@gmail.com";
				String pass = "trongmaiyeuha";
				SendMail.send(to, subject, message, user, pass);
				out.println("Mail send successfully");*/
				////// sms

				String url = "https://sms4geeks.appspot.com/smsgateway?action=out&username=trongngoc&password=20919961234&msisdn="+user_haui.get(i).getSdt()+"&msg=hello";

				URL obj;
				try {
					obj = new URL(url);

					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					// you need to encode ONLY the values of the parameters

					con.setRequestMethod("GET");
					con.setRequestProperty("Accept", "application/json");

					int responseCode = con.getResponseCode();
					System.out.println("\nSending 'GET' request to URL : " + url);
					System.out.println("Response Code : " + responseCode);
					if (responseCode == 200)// Ðã g?i URL thành công, tuy nhiên
											// b?n
					// ph?i t? ki?m tra CodeResult xem tin
					// nh?n có g?i thành công không, vì có
					// th? tài kho?n b?n không d? ti?n thì
					// s? th?t b?i
					{
						// Check CodeResult from response
					}
					// Ð?c Response
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					JSONObject json = (JSONObject) new JSONParser().parse(response.toString());
					System.out.println("CodeResult=" + json.get("CodeResult"));
					System.out.println("SMSID=" + json.get("SMSID"));
					System.out.println("ErrorMessage=" + json.get("ErrorMessage"));
					// document.getElementsByTagName("CountRegenerate").item(0).va
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// return "SUCCESS";

			}
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Nếu có lỗi, forward (chuyển tiếp) sang trang thông báo lỗi.
		if (errorString != null) {
			// Lưu thông tin vào request attribute trước khi forward sang views.
			request.setAttribute("errorString", errorString);
			//
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/deleteProductErrorView.jsp");
			dispatcher.forward(request, response1);
		}
		// Nếu mọi thứ tốt đẹp.
		// Redirect (chuyển hướng) sang trang danh sách sản phẩm.
		else {
			response1.sendRedirect(request.getContextPath() + "/thoikhoabieu");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
