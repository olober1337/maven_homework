package homework13.controller;

import homework13.services.ClientStatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client_status")
public class ClientStatusServlet extends HttpServlet {
    private final ClientStatusService clientStatusService = new ClientStatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientsStatuses", clientStatusService.findAllClientsStatuses());
        req.getRequestDispatcher("views/client_status.jsp").forward(req, resp);
    }
}