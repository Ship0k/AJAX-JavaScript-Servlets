package by.servlet.owner.plants;

import by.park.dao.DAOFactory;
import by.park.dao.PlantsDAO;
import by.park.entity.Plant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/plants")
public class PlantsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("plants.html").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        PlantsDAO plant = factory.getPlantsDAO();
        ArrayList<Plant> curPlants = plant.viewPlants();

        Gson gson = new GsonBuilder().setDateFormat("dd MM yyyy").create();
        String json = gson.toJson(curPlants);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
