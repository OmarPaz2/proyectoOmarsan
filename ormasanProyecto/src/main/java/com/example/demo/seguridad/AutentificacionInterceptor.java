package com.example.demo.seguridad;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AutentificacionInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {

HttpSession session = request.getSession(false);

if (session != null && session.getAttribute("usuarioIniciado") != null) {
return true; // continúa con la solicitud
}
System.out.println("TAL VEZ TE ENVIO AL LOGIN DESDE INTERPTOR");
// Redirigir al login
response.sendRedirect(request.getContextPath()+"/inicioSesion");

return false;
}
}
