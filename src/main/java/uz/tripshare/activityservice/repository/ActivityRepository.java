package uz.tripshare.activityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripshare.activityservice.entity.ActivityEntity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Integer> {
    List<ActivityEntity> findByTripId(Integer tripId);
}
