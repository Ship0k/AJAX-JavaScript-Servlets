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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/returnPlant")
public class ReturnPlantServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String id = "";
        if (br != null) {
            id = br.readLine();
        }

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        PlantsDAO plant = factory.getPlantsDAO();
        Plant curPlant = plant.byId(Integer.parseInt(id));

        Gson gson = new GsonBuilder().setDateFormat("dd MM yyyy").create();
        String json = gson.toJson(curPlant);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
