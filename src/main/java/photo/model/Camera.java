package photo.model;

import lombok.*;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Camera {

    private long id;

    private String nameCamera;

    private LocalDate localDate;

    private byte[] photo;


}

