package beautybook.dto.booking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BookingDto {

    private int Id;
    private int userId;
    private int clientId;
    private int masterId;
    private int procedureId;
    private String status;
    private String dateTime;
}