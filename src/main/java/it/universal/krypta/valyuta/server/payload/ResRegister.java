package it.universal.krypta.valyuta.server.payload;

import it.universal.krypta.valyuta.server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResRegister {
    private GetLogin getLogin;
    private Apiresponse apiresponse;
}
