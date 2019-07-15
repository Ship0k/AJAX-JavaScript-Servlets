package by.servlet.owner.plants;

import by.park.dao.DAOFactory;
import by.park.dao.PlantsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/deletePlant")
public class DeletePlantServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String id = "";
        if (br != null) {
            id = br.readLine();
        }

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        PlantsDAO plant = factory.getPlantsDAO();
        String message = plant.deletePlant(Integer.parseInt(id));

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(message);
    }
}
