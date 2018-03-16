package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import static sample.OpenCvUtils.image2Mat;


public class OuterTabController {
    @FXML
    ImageView imApresenta;
    @FXML
    ImageView histApresenta;
    @FXML
    TextField txt_save;
    @FXML
    public Button btn_save;


    @FXML
    public void saveFile(ActionEvent e)
    {
        String name = txt_save.getText();
        if (name != null)
        {
            Imgcodecs.imwrite(name+".jpg",image2Mat(imApresenta.getImage()));
            Imgcodecs.imwrite(name+"_Hist.jpg",image2Mat(histApresenta.getImage()));
        }

    }


}
