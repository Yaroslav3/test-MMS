package photo.controller.cameraController;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;

public class Start {


    public static void main(String[] args) throws InterruptedException {

        /**
         * This example will start several concurrent threads which use single
         * webcam instance.
         */

        int n = 6;
        for (int i = 1; i < n; i++) {
            System.out.println("Thread: " + i);
            Webcam webcam = Webcam.getDefault();

            webcam.open();

            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setFPSDisplayed(true);
            panel.setDisplayDebugInfo(true);
            panel.setImageSizeDisplayed(true);
            panel.setMirrored(true);

            JFrame window = new JFrame("Test webcam panel : " + i);
            window.add(panel);
            window.setResizable(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.pack();
            window.setVisible(true);
            new Camera(i).start();


        }

        Thread.sleep(5 * 60 * 8000); // 5 minutes

        System.exit(1);
    }
}
