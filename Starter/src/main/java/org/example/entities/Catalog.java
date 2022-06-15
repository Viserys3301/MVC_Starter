package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalog")
@NamedQueries({@NamedQuery(name = "Catalog.finAll",query = "SELECT c FROM Catalog  c"),
                @NamedQuery(name = "Catalog.findBuId",query = "select c FROM Catalog  c where c.id=:id")})
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
}
