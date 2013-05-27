package server;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class ServerTest {

    @Before
    public void prepare() {
        setBaseUrl("http://market-jullier.rhcloud.com");
    }

    @Test
    public void testLogin() {
        beginAt("/index.html");
        //clickLink("login");
        assertTitleEquals("Login Form");
        setTextField("j_username", "user1");
        setTextField("j_password", "password");
        submit();
        clickLink("Client");
        assertTitleEquals("Broker Client - Main menu");
    }
}
