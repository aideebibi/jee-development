/**
 * Este software puede ser modificado o utilizado haciendo referencia al autor.
 * 28/07/2017
 */
package net.jorgerdc.jee.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Ejemplo Basico que ilustra la creación de un Servlet.
 * 
 * @author Jorge A. Rodriguez Campos (jorgerdc@gmail.com)
 */
@WebServlet("/holaMundo")
@Slf4j
public class HolaMundoServlet extends HttpServlet {

    private static final long serialVersionUID = 5164197969010934448L;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder sb;
        log.debug("Generando saludo.");

        // esta es la forma más basica y arcaica para generar contenido. Nadie
        // lo hace en la práctica, pero siempre es bueno saber el origen de la
        // vida ! Por eso es el hola mundo.
        sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><title>Hola mundo con Servlet</title></head>");
        sb.append("<body> <h1> Hola Mundo desde servlet<br> ");
        sb.append("Fecha  y hora actual: ");
        sb.append(new Date()).append("</h1></body></html>");

        // tipo de contenido a mostrar, en este caso texto, html
        response.setContentType("text/html");

        // obteniendo referencia de un PrintWriter para enviar el contenido al
        // cliente
        // uso de un autoclosable try-catch
        try (PrintWriter out = response.getWriter()) {
            out.write(sb.toString());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Redirigiendo  a doGet");
        doGet(req, resp);
    }

}
