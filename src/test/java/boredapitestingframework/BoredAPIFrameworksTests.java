package boredapitestingframework;

import boredapitestingframework.connection.ConnectionManager;
import boredapitestingframework.dto.ActivityDTO;
import boredapitestingframework.injection.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoredAPIFrameworksTests {

    private static ActivityDTO dto;

    private static int statusCode;

    @BeforeAll
    static void initALL(){
        dto = Injector.injectActivityDTO(ConnectionManager.getConnection("participants", 3));
        statusCode = ConnectionManager.getStatusCode();
    }

    @Test
    @DisplayName("Check status code 200")
    void checkStatusCodeIs200(){

        Assertions.assertEquals(200, statusCode);
    }
}
