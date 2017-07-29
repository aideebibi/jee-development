/**
 * Este software pueder ser mofificado ó utilizado haciendo referencia al autor
 * intelectual.
 */
package net.jorgerdc.jee.web.test.logging;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Junit test case, ilustra el uso de lombok para el manejo de logs. Verifica
 * que log4j.properties se encuentre en el classpath
 * 
 * @author Jorge Rodríguez Campos (jorgerdc@gmail.com)
 * @version 1.0
 */
@Slf4j
public class LogTest {

    @Test
    public void testLog() {
        log.debug("Testing Slf4j with  Project Lombo at {}", new Date());
        assertNotNull("log4j.properties not found in root classpath for testing",
                Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
    }

}
