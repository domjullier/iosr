package server;

import static org.testng.AssertJUnit.assertEquals;

import java.net.URL;

import org.junit.*;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import net.sourceforge.jwebunit.util.TestContext;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class ServerTest {

    @Before
    public void prepare() {
        setBaseUrl("http://market-jullier.rhcloud.com");
    }

    @Test
    public void testLogin() throws Exception {
    	
    	
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
        setWorkingForm(1);
        setTextField("Value", "167");
        setHiddenField("index", "PZU");
        submit();
        assertMatch("Sent update for index:");
        
        //Check on server, if the value got updated
        gotoPage("http://market-jullier.rhcloud.com/Server");
        assertMatch("^PZU 167.00 PLN");
        
        //reset to default value
        gotoPage("http://market-jullier.rhcloud.com/Client");
        setWorkingForm(1);
        setTextField("Value", "12");
        setHiddenField("index", "PZU");
        submit();
        assertMatch("Sent update for index:");
    }
}
