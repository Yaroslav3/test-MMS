package photo.service.impl;

import photo.dao.CameraDao;
import photo.dao.impl.CameraDaoImpl;
import photo.model.Camera;
import photo.model.MessageForUser;
import photo.model.UserNumber;
import photo.service.CameraService;

import java.sql.SQLException;

public class CameraServiceImpl implements CameraService {


    @Override
    public void save(Camera camera) throws SQLException {
        CameraDao cameraDao = new CameraDaoImpl();
        cameraDao.save(camera);
    }

    @Override
    public MessageForUser setMessageForUser(UserNumber userNumber) throws SQLException {
        CameraDao cameraDao = new CameraDaoImpl();
        return cameraDao.setMessageForUser(userNumber);
    }

    @Override
    public boolean delete(int id) {
        CameraDao cameraDao = new CameraDaoImpl();
        return cameraDao.delete(id);
    }
}
