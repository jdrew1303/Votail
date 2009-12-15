// This file was generated by jmlunit on Tue May 20 17:42:42 EDT 2008.

package org.jmlspecs.samples.list.list1;

import org.jmlspecs.samples.list.iterator.Iterator;
import org.jmlspecs.samples.list.iterator.RestartableIterator;

/** Automatically-generated test driver for JML and JUnit based
 * testing of ListIterator. The superclass of this class should be edited
 * to supply test data. However it's best not to edit this class
 * directly; instead use the command
 * <pre>
 *  jmlunit ListIterator.java
 * </pre>
 * to regenerate this class whenever ListIterator.java changes.
 */
public class ListIterator_JML_Test
     extends ListIterator_JML_TestData
{
    /** Initialize this class. */
    public ListIterator_JML_Test(java.lang.String name) {
        super(name);
    }

    /** Run the tests. */
    public static void main(java.lang.String[] args) {
        org.jmlspecs.jmlunit.JMLTestRunner.run(suite());
        // You can also use a JUnit test runner such as:
        // junit.textui.TestRunner.run(suite());
    }

    /** Test to see if the code for class ListIterator
     * has been compiled with runtime assertion checking (i.e., by jmlc).
     * Code that is not compiled with jmlc would not make an effective test,
     * since no assertion checking would be done. */
    public void test$IsRACCompiled() {
        junit.framework.Assert.assertTrue("code for class ListIterator"
                + " was not compiled with jmlc"
                + " so no assertions will be checked!",
            org.jmlspecs.jmlrac.runtime.JMLChecker.isRACCompiled(ListIterator.class)
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
        ListIterator_JML_Test testobj
            = new ListIterator_JML_Test("ListIterator_JML_Test");
        junit.framework.TestSuite testsuite = testobj.overallTestSuite();
        // Add instances of Test found by the reflection mechanism.
        testsuite.addTestSuite(ListIterator_JML_Test.class);
        testobj.addTestSuiteForEachMethod(testsuite);
        return testsuite;
    }

    /** A JUnit test object that can run a single test method.  This
     * is defined as a nested class solely for convenience; it can't
     * be defined once and for all because it must subclass its
     * enclosing class.
     */
    protected static abstract class OneTest extends ListIterator_JML_Test {

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
     * ListIterator.  The framework will then run them.
     * @param overallTestSuite$ The suite accumulating all of the tests
     * for this driver class.
     */
    //@ requires overallTestSuite$ != null;
    public void addTestSuiteForEachMethod
        (junit.framework.TestSuite overallTestSuite$)
    {
        try {
            this.addTestSuiteFor$TestListIterator(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestFirst(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestNext(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestIsDone(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestCurrentItem(overallTestSuite$);
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
    }

    /** Add tests for the ListIterator contructor
     * to the overall test suite. */
    private void addTestSuiteFor$TestListIterator
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("ListIterator");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                vorg_jmlspecs_samples_list_list1_E_SLList$1$iter
                = this.vorg_jmlspecs_samples_list_list1_E_SLListIter("ListIterator", 0);
            this.check_has_data
                (vorg_jmlspecs_samples_list_list1_E_SLList$1$iter,
                 "this.vorg_jmlspecs_samples_list_list1_E_SLListIter(\"ListIterator\", 0)");
            while (!vorg_jmlspecs_samples_list_list1_E_SLList$1$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.E_SLList lst
                    = (org.jmlspecs.samples.list.list1.E_SLList) vorg_jmlspecs_samples_list_list1_E_SLList$1$iter.get();
                methodTests$.addTest
                    (new TestListIterator(lst));
                vorg_jmlspecs_samples_list_list1_E_SLList$1$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the ListIterator contructor. */
    protected static class TestListIterator extends OneTest {
        /** Argument lst */
        private org.jmlspecs.samples.list.list1.E_SLList lst;

        /** Initialize this instance. */
        public TestListIterator(org.jmlspecs.samples.list.list1.E_SLList lst) {
            super("ListIterator"+ ":" + (lst==null? "null" :"{org.jmlspecs.samples.list.list1.E_SLList}"));
            this.lst = lst;
        }

        protected void doCall() throws java.lang.Throwable {
            new ListIterator(lst);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tContructor 'ListIterator' applied to";
            msg += "\n\tArgument lst: " + this.lst;
            return msg;
        }
    }

    /** Add tests for the first method
     * to the overall test suite. */
    private void addTestSuiteFor$TestFirst
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("first");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_list_list1_ListIteratorIter("first", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_list_list1_ListIteratorIter(\"first\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.ListIterator receiver$
                    = (org.jmlspecs.samples.list.list1.ListIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestFirst(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the first method. */
    protected static class TestFirst extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.list.list1.ListIterator receiver$;

        /** Initialize this instance. */
        public TestFirst(org.jmlspecs.samples.list.list1.ListIterator receiver$) {
            super("first");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.first();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'first' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the next method
     * to the overall test suite. */
    private void addTestSuiteFor$TestNext
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("next");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_list_list1_ListIteratorIter("next", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_list_list1_ListIteratorIter(\"next\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.ListIterator receiver$
                    = (org.jmlspecs.samples.list.list1.ListIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestNext(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the next method. */
    protected static class TestNext extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.list.list1.ListIterator receiver$;

        /** Initialize this instance. */
        public TestNext(org.jmlspecs.samples.list.list1.ListIterator receiver$) {
            super("next");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.next();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'next' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the isDone method
     * to the overall test suite. */
    private void addTestSuiteFor$TestIsDone
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("isDone");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_list_list1_ListIteratorIter("isDone", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_list_list1_ListIteratorIter(\"isDone\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.ListIterator receiver$
                    = (org.jmlspecs.samples.list.list1.ListIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestIsDone(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the isDone method. */
    protected static class TestIsDone extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.list.list1.ListIterator receiver$;

        /** Initialize this instance. */
        public TestIsDone(org.jmlspecs.samples.list.list1.ListIterator receiver$) {
            super("isDone");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.isDone();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'isDone' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the currentItem method
     * to the overall test suite. */
    private void addTestSuiteFor$TestCurrentItem
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("currentItem");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_list_list1_ListIteratorIter("currentItem", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_list_list1_ListIteratorIter(\"currentItem\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.ListIterator receiver$
                    = (org.jmlspecs.samples.list.list1.ListIterator) receivers$iter.get();
                methodTests$.addTest
                    (new TestCurrentItem(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the currentItem method. */
    protected static class TestCurrentItem extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.list.list1.ListIterator receiver$;

        /** Initialize this instance. */
        public TestCurrentItem(org.jmlspecs.samples.list.list1.ListIterator receiver$) {
            super("currentItem");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.currentItem();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'currentItem' applied to";
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
                    (this.vorg_jmlspecs_samples_list_list1_ListIteratorIter("toString", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_list_list1_ListIteratorIter(\"toString\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.list.list1.ListIterator receiver$
                    = (org.jmlspecs.samples.list.list1.ListIterator) receivers$iter.get();
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
        private org.jmlspecs.samples.list.list1.ListIterator receiver$;

        /** Initialize this instance. */
        public TestToString(org.jmlspecs.samples.list.list1.ListIterator receiver$) {
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
