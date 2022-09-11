package UI.Components;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ActionButton extends Button {
    public ActionButton(Type type) throws FileNotFoundException {
        super("");
        switch(type)
        {
            case cart:

                break;
            case wishlist:
              setText("wishlist");
                break;
        }

    }
}
