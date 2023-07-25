package kz.adem.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Department DTO Model Information"
)
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department name"
    )
    private String departmentName;
    @Schema(
            description = "Department description"
    )
    private String departmentDescription;
    @Schema(
            description = "Department code"
    )
    private String departmentCode;
}
