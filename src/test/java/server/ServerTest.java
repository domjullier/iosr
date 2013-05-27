package server;

import org.junit.*;
import org.testng.annotations.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class ServerTest {

    @Before
    public void prepare() {
        setBaseUrl("http://market-jullier.rhcloud.com");
    }

    @Test
    public void testLogin() {
    	setBaseUrl("http://market-jullier.rhcloud.com");
        beginAt("/index.html");
        //clickLink("login");
        assertTitleEquals("Login Form");
        setTextField("j_username", "user1");
        setTextField("j_password", "password");
        submit();
        clickLinkWithExactText("Client", 0);
        assertTitleEquals("Broker Client - Main menu");
        
        //change value and check it on the server
        setTextField("Value", "666");
        submit();
        
        //Check on server, if the value got updated
        gotoPage("http://market-jullier.rhcloud.com/Server");
        assertMatch("^PZU 666.00 PLN");
        
    }
}
