package dcll;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexandre on 15/04/2016.
 */
public class LoginServiceTest {
    LoginService ls;
    @Before
    public void setUp() throws Exception {
        String loginTest[]={"nom1","nom2","nom3","nom4","nom5"};
        ls=new LoginService(loginTest);
    }

    @Test
    public void testLoginExists() throws Exception {
        assertTrue(ls.loginExists("nom1"));
        assertFalse(ls.loginExists("nom6"));
    }

    @Test
    public void testAddLogin() throws Exception {
        ls.addLogin("nom6");
        assertTrue(ls.loginExists("nom6"));

    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        List<String>l;
       l= ls.findAllLoginsStartingWith("nom");
        assertFalse(l.isEmpty());
        assertEquals(l.size(),5);
        assertTrue(l.contains("nom2"));

        l= ls.findAllLoginsStartingWith("test");
        assertTrue(l.isEmpty());
        assertEquals(l.size(),0);
        ls.findAllLogins().clear();
        l=ls.findAllLoginsStartingWith("nom");
        assertTrue(l.isEmpty());
        assertEquals(l.size(),0);

    }

    @Test
    public void testFindAllLogins() throws Exception {
        List<String>l;
        l= ls.findAllLogins();
        assertFalse(l.isEmpty());
        assertEquals(l.size(),5);
        for(int i=0;i<l.size();i++) {
            assertEquals(l.get(i),"nom"+(i+1));
        }

    }
}