package pt.psoft.g1.psoftg1.readermanagement.services;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
public class UpdateReaderRequest {
    @Setter
    @Getter
    private String number;

    @Getter
    @Setter
    @Nullable
    private String username;

    @Getter
    @Setter
    @Nullable
    private String password;

    @Getter
    @NotBlank
    @Nullable
    private String fullName;

    @Getter
    @NotBlank
    @Nullable
    private String birthDate;

    @Getter
    @NotBlank
    @Nullable
    private String phoneNumber;

    @Nullable
    private boolean marketing;

    @Nullable
    private boolean thirdParty;

    /*public CreateReaderRequest(String username, String password, String fullName, String birthDate, String phoneNumber, boolean gdpr, boolean marketing, boolean thirdParty) {
        setUsername(username);
        setPassword(password);
        setFullName(fullName);
        setBirthDate(birthDate);
        setPhoneNumber(phoneNumber);
        setGdpr(gdpr);
        setMarketing(marketing);
        setThirdParty(thirdParty);
    }*/

    public boolean getThirdParty() {
        return thirdParty;
    }

    public boolean getMarketing() {
        return marketing;
    }
}