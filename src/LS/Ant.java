package LS;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Ant extends Animal{
    private Random rand = new Random();
    private float baseSpeed = (float)(0.1);
    private float baseMetabolism = (float)(0.001);
    private int baseSize = 3;
    private int baseTurnAngle = 30;
    private Color bodyColour = Color.rgb(50, 50, 50);
    private Color smellColour = Color.rgb(0, 100, 100);

    public Ant(int x, int y, int id, Group foodGroup, Group animalGroup){
        super("Ant", 'A', id, 1000, x, y, foodGroup, animalGroup);
        String [] names_m = {"Antdrew", "Anty", "Antain", "Antanas", "Antar", "Anturas", "Antavas"};
        String [] names_f = {"Anttoinette", "Antalia", "Anta", "Anthia", "Antalia", "Antandra", "Antia", "Antheemia"};
        giveName(names_m, names_f);

        // Create smell attributes
        setSmellRange(rand.nextInt(30) + 50 - 15);
        setSmellCircle(new Circle(x, y, getSmellRange()));
        getSmellCircle().setFill(smellColour);
        getSmellCircle().setOpacity(0.5);
        setPathDistance(getSmellRange());

        // Create body attributes
        setSize(baseSize + (float)(rand.nextInt(5) * 0.2));
        setImage(new Circle(x, y, getSize()));
        getImage().setFill(bodyColour);

        // Set a random speed
        setSpeed(baseSpeed + (rand.nextInt(10) * 0.1));

        // Set a random turning angle
        setTurnAngle(baseTurnAngle + (rand.nextInt(20)));

        // Set a random metabolism
        setMetabolism((float)(baseMetabolism + (rand.nextInt(5) * 0.001)));

        // Set a random gender
        giveGender();

        // Create target indicator
        Rectangle r = new Rectangle(0, 0, 5, 5);
        r.setFill(Color.rgb(255, 0, 0));
        setTargetLocation(r);
    }
}
