package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javafx.event.*;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;


import static sample.OpenCvUtils.*;

public class CController {

    @FXML
    public Button btn_carregar,btn_rgb,btn_xyz,btn_gray,btn_hsv,btn_hsl,btn_save;
    @FXML
    public ImageView imApresentada,histApresenta;
    @FXML
    public TabPane tabPane;
    @FXML
    public BorderPane borderPane;

    public boolean gray;

    @FXML
    public void carregaImagem(ActionEvent event)
    {
        gray=false;
        Mat mat = Imgcodecs.imread("/home/cesar/Imagens/smplayer_screenshots/shutterstock_eye.jpg");
        imApresentada.setImage(mat2Image(mat));
        histApresenta.setImage(showHistogram(mat,gray));


    }

    public void apresentaJanela(Mat imagem, Mat hist,boolean gray)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("outerTab.fxml"));
            Parent p = (Parent) loader.load();
            OuterTabController controller = loader.<OuterTabController>getController();
            if (controller != null)
            {
                openNewWindow(p,controller,imagem,hist,gray);
            }
        }catch (IOException el)
        {
            System.out.println(el.getMessage());
        }
    }

    @FXML
    public void createRec(MouseEvent event)
    {

    }

    @FXML
    public void toRGB(ActionEvent e)
    {

    }

    @FXML
    public void toGray(ActionEvent e)
    {
        Mat hist = new Mat();
        Mat saida = to_Gray(image2Mat(imApresentada.getImage()));
        gray = true;
        hist = image2Mat(showHistogram(saida,gray));
        apresentaJanela(saida,hist,gray);
    }

    @FXML
    public void toHSV(ActionEvent e)
    {
        gray = false;
        Mat saida = to_HSV(image2Mat(imApresentada.getImage()));
        Mat hist = image2Mat(showHistogram(saida,gray));
        apresentaJanela(saida,hist,gray);

    }

    @FXML
    public void toHSL(ActionEvent e)
    {
        gray = false;
        Mat saida = to_HSL(image2Mat(imApresentada.getImage()));
        Mat hist = image2Mat(showHistogram(saida,gray));
        apresentaJanela(saida,hist,gray);
    }

    @FXML
    public void toXYZ(ActionEvent e)
    {
        gray = false;
        Mat saida = to_XYZ(image2Mat(imApresentada.getImage()));
        Mat hist = image2Mat(showHistogram(saida,gray));
        apresentaJanela(saida,hist,gray);

    }



}
