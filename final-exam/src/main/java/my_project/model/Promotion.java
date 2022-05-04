package my_project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "date")
    private String startTime;

    @Column(columnDefinition = "date")
    private String endTime;

    @Column(columnDefinition = "INT")
    private String promotionPrice;

    @Column(columnDefinition = "LONGTEXT")
    private String detai;

    public Promotion() {
    }
}
