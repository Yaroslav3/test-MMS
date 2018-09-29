package photo.model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageForUser {
    private long id;

    private String nameCamera;

    private LocalDate localDate;

    private byte[] photo;
}
