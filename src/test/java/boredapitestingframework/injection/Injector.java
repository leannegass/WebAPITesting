package boredapitestingframework.injection;

import boredapitestingframework.dto.ActivityDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Injector {
    private static  final ObjectMapper mapper = new ObjectMapper();

    public static ActivityDTO injectActivityDTO(String path){
        ActivityDTO dto = new ActivityDTO();

        try {
            dto = mapper.readValue(new URL(path), ActivityDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
