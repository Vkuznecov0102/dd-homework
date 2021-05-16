package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('letter','command','fax')")
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('high','low', 'standard')")
    private TypeOfView typeOfView;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<Version> versions;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;


    private enum TypeOfView {
        HIGH, LOW, STANDARD
    }

    private enum Priority {
        LETTER, COMMAND, FAX
    }
}
