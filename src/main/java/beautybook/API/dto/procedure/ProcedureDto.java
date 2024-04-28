package beautybook.API.dto.procedure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ProcedureDto {
    private int id;
    private String name;
    private Double price;
}