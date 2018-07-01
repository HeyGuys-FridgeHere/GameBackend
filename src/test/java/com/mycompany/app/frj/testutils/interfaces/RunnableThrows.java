package com.mycompany.app.frj.testutils.interfaces;

/**
 * Same as {@link Runnable} but with exception in method signature, to allow any UT/method under test to use this.
 *
 * @author alecva
 */
@FunctionalInterface
public interface RunnableThrows {

    void runThrows() throws Exception;

}
