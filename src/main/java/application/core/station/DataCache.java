package application.core.station;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCache {

    Logger log = LoggerFactory.getLogger(DataCache.class);

    private final Map<String, Map<String, Object>> map = new HashMap<>();;

    @Autowired
    StationService stationService;

    public Map<String, Map<String, Object>> getMap() {
        return map;
    }
}
