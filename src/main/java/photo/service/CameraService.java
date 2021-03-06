package photo.service;

import photo.model.Camera;
import photo.model.MessageForUser;
import photo.model.UserNumber;

import java.sql.SQLException;

public interface CameraService {


    /**
     * Saves the camera photo to the database
     *
     * @param camera save photo camera
     * @throws SQLException
     **/

    void save(Camera camera) throws SQLException;


    /**
     * The method populates the message for the user, which is rolled off the database.
     *
     * @param userNumber  receives the camera number
     * @return  MessageForUser
     * @throws SQLException
     **/
    MessageForUser setMessageForUser(UserNumber userNumber) throws SQLException;

    /**
     * The method deletes an entry by id.
     *
     * @param id  deletes an entry by id
     * @return   boolean
     **/
    boolean delete(int id);
}
