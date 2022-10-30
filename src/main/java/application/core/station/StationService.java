package application.core.station;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StationService {

  private StationRepository repository;

  public StationService(StationRepository repository) {
    this.repository = repository;
  }

  public StationDto getStation(String stationId) {
    StationEntity stationEntity = repository.findByStationId(stationId);
    StationDto ret = new ModelMapper().map(stationEntity, StationDto.class);
    System.out.println(ret);
    return ret;
  }

  public Iterable<StationDto> getAllStations() {
    List<StationDto> stationsList = new ArrayList<>();
    Iterable<StationEntity> stations = repository.findAll();

    for (StationEntity station : stations) {
      StationDto stationDto = new ModelMapper().map(station, StationDto.class);
      stationsList.add(stationDto);
    }
    // stationsList.sort((StationDto a, StationDto b) -> {
    //
    // });
    return stationsList;
  }

  @Override
  public String toString() {
    return "{\n  \"StationService\": {\n    \"repository\":\"" + repository + "\"\n  }\n}";
  }

}
