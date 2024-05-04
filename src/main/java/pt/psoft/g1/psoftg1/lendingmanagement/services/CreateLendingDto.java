package pt.psoft.g1.psoftg1.lendingmanagement.services;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "A DTO for creating a Lending")
public class CreateLendingDto {
    @Size(min = 10, max = 13)
    private String isbn;

    @Size(min = 6, max = 16)
    private String readerNumber;
}
