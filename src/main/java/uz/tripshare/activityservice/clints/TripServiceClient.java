package uz.tripshare.activityservice.clints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.tripshare.domain.common.Trip;

@FeignClient(url = "http://localhost:8090", path = "api/trips", name = "TRIP-SERVICE")
public interface TripServiceClient {

    @GetMapping("/id")
    Trip getTripById(@RequestParam("id") Integer id);
}
