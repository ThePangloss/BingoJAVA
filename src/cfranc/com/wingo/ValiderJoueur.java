package cfranc.com.wingo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiderJoueur
 */
@WebServlet("/form.html")
public class ValiderJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Timer timerStart = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderJoueur() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		
		List<User> listUser = (List<User>) (this.getServletContext().getAttribute("listeUser"));
		if(listUser==null) listUser = new ArrayList<User>();
		
		for (Iterator<User> it = listUser.iterator(); it.hasNext();) {
			if (login.equals(it.next().getLogin())) {
				response.sendRedirect("index.html");
				return;
			}
		}
		
		listUser.add(new User(login));
//		if (listUser.size() > 1)
response.sendRedirect("carte.html?" + login);
		
//		response.sendRedirect("carte.html?" + login);
		
//		if (listUser.size() > 1 && timerStart == null) {
//			TimerTask vodTimer = new VodTimerTask();
//			timerStart = new Timer();
//			timerStart.schedule(vodTimer, 0, (10000));
//			response.sendRedirect("carte.html?" + login);
//		}	
		
	}
	
//	class VodTimerTask extends TimerTask {
//
//		@Override
//		public void run() {
//				timerStart.cancel();
//				response.sendRedirect("index.html");
//		}
//	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
