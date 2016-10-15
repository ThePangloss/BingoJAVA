package cfranc.com.wingo;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimerBingo
 */
@WebServlet("/TimerBingo")
public class TimerBingo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private HttpServletResponse res;
	private static Timer timer;
	private int i = 75;
	private TirageNew tirage=new TirageNew();
	private int numeroTire = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimerBingo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (timer == null) {
			

			TimerTask vodTimer = new VodTimerTask();

			timer = new Timer();
			timer.schedule(vodTimer, 100, (2 * 1000));
		}
		
		response.getWriter().append("" + numeroTire);

	}

	class VodTimerTask extends TimerTask {

		@Override
		public void run() {
			numeroTire = tirage.tirageNumero();
//			if (i <= 0)
//				timer.cancel();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

