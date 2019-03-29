/*
 * The MIT License
 *
 * Copyright (c) 2004-2011, Yahoo!, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import hudson.maven.MavenModuleSet;
import hudson.maven.MavenModuleSetBuild;
import hudson.model.Failure;
import hudson.model.RestartListener;
import hudson.model.RootAction;
import hudson.model.UnprotectedRootAction;
import hudson.model.User;
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy;
import hudson.security.HudsonPrivateSecurityRealm;
import hudson.util.HttpResponses;
import hudson.model.FreeStyleProject;
import hudson.security.GlobalMatrixAuthorizationStrategy;
import hudson.security.LegacySecurityRealm;
import hudson.security.Permission;
import hudson.slaves.ComputerListener;
import hudson.slaves.DumbSlave;
import hudson.slaves.OfflineCause;
import hudson.util.FormValidation;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.ExtractResourceSCM;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.JenkinsRule.WebClient;
import org.jvnet.hudson.test.TestExtension;
import org.kohsuke.stapler.HttpResponse;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Nonnull;

/**
 * @author jackcoolguyjaquish
 *
 */
public class CopyOfJenkinsTest {

    @Rule public JenkinsRule j = new JenkinsRule();
    
    /*
     User user = User.get("john.smith@acme.org");
        User user2 = User.get("John.Smith@acme.org");
        assertNotSame("Users should not have the same id.", user.getId(), user2.getId());
        assertEquals("john.smith@acme.org", User.idStrategy().keyFor(user.getId()));
        assertEquals("john.smith@acme.org", User.idStrategy().filenameOf(user.getId()));
        assertEquals("John.Smith@acme.org", User.idStrategy().keyFor(user2.getId()));
        assertEquals("~john.~smith@acme.org", User.idStrategy().filenameOf(user2.getId()));
        user2 = User.get("john.smith@ACME.ORG");
        assertEquals("Users should have the same id.", user.getId(), user2.getId());
        assertEquals("john.smith@acme.org", User.idStrategy().keyFor(user2.getId()));
        assertEquals("john.smith@acme.org", User.idStrategy().filenameOf(user2.getId()));
        assertEquals(user.getId(), User.idStrategy().idFromFilename(User.idStrategy().filenameOf(user.getId())));
        assertEquals(user2.getId(), User.idStrategy().idFromFilename(User.idStrategy().filenameOf(user2.getId())));

     * */

    @Test
    public void testInvalidNum() throws Exception {
    	IdStrategy.CaseSensitive myCase = new IdStrategy.CaseSensitive();
    	assertEquals("hello", myCase.idFromFilename("hello$111"));

    }

    @Test
    public void testFNameWithHex() throws Exception {
    	IdStrategy.CaseSensitive myCase = new IdStrategy.CaseSensitive();
    	assertEquals("hellos", myCase.idFromFilename("hello$0073"));
    }
}
