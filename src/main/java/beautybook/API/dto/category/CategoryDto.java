package beautybook.API.dto.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class CategoryDto {
    private int id;
    private String name;
}