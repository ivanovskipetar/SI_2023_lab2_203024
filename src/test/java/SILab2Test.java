import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private User[] users = {
      new User("petarivanovski","petar1234!","petar.ivanovski@gmail.com"),
      new User("aleksejivanovski","aleksej1234","aleksej.ivanovski@gmail.com"),
      new User("klementinadimitrova","klementina1234","klementina.dimitrova@gmail.com"),
      new User("stefanpetrovski","stefan1234","stefan.petrovski@gmail.com")
    };

    User userNonExistant = null;
    User userWithNoPass = new User("imeprezime",null,"imeprezime@gmail.com");
    User userWithNoEmail = new User("imeprezime","imeprezime",null);

    @Test
    void multipleConditionTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(userNonExistant, List.of(users)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(userWithNoPass, List.of(users)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(userWithNoEmail, List.of(users)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
}
