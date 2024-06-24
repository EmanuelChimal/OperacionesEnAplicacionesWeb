
package Componentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan DoubleEight4
 */
public class LocalidadDAOImp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LocalidadDAOImp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LocalidadDAOImp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    public  List<Localidad> readALL() throws SQLException {
        List<Localidad> localidades = new ArrayList();
        conn = conMYSQL.getConnection ();
        String Query = "SELECT l.idEntidad, "
                +"l.nombreLocalidad, l.idEntidad, e.nombreEntidad"
                + "FROM Localidades l JOIN Entidades e"
                + "ON l.idEntidad = e.idEntidad";
        try (PreparedStatement ps = conn.prepareStatement(Query)) {
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Localidad localidad = new Localidad(
                        rs.getInt("idLocalidad"),
                        rs.getString("nombreLocalidad"),
                        rs.getInt("idEntidad"));
                    localidad.setEntidad(new Entidad(
                            rs.getInt("idEntidad"),
                            rs.getString("nombreEntidad")));
                    localidades.add(localidad);
                }
                
    }
}
    return localidades;
}
}
