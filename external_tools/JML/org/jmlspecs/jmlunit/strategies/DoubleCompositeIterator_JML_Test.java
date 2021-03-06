// This file was generated by jmlunit on Tue May 20 17:38:47 EDT 2008.

package org.jmlspecs.jmlunit.strategies;

import java.util.NoSuchElementException;

/** Automatically-generated test driver for JML and JUnit based
 * testing of DoubleCompositeIterator. The superclass of this class should be edited
 * to supply test data. However it's best not to edit this class
 * directly; instead use the command
 * <pre>
 *  jmlunit DoubleCompositeIterator.java
 * </pre>
 * to regenerate this class whenever DoubleCompositeIterator.java changes.
 */
public class DoubleCompositeIterator_JML_Test
     extends DoubleCompositeIterator_JML_TestData
{
    /** Initialize this class. */
    public DoubleCompositeIterator_JML_Test(java.lang.String name) {
        super(name);
    }

    /** Run the tests. */
    public static void main(java.lang.String[] args) {
        org.jmlspecs.jmlunit.JMLTestRunner.run(suite());
        // You can also use a JUnit test runner such as:
        // junit.textui.TestRunner.run(suite());
    }

    /** Test to see if the code for class DoubleCompositeIterator
     * has been compiled with runtime assertion checking (i.e., by jmlc).
     * Code that is not compiled with jmlc would not make an effective test,
     * since no assertion checking would be done. */
    public void test$IsRACCompiled() {
        junit.framework.Assert.assertTrue("code for class DoubleCompositeIterator"
                + " was not compiled with jmlc"
                + " so no assertions will be checked!",
            org.jmlspecs.jmlrac.runtime.JMLChecker.isRACCompiled(DoubleCompositeIterator.class)
            );
    }

    /** Return the test suite for this test class.  This will have
    * added to it at least test$IsRACCompiled(), and any test methods
    * written explicitly by the user in the superclass.  It will also
    * have added test suites for each testing each method and
    * constructor.
    */
    //@ ensures \result != null;
    public static junit.framework.Test suite() {
        DoubleCompositeIterator_JML_Test testobj
            = new DoubleCompositeIterator_JML_Test("DoubleCompositeIterator_JML_Test");
        junit.framework.TestSuite testsuite = testobj.overallTestSuite();
        // Add instances of Test found by the reflection mechanism.
        testsuite.addTestSuite(DoubleCompositeIterator_JML_Test.class);
        testobj.addTestSuiteForEachMethod(testsuite);
        return testsuite;
    }

    /** A JUnit test object that can run a single test method.  This
     * is defined as a nested class solely for convenience; it can't
     * be defined once and for all because it must subclass its
     * enclosing class.
     */
    protected static abstract class OneTest extends DoubleCompositeIterator_JML_Test {

        /** Initialize this test object. */
        public OneTest(String name) {
            super(name);
        }

        /** The result object that holds information about testing. */
        protected junit.framework.TestResult result;

        //@ also
        //@ requires result != null;
        public void run(junit.framework.TestResult result) {
            this.result = result;
            super.run(result);
        }

        /* Run a single test and decide whether the test was
         * successful, meaningless, or a failure.  This is the
         * Template Method pattern abstraction of the inner loop in a
         * JML/JUnit test. */
        public void runTest() throws java.lang.Throwable {
            try {
                // The call being tested!
                doCall();
            }
            catch (org.jmlspecs.jmlrac.runtime.JMLEntryPreconditionError e) {
                // meaningless test input
                addMeaningless();
            } catch (org.jmlspecs.jmlrac.runtime.JMLAssertionError e) {
                // test failure
                int l = org.jmlspecs.jmlrac.runtime.JMLChecker.getLevel();
                org.jmlspecs.jmlrac.runtime.JMLChecker.setLevel
                    (org.jmlspecs.jmlrac.runtime.JMLOption.NONE);
                try {
                    java.lang.String failmsg = this.failMessage(e);
                    junit.framework.AssertionFailedError err
                        = new junit.framework.AssertionFailedError(failmsg);
                    err.setStackTrace(new java.lang.StackTraceElement[]{});
                    err.initCause(e);
                    result.addFailure(this, err);
                } finally {
                    org.jmlspecs.jmlrac.runtime.JMLChecker.setLevel(l);
                }
            } catch (java.lang.Throwable e) {
                // test success
            }
        }

        /** Call the method to be tested with the appropriate arguments. */
        protected abstract void doCall() throws java.lang.Throwable;

        /** Format the error message for a test failure, based on the
         * method's arguments. */
        protected abstract java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e);

        /** Inform listeners that a meaningless test was run. */
        private void addMeaningless() {
            if (result instanceof org.jmlspecs.jmlunit.JMLTestResult) {
                ((org.jmlspecs.jmlunit.JMLTestResult)result)
                    .addMeaningless(this);
            }
        }
    }

    /** Create the tests that are to be run for testing the class
     * DoubleCompositeIterator.  The framework will then run them.
     * @param overallTestSuite$ The suite accumulating all of the tests
     * for this driver class.
     */
    //@ requires overallTestSuite$ != null;
    public void addTestSuiteForEachMethod
        (junit.framework.TestSuite overallTestSuite$)
    {
        try {
            this.addTestSuiteFor$TestDoubleCompositeIterator(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestDoubleCompositeIterator$1(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestDoubleCompositeIterator$2(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestAtEnd(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestGetDouble(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestAdvance(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestClone(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestToString(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestGet(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
    }

    /** Add tests for the DoubleCompositeIterator contructor
     * to the overall test suite. */
    private void addTestSuiteFor$TestDoubleCompositeIterator
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("DoubleCompositeIterator");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter
                = this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter("DoubleCompositeIterator", 0);
            this.check_has_data
                (vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter,
                 "this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter(\"DoubleCompositeIterator\", 0)");
            while (!vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleIterator iter
                    = (org.jmlspecs.jmlunit.strategies.DoubleIterator) vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.get();
                methodTests$.addTest
                    (new TestDoubleCompositeIterator(iter));
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the DoubleCompositeIterator contructor. */
    protected static class TestDoubleCompositeIterator extends OneTest {
        /** Argument iter */
        private org.jmlspecs.jmlunit.strategies.DoubleIterator iter;

        /** Initialize this instance. */
        public TestDoubleCompositeIterator(org.jmlspecs.jmlunit.strategies.DoubleIterator iter) {
            super("DoubleCompositeIterator"+ ":" + (iter==null? "null" :"{org.jmlspecs.jmlunit.strategies.DoubleIterator}"));
            this.iter = iter;
        }

        protected void doCall() throws java.lang.Throwable {
            new DoubleCompositeIterator(iter);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tContructor 'DoubleCompositeIterator' applied to";
            msg += "\n\tArgument iter: " + this.iter;
            return msg;
        }
    }

    /** Add tests for the DoubleCompositeIterator contructor
     * to the overall test suite. */
    private void addTestSuiteFor$TestDoubleCompositeIterator$1
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("DoubleCompositeIterator");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter
                = this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter("DoubleCompositeIterator", 1);
            this.check_has_data
                (vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter,
                 "this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter(\"DoubleCompositeIterator\", 1)");
            while (!vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.atEnd()) {
                org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                    vorg_jmlspecs_jmlunit_strategies_DoubleIterator$2$iter
                    = this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter("DoubleCompositeIterator", 0);
                this.check_has_data
                    (vorg_jmlspecs_jmlunit_strategies_DoubleIterator$2$iter,
                     "this.vorg_jmlspecs_jmlunit_strategies_DoubleIteratorIter(\"DoubleCompositeIterator\", 0)");
                while (!vorg_jmlspecs_jmlunit_strategies_DoubleIterator$2$iter.atEnd()) {
                    final org.jmlspecs.jmlunit.strategies.DoubleIterator iter1
                        = (org.jmlspecs.jmlunit.strategies.DoubleIterator) vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.get();
                    final org.jmlspecs.jmlunit.strategies.DoubleIterator iter2
                        = (org.jmlspecs.jmlunit.strategies.DoubleIterator) vorg_jmlspecs_jmlunit_strategies_DoubleIterator$2$iter.get();
                    methodTests$.addTest
                        (new TestDoubleCompositeIterator$1(iter1, iter2));
                    vorg_jmlspecs_jmlunit_strategies_DoubleIterator$2$iter.advance();
                }
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$1$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the DoubleCompositeIterator contructor. */
    protected static class TestDoubleCompositeIterator$1 extends OneTest {
        /** Argument iter1 */
        private org.jmlspecs.jmlunit.strategies.DoubleIterator iter1;
        /** Argument iter2 */
        private org.jmlspecs.jmlunit.strategies.DoubleIterator iter2;

        /** Initialize this instance. */
        public TestDoubleCompositeIterator$1(org.jmlspecs.jmlunit.strategies.DoubleIterator iter1, org.jmlspecs.jmlunit.strategies.DoubleIterator iter2) {
            super("DoubleCompositeIterator"+ ":" + (iter1==null? "null" :"{org.jmlspecs.jmlunit.strategies.DoubleIterator}")+ "," +(iter2==null? "null" :"{org.jmlspecs.jmlunit.strategies.DoubleIterator}"));
            this.iter1 = iter1;
            this.iter2 = iter2;
        }

        protected void doCall() throws java.lang.Throwable {
            new DoubleCompositeIterator(iter1, iter2);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tContructor 'DoubleCompositeIterator' applied to";
            msg += "\n\tArgument iter1: " + this.iter1;
            msg += "\n\tArgument iter2: " + this.iter2;
            return msg;
        }
    }

    /** Add tests for the DoubleCompositeIterator contructor
     * to the overall test suite. */
    private void addTestSuiteFor$TestDoubleCompositeIterator$2
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("DoubleCompositeIterator");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_$1$iter
                = this.vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_Iter("DoubleCompositeIterator", 0);
            this.check_has_data
                (vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_$1$iter,
                 "this.vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_Iter(\"DoubleCompositeIterator\", 0)");
            while (!vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_$1$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleIterator[] iters
                    = (org.jmlspecs.jmlunit.strategies.DoubleIterator[]) vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_$1$iter.get();
                methodTests$.addTest
                    (new TestDoubleCompositeIterator$2(iters));
                vorg_jmlspecs_jmlunit_strategies_DoubleIterator$_$1$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the DoubleCompositeIterator contructor. */
    protected static class TestDoubleCompositeIterator$2 extends OneTest {
        /** Argument iters */
        private org.jmlspecs.jmlunit.strategies.DoubleIterator[] iters;

        /** Initialize this instance. */
        public TestDoubleCompositeIterator$2(org.jmlspecs.jmlunit.strategies.DoubleIterator[] iters) {
            super("DoubleCompositeIterator"+ ":" + (iters==null?"null":("{org.jmlspecs.jmlunit.strategies.DoubleIterator["+iters.length + "]"+"}")));
            this.iters = iters;
        }

        protected void doCall() throws java.lang.Throwable {
            new DoubleCompositeIterator(iters);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tContructor 'DoubleCompositeIterator' applied to";
            msg += "\n\tArgument iters: " + this.iters;
            return msg;
        }
    }

    /** Add tests for the atEnd method
     * to the overall test suite. */
    private void addTestSuiteFor$TestAtEnd
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("atEnd");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("atEnd", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"atEnd\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestAtEnd(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the atEnd method. */
    protected static class TestAtEnd extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestAtEnd(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("atEnd");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.atEnd();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'atEnd' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the getDouble method
     * to the overall test suite. */
    private void addTestSuiteFor$TestGetDouble
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("getDouble");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("getDouble", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"getDouble\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestGetDouble(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the getDouble method. */
    protected static class TestGetDouble extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestGetDouble(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("getDouble");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.getDouble();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'getDouble' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the advance method
     * to the overall test suite. */
    private void addTestSuiteFor$TestAdvance
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("advance");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("advance", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"advance\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestAdvance(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the advance method. */
    protected static class TestAdvance extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestAdvance(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("advance");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.advance();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'advance' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the clone method
     * to the overall test suite. */
    private void addTestSuiteFor$TestClone
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("clone");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("clone", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"clone\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestClone(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the clone method. */
    protected static class TestClone extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestClone(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("clone");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.clone();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'clone' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the toString method
     * to the overall test suite. */
    private void addTestSuiteFor$TestToString
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("toString");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("toString", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"toString\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestToString(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the toString method. */
    protected static class TestToString extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestToString(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("toString");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.toString();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'toString' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the get method
     * to the overall test suite. */
    private void addTestSuiteFor$TestGet
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("get");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter("get", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_jmlunit_strategies_DoubleCompositeIteratorIter(\"get\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$
                    = (org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestGet(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the get method. */
    protected static class TestGet extends OneTest {
        /** The receiver */
        private org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$;

        /** Initialize this instance. */
        public TestGet(org.jmlspecs.jmlunit.strategies.DoubleCompositeIterator receiver$) {
            super("get");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.get();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'get' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Check that the iterator is non-null and not empty. */
    private void
    check_has_data(org.jmlspecs.jmlunit.strategies.IndefiniteIterator iter,
                   String call)
    {
        if (iter == null) {
            junit.framework.Assert.fail(call + " returned null");
        }
        if (iter.atEnd()) {
            junit.framework.Assert.fail(call + " returned an empty iterator");
        }
    }

    /** Converts a char to a printable String for display */
    public static String charToString(char c) {
        if (c == '\n') {
            return "NL";
        } else if (c == '\r') {
            return "CR";
        } else if (c == '\t') {
            return "TAB";
        } else if (Character.isISOControl(c)) {
            int i = (int)c;
            return "\\u"
                    + Character.forDigit((i/2048)%16,16)
                    + Character.forDigit((i/256)%16,16)
                    + Character.forDigit((i/16)%16,16)
                    + Character.forDigit((i)%16,16);
        }
        return Character.toString(c);
    }
}
