package it.universal.krypta.valyuta.server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apiresponse {
    private String message;
    private boolean success;
}
