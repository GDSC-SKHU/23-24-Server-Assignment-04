package gdsc.skhu.jpaexercise.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerSaveReqDto {

    private String name;

    public CustomerSaveReqDto(String name) {
        this.name = name;
    }
}
