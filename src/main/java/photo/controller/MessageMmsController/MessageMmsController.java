package photo.controller.MessageMmsController;

import photo.model.MessageForUser;
import photo.model.UserNumber;
import photo.service.CameraService;
import photo.service.impl.CameraServiceImpl;

import java.sql.SQLException;

public class MessageMmsController {

    public static void main(String[] args) throws SQLException {

        /**
         * The method tests the mandrel from the user of the message to select a photo from the database.
         * Input in the range from 1 to 5
         **/

        CameraService cameraService = new CameraServiceImpl();

        UserNumber number = new UserNumber();
        number.setNumberCamera(1);
        MessageForUser messageForUser = cameraService.setMessageForUser(number);

        System.out.println("id: " + messageForUser.getId());
        System.out.println("name camera: " + messageForUser.getNameCamera());
        System.out.println("data photo: " + messageForUser.getLocalDate());
        System.out.println("size photo: " + messageForUser.getPhoto().length);


    }
}
