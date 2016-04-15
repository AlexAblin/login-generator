package dcll;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.StringHolder;

import static org.junit.Assert.*;

/**
 * Created by alexandre on 15/04/2016.
 */
public class LoginGeneratorTest {
        LoginGenerator lg;
        LoginService loginService;
    @Before
    public void setUp() throws Exception {
         loginService = new LoginService(
                new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL",
                        "JRAL1"});

        lg= new LoginGenerator(loginService);

    }

    @Test
    public void testGenerateLoginForNomAndPrenom1() throws Exception {
        String result=lg.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals(result,"PDUR");
        assertTrue(loginService.findAllLogins().contains("PDUR"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenom2() throws Exception {
        String result=lg.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals(result,"JROL1");
        assertTrue(loginService.findAllLogins().contains("JROL1"));
     }

    @Test
    public void testGenerateLoginForNomAndPrenom3() throws Exception {
        String result=lg.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertEquals(result,"PDUR");
        assertTrue(loginService.findAllLogins().contains("PDUR"));

    }
}