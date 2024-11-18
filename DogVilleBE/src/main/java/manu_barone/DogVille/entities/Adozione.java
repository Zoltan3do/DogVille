package manu_barone.DogVille.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import manu_barone.DogVille.entities.enums.StatoAdozione;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "adoptions")
@ToString
@Setter
@JsonIgnoreProperties({"enabled", "accountNonLocked", "credentialsNonExpired", "accountNonExpired", "authorities"})
public class Adozione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDate visitDate;
    private String document;

    @Enumerated(EnumType.STRING)
    private StatoAdozione state;

    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "dog_id")
    private Cane dog;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Utente userAdoptions;


    public Adozione() {
        this.state = StatoAdozione.IN_ATTESA_DOCUMENTI;
        this.creationDate = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public String getDocument() {
        return document;
    }

    public StatoAdozione getState() {
        return state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
