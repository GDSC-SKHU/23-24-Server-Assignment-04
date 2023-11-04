package gdsc.skhu.jpaexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Integer id;
    private String name;
    private Integer age;
    private String teamName;
}
