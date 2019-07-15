package by.park.dao;

import by.park.entity.Plant;

import java.util.ArrayList;

public interface PlantsDAO {
    Plant plantTopId();
    Plant plantPrev(Plant plant);
    Plant plantNext(Plant plant);
    Plant byId(int id);
    ArrayList<Plant> viewPlants();
    String deletePlant(int idPlant);
    void addPlant(String title);
    Plant replacePlant(Plant plant);
}
