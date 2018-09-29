package photo.controller.cameraController;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.util.AdaptiveSizeWriter;
import photo.service.CameraService;
import photo.service.impl.CameraServiceImpl;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Camera extends Thread {

    private CameraService cameraService = new CameraServiceImpl();
    private static AtomicInteger counter = new AtomicInteger(0);
    private static final AtomicInteger number = new AtomicInteger(5);
    private int numCam;


    Camera(int numberCamera) {
        super("capture-" + number.incrementAndGet());
        numCam = numberCamera;
    }

    @Override
    public void run() {

        Webcam webcam = Webcam.getDefault();
        webcam.open();


        while (true) {

            if (!webcam.isOpen()) {
                break;
            }

            BufferedImage image = webcam.getImage();
            if (image == null) {
                break;
            }
            try {
                Thread.sleep(8000);


                if (numCam == 1) {
                    final byte[] data = getBytesImage(webcam);
                    cameraService.save(photo.model.Camera.builder().nameCamera("camera-№1").localDate(LocalDate.now()).photo(data).build());
                }

                if (numCam == 2) {
                    final byte[] data = getBytesImage(webcam);

                    cameraService.save(photo.model.Camera.builder().nameCamera("camera-№2").localDate(LocalDate.now()).photo(data).build());
                }
                if (numCam == 3) {
                    final byte[] data = getBytesImage(webcam);

                    cameraService.save(photo.model.Camera.builder().nameCamera("camera-№3").localDate(LocalDate.now()).photo(data).build());
                }
                if (numCam == 4) {
                    final byte[] data = getBytesImage(webcam);

                    cameraService.save(photo.model.Camera.builder().nameCamera("camera-№4").localDate(LocalDate.now()).photo(data).build());
                }
                if (numCam == 5) {
                    final byte[] data = getBytesImage(webcam);
                    cameraService.save(photo.model.Camera.builder().nameCamera("camera-№5").localDate(LocalDate.now()).photo(data).build());
                }


                int n = counter.incrementAndGet();
                if (n != 0 && n % 100 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": Frames captured: " + n);
                }

            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] getBytesImage(Webcam webcam) {
        final BufferedImage bi = webcam.getImage();
        final AdaptiveSizeWriter writer = new AdaptiveSizeWriter(20000); // max number of bytes
        return writer.write(bi);
    }
}

