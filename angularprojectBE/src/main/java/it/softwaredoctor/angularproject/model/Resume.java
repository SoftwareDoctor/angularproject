package it.softwaredoctor.angularproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResume", nullable = false)
    private Long idResume;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cv", nullable = false)
    private byte[] cv;

}
