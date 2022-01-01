package com.formularios.interceptos;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("Es un metodo del controlador: " + metodo.getMethod().getName());
		}
		
		logger.info("TiempoTranscurridoInterceptor: preHandle()... entrando");
		logger.info("Interceptando Handle: " + handler);
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		Random random = new Random();
		Integer demora = random.nextInt(1000);
		
		Thread.sleep(demora);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//Hay que interceptar en el pre como en el post sino da un error 
		if(request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		Long tiempoFin = System.currentTimeMillis();
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		if(handler instanceof HandlerMethod && modelAndView != null) {
			//Si no se agrega un identificador, en este caso tiempoTranscurrido, el valor sale como null
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		}
		logger.info("TiempoTranscurridoInterceptor: " + tiempoTranscurrido + " ms");
		logger.info("TiempoTranscurridoInterceptor: postHandle()... saliendo");
	}
}
