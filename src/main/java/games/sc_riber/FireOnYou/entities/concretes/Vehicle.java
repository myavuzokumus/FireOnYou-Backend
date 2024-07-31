package games.sc_riber.FireOnYou.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
