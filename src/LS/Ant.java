package LS;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Random;

public class Ant extends Animal{
    private Random rand = new Random();
    private float baseSpeed = (float)(0.1), baseMetabolism = (float)(0.002);
    private int baseSize = 1, baseTurnAngle = 30, baseStrength = 3, baseMemory = 10;
    private Color bodyColour = Color.rgb(50, 50, 50);
    private Color smellColour = Color.rgb(0, 100, 100);
    private int maxAge = rand.nextInt(5) + 5, breedAge = 1, speedChangeAge = (maxAge / 2);

    public Ant(int x, int y, int id, int dayBorn, int yearBorn, Group foodGroup, Group animalGroup, Group waterGroup,
               World worldRef, ArrayList<Animal> animalList, ArrayList<Food> foodList, ArrayList<Water> waterList,
               ArrayList<Obstacle> obstacleList, ArrayList<Shelter> shelterList, Group animalSmellRef,
               Group animalStatsRef, Group animalLabelRef, Group animalTargetRef, Group animalHomeLocationRef,
               Configuration configuration){

        super("Ant", 'A', id, dayBorn, yearBorn, 2000, x, y, foodGroup, animalGroup, waterGroup, worldRef, animalList,
                foodList, waterList, obstacleList, shelterList, animalSmellRef, animalStatsRef, animalLabelRef,
                animalTargetRef, animalHomeLocationRef, configuration);

        String [] names_m = {"Antdrew", "Anty", "Antain", "Antanas", "Antar", "Anturas", "Antavas"};
        String [] names_f = {"Anttoinette", "Antalia", "Anta", "Anthia", "Antalia", "Antandra", "Antia", "Antheemia"};
        giveName(names_m, names_f);

        // Create smell attributes
        setSmellRange(rand.nextInt(30) + 50 - 15);
        setSmellCircle(new Circle(x, y, getSmellRange()));
        getSmellCircle().setFill(smellColour);
        getSmellCircle().setOpacity(0.3);
        setPathDistance(getSmellRange());

        // Create body attributes
        setSize(baseSize + (float)(rand.nextInt(5) * 0.2));
        setImage(new Circle(x, y, getSize()));
        getImage().setFill(bodyColour);

        // Set a random speed
        setSpeed(baseSpeed + (rand.nextInt(10) * 0.1));
        setOriginalSpeed(getSpeed());

        // Set a random turning angle
        setTurnAngle(baseTurnAngle + (rand.nextInt(20)));

        // Set a random metabolism
        setMetabolism((float)(baseMetabolism + (rand.nextInt(4) * 0.0005)));

        // Set a random memory
        setMemory(baseMemory + (rand.nextInt(30)));

        // Set strength
        setStrength(baseStrength + rand.nextInt(2));

        // Create food inventory
        setFoodInventory(new Inventory(getStrength()/2 + rand.nextInt(2), getStrength() + (rand.nextInt(2))));

        // Create water inventory
        setWaterInventory(new Inventory(getStrength()/2 + rand.nextInt(2), getStrength() + (rand.nextInt(2))));
    }

    public Ant(int x, int y, int id, int dayBorn, int yearBorn, Group foodGroup, Group animalGroup, Group waterGroup,
               int smellRange, float size, float speed, int turnAngle, float metabolism, int memory, int strength,
               World worldRef, ArrayList<Animal> animalList, ArrayList<Food> foodList, ArrayList<Water> waterList,
               ArrayList<Obstacle> obstacleList, ArrayList<Shelter> shelterList, Group animalSmellRef,
               Group animalStatsRef, Group animalLabelRef, Group animalTargetRef, Group animalHomeLocationRef,
               Configuration configuration){
        super("Ant", 'A', id, dayBorn, yearBorn, 2000, x, y, foodGroup, animalGroup, waterGroup, worldRef, animalList,
                foodList, waterList, obstacleList, shelterList, animalSmellRef, animalStatsRef, animalLabelRef,
                animalTargetRef, animalHomeLocationRef, configuration);
        String [] names_m = {"Antdrew", "Anty", "Antain", "Antanas", "Antar", "Anturas", "Antavas"};
        String [] names_f = {"Anttoinette", "Antalia", "Anta", "Anthia", "Antalia", "Antandra", "Antia", "Antheemia"};
        giveName(names_m, names_f);

        // Create smell attributes
        setSmellRange(rand.nextInt(10) + smellRange);
        setSmellCircle(new Circle(x, y, getSmellRange()));
        getSmellCircle().setFill(smellColour);
        getSmellCircle().setOpacity(0.3);
        setPathDistance(getSmellRange());

        // Create body attributes
        setSize(size + (float)((rand.nextInt(2) * 0.2) - (0.2)));
        setImage(new Circle(x, y, getSize()));
        getImage().setFill(bodyColour);

        // Set a random speed
        setSpeed(speed + (rand.nextInt(2) * 0.1) - (0.1));
        setOriginalSpeed(getSpeed());

        // Set a random turning angle
        setTurnAngle(turnAngle + (rand.nextInt(10)));

        // Set a random metabolism
        setMetabolism((float)(metabolism + (rand.nextInt(2) * 0.0005) - (0.0005)));

        // Set a random memory
        setMemory(memory + (rand.nextInt(20)));

        // set strength
        setStrength(strength);

        // Create food inventory
        setFoodInventory(new Inventory(strength/2 + rand.nextInt(2) - 1, strength + (rand.nextInt(2) - 1)));

        // Create water inventory
        setWaterInventory(new Inventory(strength/2 + rand.nextInt(2) - 1, strength + (rand.nextInt(2) - 1)));
    }

