package kz.adem.organizationservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        description = "OrganizationDto Model Information"
)
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "Organization name"
    )
    private String organizationName;
    @Schema(
            description = "Organization description"
    )
    private String organizationDescription;
    @Schema(
            description = "Organization code"
    )
    private String organizationCode;
    private LocalDateTime createdDate;
}
