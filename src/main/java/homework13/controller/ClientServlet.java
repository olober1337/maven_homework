package homework13.controller;

import homework13.dao.AccountDao;
import homework13.dao.ClientDao;
import homework13.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {
    private final ClientDao clientDao = new ClientDao();
    private final ClientService clientService = new ClientService(clientDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", clientService.findAllCustomers());
        req.getRequestDispatcher("views/clients.jsp").forward(req, resp);
    }
}
