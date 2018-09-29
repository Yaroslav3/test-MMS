package photo.dao.impl;

import photo.dao.CameraDao;
import photo.dao.connectedFactory.ConnectionDatabase;
import photo.model.Camera;
import photo.model.MessageForUser;
import photo.model.UserNumber;

import java.sql.*;
import java.time.LocalDate;

public class CameraDaoImpl implements CameraDao {

    private final String INSERT_USER = "INSERT INTO mms.camera (data,name_camera,photo_content) VALUE (?,?,?)";

    private final String SELECT_PHOTO_CAMERA1 = "SELECT * from mms.camera where id = (SELECT max(id) from mms.camera where name_camera='camera-№1');";
    private final String SELECT_PHOTO_CAMERA2 = "SELECT * from mms.camera where id = (SELECT max(id) from mms.camera where name_camera='camera-№2');";
    private final String SELECT_PHOTO_CAMERA3 = "SELECT * from mms.camera where id = (SELECT max(id) from mms.camera where name_camera='camera-№3');";
    private final String SELECT_PHOTO_CAMERA4 = "SELECT * from mms.camera where id = (SELECT max(id) from mms.camera where name_camera='camera-№4');";
    private final String SELECT_PHOTO_CAMERA5 = "SELECT * from mms.camera where id = (SELECT max(id) from mms.camera where name_camera='camera-№5');";




    @Override
    public void save(Camera camera) throws SQLException {

        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Connection connect = connectionDatabase.getConnect();
        PreparedStatement prepInsert = connect.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
        connect.setAutoCommit(false);

        prepInsert.setString(1, String.valueOf(camera.getLocalDate()));
        prepInsert.setString(2, camera.getNameCamera());
        prepInsert.setBytes(3, camera.getPhoto());
        prepInsert.execute();
        connect.commit();
        prepInsert.close();
        connect.close();
    }



    @Override
    public MessageForUser setMessageForUser(UserNumber userNumber) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Connection connect = connectionDatabase.getConnect();

        if (userNumber.getNumberCamera() == 1) {
            return setMessage(connect, SELECT_PHOTO_CAMERA1);
        }
        if (userNumber.getNumberCamera() == 2) {
            return setMessage(connect, SELECT_PHOTO_CAMERA2);
        }
        if (userNumber.getNumberCamera() == 3) {
            return setMessage(connect, SELECT_PHOTO_CAMERA3);
        }
        if (userNumber.getNumberCamera() == 4) {
            return setMessage(connect, SELECT_PHOTO_CAMERA4);
        }
        if (userNumber.getNumberCamera() == 5) {
            return setMessage(connect, SELECT_PHOTO_CAMERA5);
        }
        return null;

    }


    private MessageForUser setMessage(Connection connect, String query) throws SQLException {
        Statement stat = connect.createStatement();
        ResultSet resultSet = stat.executeQuery(query);

        MessageForUser messageForUser = new MessageForUser();

        while (resultSet.next()) {
            connect.setAutoCommit(false);
            messageForUser.setId(resultSet.getInt("id"));
            messageForUser.setNameCamera(resultSet.getString("name_camera"));
            messageForUser.setLocalDate(LocalDate.parse(resultSet.getString("data")));
            messageForUser.setPhoto(resultSet.getBytes("photo_content"));
        }
        connect.commit();
        connect.close();
        stat.close();
        return messageForUser;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
