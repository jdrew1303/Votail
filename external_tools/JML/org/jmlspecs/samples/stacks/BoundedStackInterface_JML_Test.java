// This file was generated by jmlunit on Tue May 20 17:43:11 EDT 2008.

package org.jmlspecs.samples.stacks;

/** Automatically-generated test driver for JML and JUnit based
 * testing of BoundedStackInterface. The superclass of this class should be edited
 * to supply test data. However it's best not to edit this class
 * directly; instead use the command
 * <pre>
 *  jmlunit BoundedStackInterface.java
 * </pre>
 * to regenerate this class whenever BoundedStackInterface.java changes.
 */
public class BoundedStackInterface_JML_Test
     extends BoundedStackInterface_JML_TestData
{
    /** Initialize this class. */
    public BoundedStackInterface_JML_Test(java.lang.String name) {
        super(name);
    }

    /** Run the tests. */
    public static void main(java.lang.String[] args) {
        org.jmlspecs.jmlunit.JMLTestRunner.run(suite());
        // You can also use a JUnit test runner such as:
        // junit.textui.TestRunner.run(suite());
    }

    /** Test to see if the code for interface BoundedStackInterface
     * has been compiled with runtime assertion checking (i.e., by jmlc).
     * Code that is not compiled with jmlc would not make an effective test,
     * since no assertion checking would be done. */
    public void test$IsRACCompiled() {
        junit.framework.Assert.assertTrue("code for interface BoundedStackInterface"
                + " was not compiled with jmlc"
                + " so no assertions will be checked!",
            org.jmlspecs.jmlrac.runtime.JMLChecker.isRACCompiled(BoundedStackInterface.class)
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
        BoundedStackInterface_JML_Test testobj
            = new BoundedStackInterface_JML_Test("BoundedStackInterface_JML_Test");
        junit.framework.TestSuite testsuite = testobj.overallTestSuite();
        // Add instances of Test found by the reflection mechanism.
        testsuite.addTestSuite(BoundedStackInterface_JML_Test.class);
        testobj.addTestSuiteForEachMethod(testsuite);
        return testsuite;
    }

    /** A JUnit test object that can run a single test method.  This
     * is defined as a nested class solely for convenience; it can't
     * be defined once and for all because it must subclass its
     * enclosing class.
     */
    protected static abstract class OneTest extends BoundedStackInterface_JML_Test {

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
     * BoundedStackInterface.  The framework will then run them.
     * @param overallTestSuite$ The suite accumulating all of the tests
     * for this driver class.
     */
    //@ requires overallTestSuite$ != null;
    public void addTestSuiteForEachMethod
        (junit.framework.TestSuite overallTestSuite$)
    {
        try {
            this.addTestSuiteFor$TestPop(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestPush(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestTop(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestGetSizeLimit(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestIsEmpty(overallTestSuite$);
        } catch (java.lang.Throwable ex) {
            overallTestSuite$.addTest
                (new org.jmlspecs.jmlunit.strategies.ConstructorFailed(ex));
        }
        try {
            this.addTestSuiteFor$TestIsFull(overallTestSuite$);
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
    }

    /** Add tests for the pop method
     * to the overall test suite. */
    private void addTestSuiteFor$TestPop
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("pop");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("pop", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"pop\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                methodTests$.addTest
                    (new TestPop(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the pop method. */
    protected static class TestPop extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestPop(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
            super("pop");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.pop();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'pop' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the push method
     * to the overall test suite. */
    private void addTestSuiteFor$TestPush
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("push");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("push", 1));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"push\", 1))");
            while (!receivers$iter.atEnd()) {
                org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                    vjava_lang_Object$1$iter
                    = this.vjava_lang_ObjectIter("push", 0);
                this.check_has_data
                    (vjava_lang_Object$1$iter,
                     "this.vjava_lang_ObjectIter(\"push\", 0)");
                while (!vjava_lang_Object$1$iter.atEnd()) {
                    final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                        = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                    final java.lang.Object x
                        = (java.lang.Object) vjava_lang_Object$1$iter.get();
                    methodTests$.addTest
                        (new TestPush(receiver$, x));
                    vjava_lang_Object$1$iter.advance();
                }
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the push method. */
    protected static class TestPush extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;
        /** Argument x */
        private java.lang.Object x;

        /** Initialize this instance. */
        public TestPush(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$, java.lang.Object x) {
            super("push"+ ":" + (x==null? "null" :"{java.lang.Object}"));
            this.receiver$ = receiver$;
            this.x = x;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.push(x);
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'push' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            msg += "\n\tArgument x: " + this.x;
            return msg;
        }
    }

    /** Add tests for the top method
     * to the overall test suite. */
    private void addTestSuiteFor$TestTop
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("top");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("top", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"top\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                methodTests$.addTest
                    (new TestTop(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the top method. */
    protected static class TestTop extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestTop(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
            super("top");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.top();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'top' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the getSizeLimit method
     * to the overall test suite. */
    private void addTestSuiteFor$TestGetSizeLimit
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("getSizeLimit");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("getSizeLimit", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"getSizeLimit\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                methodTests$.addTest
                    (new TestGetSizeLimit(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the getSizeLimit method. */
    protected static class TestGetSizeLimit extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestGetSizeLimit(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
            super("getSizeLimit");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.getSizeLimit();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'getSizeLimit' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the isEmpty method
     * to the overall test suite. */
    private void addTestSuiteFor$TestIsEmpty
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("isEmpty");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("isEmpty", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"isEmpty\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                methodTests$.addTest
                    (new TestIsEmpty(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the isEmpty method. */
    protected static class TestIsEmpty extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestIsEmpty(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
            super("isEmpty");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.isEmpty();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'isEmpty' applied to";
            msg += "\n\tReceiver: " + this.receiver$;
            return msg;
        }
    }

    /** Add tests for the isFull method
     * to the overall test suite. */
    private void addTestSuiteFor$TestIsFull
        (junit.framework.TestSuite overallTestSuite$)
    {
        junit.framework.TestSuite methodTests$
            = this.emptyTestSuiteFor("isFull");
        try {
            org.jmlspecs.jmlunit.strategies.IndefiniteIterator
                receivers$iter
                = new org.jmlspecs.jmlunit.strategies.NonNullIteratorDecorator
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("isFull", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"isFull\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
                methodTests$.addTest
                    (new TestIsFull(receiver$));
                receivers$iter.advance();
            }
        } catch (org.jmlspecs.jmlunit.strategies.TestSuiteFullException e$) {
            // methodTests$ doesn't want more tests
        }
        overallTestSuite$.addTest(methodTests$);
    }

    /** Test for the isFull method. */
    protected static class TestIsFull extends OneTest {
        /** The receiver */
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestIsFull(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
            super("isFull");
            this.receiver$ = receiver$;
        }

        protected void doCall() throws java.lang.Throwable {
            receiver$.isFull();
        }

        protected java.lang.String failMessage
            (org.jmlspecs.jmlrac.runtime.JMLAssertionError e$)
        {
            java.lang.String msg = "\n\tMethod 'isFull' applied to";
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
                    (this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter("clone", 0));
            this.check_has_data
                (receivers$iter,
                 "new NonNullIteratorDecorator(this.vorg_jmlspecs_samples_stacks_BoundedStackInterfaceIter(\"clone\", 0))");
            while (!receivers$iter.atEnd()) {
                final org.jmlspecs.samples.stacks.BoundedStackInterface receiver$
                    = (org.jmlspecs.samples.stacks.BoundedStackInterface) receivers$iter.get();
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
        private org.jmlspecs.samples.stacks.BoundedStackInterface receiver$;

        /** Initialize this instance. */
        public TestClone(org.jmlspecs.samples.stacks.BoundedStackInterface receiver$) {
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
