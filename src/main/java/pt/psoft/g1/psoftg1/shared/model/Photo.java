package pt.psoft.g1.psoftg1.shared.model;

import jakarta.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private byte[] photo;

    protected Photo (){}
    public Photo (byte[] photoBytes){
        this.photo= photoBytes;
    }
}
