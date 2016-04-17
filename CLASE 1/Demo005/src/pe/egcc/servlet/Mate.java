package pe.egcc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.service.MateService;

@WebServlet({"/Sumar","/Restar","/Multiplicar"})
public class Mate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MateService mateService;
	
	public void init() throws ServletException{
		
		
		
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  String path = request.getServletPath();
	  
	  if(path.equals("/Sumar")){
	    sumar(request, response);
	  } else if(path.equals("/Restar")){
      restar(request, response);
    } else if(path.equals("/Multiplicar")){
      multiplicar(request, response);
    } 
	  
	}
	
	protected void sumar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // Datos
	  int num1 = Integer.parseInt(request.getParameter("n1"));
	  int num2 = Integer.parseInt(request.getParameter("n2"));
	  
	  // Proceso
	  int suma = num1 + num2;
	  
	  // Reporte
	  request.setAttribute("num1", num1);
	  request.setAttribute("num2", num2);
	  request.setAttribute("rpta", suma);
	  request.setAttribute("opera", "SUMAR");
	  
	mostrar(request,response);
	}

	protected void restar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // Datos
	  int num1 = Integer.parseInt(request.getParameter("n1"));
	  int num2 = Integer.parseInt(request.getParameter("n2"));
	  
	  // Proceso
	  int resta = num1 - num2;
	  
	  // Reporte
	  request.setAttribute("num1", num1);
	  request.setAttribute("num2", num2);
	  request.setAttribute("rpta", resta);
	  request.setAttribute("opera", "RESTAR");
	  
	  mostrar(request,response);
	}

	protected void multiplicar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // Datos
	  int num1 = Integer.parseInt(request.getParameter("n1"));
	  int num2 = Integer.parseInt(request.getParameter("n2"));
	  
	  // Proceso
	  int value = num1 * num2;
	  
	  // Reporte
	  request.setAttribute("num1", num1);
	  request.setAttribute("num2", num2);
	  request.setAttribute("rpta", value);
	  request.setAttribute("opera", "MULTIPLICAR");
	  
	  mostrar(request,response);
	}
	
	
	public void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd;
		
		rd=request.getRequestDispatcher("resultado.jsp");
		rd.forward(request, response);
	
	}
	
	
	
	
}