    public Ant(int x, int y, char gender, String name, double speed, float metabolism, int strength, int smell,
               int size, int id, int dayBorn, int yearBorn,  Group foodGroup, Group animalGroup, Group waterGroup,
               World worldRef, ArrayList<Animal> animalList, ArrayList<Food> foodList, ArrayList<Water> waterList,
               ArrayList<Obstacle> obstacleList, ArrayList<Shelter> shelterList, Group animalSmellRef,
               Group animalStatsRef, Group animalLabelRef, Group animalTargetRef, Group animalHomeLocationRef,
               Configuration configuration){

        super("Ant", 'A', id, dayBorn, yearBorn, 2000, x, y, gender, name, speed, metabolism, strength, smell, size,
                foodGroup, animalGroup, waterGroup, worldRef, animalList, foodList, waterList, obstacleList,
                shelterList, animalSmellRef, animalStatsRef, animalLabelRef, animalTargetRef, animalHomeLocationRef,
                configuration, Color.rgb(50, 50, 50));
    }

    @Override
    public void ageEvents(){
        if (getLastAge() != getAgeYear()) {
            setLastAge(getAgeYear());
            if (getAgeYear() >= breedAge){
                setShouldBreed(true);
            }
            if (getAgeYear() == maxAge){
                setEnergy(0);
            }
        }
    }

    @Override
    public void createBaby(Animal ant){
        int random = rand.nextInt(3) + 1;
        for(int i = 0; i < random; i++) {
            int x = (int) (getImage().getCenterX() + getImage().getTranslateX()), y = (int) (getImage().getCenterY() + getImage().getTranslateY()), id = World.trackAnimalID;
            int smellRange = (getSmellRange() + ant.getSmellRange()) / 2;
            float size = (getSize() + ant.getSize()) / 2;
            float speed = (float) (getSpeed() + ant.getSpeed()) / 2;
            int turnAngle = (getTurnAngle() + ant.getTurnAngle()) / 2;
            float metabolism = (getMetabolism() + ant.getMetabolism()) / 2;
            int memory = (getMemory() + ant.getMemory()) / 2;
            int strength = (getStrength() + ant.getStrength()) / 2;

            World.trackAnimalID++;
            Ant a = new Ant(x, y, id, getWorldRef().getDay(), getWorldRef().getYear(), getFoodGroupRef(), getAnimalGroupRef(), getWaterGroupRef(),
                    smellRange, size, speed, turnAngle, metabolism, memory, strength, getWorldRef(), getAnimalList(), getFoodList(), getWaterList(),
                    getObstacleList(), getShelterList(), getAnimalSmellRef(), getAnimalStatsRef(), getAnimalLabelRef(), getAnimalTargetRef(),
                    getAnimalHomeLocationRef(), getConfiguration());

            getAnimalList().add(a);
            a.setAnimalList(getAnimalList());
            a.setFoodList(getFoodList());
            a.setShelterList(getShelterList());
            a.setWaterList(getWaterList());
            a.setObstacleList(getObstacleList());
            a.setAnimalSmellRef(getAnimalSmellRef());
            a.setAnimalStatsRef(getAnimalStatsRef());
            a.setAnimalLabelRef(getAnimalLabelRef());
            a.setAnimalTargetRef(getAnimalTargetRef());
            a.setAnimalHomeLocationRef(getAnimalHomeLocationRef());

            getAnimalGroupRef().getChildren().add(a.getImage());
            getAnimalSmellRef().getChildren().add(a.getSmellCircle());
            getAnimalTargetRef().getChildren().add(a.getTargetLocation());
            getAnimalStatsRef().getChildren().add(a.getStatsBar().getGroup());
            getAnimalHomeLocationRef().getChildren().add(a.getHomeLocation());
            getAnimalLabelRef().getChildren().add(a.getText());
        }
    }

    @Override
    public void checkShelters(){
        for(int i = 0; i < getShelterList().size(); i++){
            if(getShelterList().get(i).getType().equals("AntHill")) {
                if (Collision.overlapsEfficient(getSmellCircle(), getShelterList().get(i).getImage())) {
                    if (Collision.overlapsAccurate(getSmellCircle(), getShelterList().get(i).getImage())) {
                        setHome(new Target(getShelterList().get(i).getX(), getShelterList().get(i).getY()), getShelterList().get(i).getID());
                        break;
                    }
                }
            }
        }
    }
}
