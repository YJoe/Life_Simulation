package LS;

import javafx.scene.paint.Color;

public class AntHill extends Shelter {

    public AntHill(int x, int y, int ID){
        super(x, y, 50, 10, ID, "AntHill");
        getImage().setFill(Color.rgb(200, 200, 100));
    }

}
