package by.servlet.owner.plants;

import by.park.dao.DAOFactory;
import by.park.dao.PlantsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPlant")
public class AddPlantServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        PlantsDAO plant = factory.getPlantsDAO();
        plant.addPlant(title);
        req.getRequestDispatcher("plants.html").forward(req, resp);
    }
}
