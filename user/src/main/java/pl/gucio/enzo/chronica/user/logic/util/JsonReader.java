package pl.gucio.enzo.chronica.user.logic.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class JsonReader {
    private Map jsonMap;
    public void readJsonToMap(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.jsonMap = objectMapper.readValue(new File(filePath), Map.class);
    }
}
