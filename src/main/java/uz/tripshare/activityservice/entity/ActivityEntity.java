package uz.tripshare.activityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.tripshare.domain.enumerators.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "activity")
public class ActivityEntity extends BaseEntity {

    private Integer tripId;
    private String name;
    private String description;
    private String location;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;
}
