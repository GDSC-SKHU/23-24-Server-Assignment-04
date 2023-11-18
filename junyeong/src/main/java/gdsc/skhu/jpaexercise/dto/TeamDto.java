package gdsc.skhu.jpaexercise.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private Integer id;
    private String name;
    private List<MemberDto> members = new ArrayList<>();
}
