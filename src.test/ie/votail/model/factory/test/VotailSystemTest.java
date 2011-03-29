// 2010-2011, Dermot Cochran, IT University of Copenhagen

package ie.votail.model.factory.test;

import ie.votail.model.ElectionConfiguration;
import ie.votail.model.ElectoralScenario;
import ie.votail.model.Method;
import ie.votail.model.Outcome;
import ie.votail.model.factory.BallotBoxFactory;
import ie.votail.model.factory.ScenarioFactory;
import ie.votail.model.factory.ScenarioList;

import java.io.IOException;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import election.tally.BallotCounting;
import election.tally.Constituency;
import election.tally.ElectionStatus;

public class VotailSystemTest extends TestCase {
    
  public static final String PR_STV = ".prstv";
  public static final String SCENARIO_LIST_FILENAME = "testdata/scenarios";

  @Test
  public void testPRSTV() {
    
    final int numberOfSeats = 5;
    final int numberOfCandidates = 11; // Ten possible outcomes plus one
    final int scope = numberOfCandidates;
    
    ScenarioFactory scenarioFactory = new ScenarioFactory();
    Logger logger = Logger.getLogger(BallotBoxFactory.LOGGER_NAME);
    logger.info("Using scope = " + scope);

    for (int seats = 1; seats <= numberOfSeats; seats++) {
      for (int candidates = 1 + seats; candidates <= numberOfCandidates; candidates++) {
        
        ScenarioList scenarioList =
            scenarioFactory.find(candidates, seats, Method.STV);
        
        // Save and replay the scenario list for use in other tests
        try {
          scenarioList.writeToFile (SCENARIO_LIST_FILENAME + VotailSystemTest.PR_STV);
        }
        catch (IOException e) {
          logger.severe("Unable to store scenario list, because " + e.getMessage());
        }
        
        for (ElectoralScenario scenario : scenarioList) {
          logger.info(scenario.toString());
          ElectionConfiguration electionConfiguration =
              createElection(scenario);
          Constituency constituency = electionConfiguration.getConstituency();
          BallotCounting ballotCounting = new BallotCounting();

          ballotCounting.setup(constituency);
          ballotCounting.load(electionConfiguration);
          ballotCounting.count();
          //@ assert (ballotCounting.getStatus() == ElectionStatus.FINISHED);
          logger.info(ballotCounting.getResults());
          logger.info(ballotCounting.getNumberOfRounds()
              + " rounds of counting ");
          if (!scenario.check(ballotCounting)) {
            logFailure(logger, scenario, electionConfiguration);
          }
        }
      }
    }
  }
  
  /**
   * Create an election configuration, including constituency and ballot box.
   * 
   * @param scenario
   *          The scenario for which to create this configuration
   * 
   * @return The election configuration
   */
  protected/*@ non_null @*/ElectionConfiguration createElection(
      ElectoralScenario scenario) {
    BallotBoxFactory ballotBoxFactory = new BallotBoxFactory();
    ElectionConfiguration electionConfiguration =
        ballotBoxFactory.extractBallots(scenario, scenario
            .getNumberOfCandidates());
    return electionConfiguration;
  }
  
  /**
   * Log information for failed or skipped scenarios.
   * 
   * @param logger
   *          The logging service to use
   * @param scenario
   *          The scenario which failed or was skipped
   * @param electionConfiguration
   *          The ballot box and candidates for this scenario
   */
  protected void logFailure(Logger logger, ElectoralScenario scenario,
      ElectionConfiguration electionConfiguration) {
    
    if (scenario.hasOutcome(Outcome.TiedSoreLoser)
        || electionConfiguration.size() == 0) {
      logger.info("Skipped this scenario " + scenario.toString());
    }
    else {
      logger.severe("Unexpected results for scenario " + scenario
          + " using predicate " + scenario.toPredicate() + " and ballot box "
          + electionConfiguration);
    }
  }
  
  public static void main(String[] args) {
    VotailSystemTest universalTest = new VotailSystemTest();
    universalTest.testPRSTV();
    universalTest.testPlurality();
  }
  
  @Test
  public void testPlurality() {
    
    final int numberOfCandidates = 7; // Six possible outcomes, plus one
    final int seats = 1;
    
    ScenarioFactory scenarioFactory = new ScenarioFactory();
    Logger logger = Logger.getLogger(BallotBoxFactory.LOGGER_NAME);
    
    for (int candidates = 1 + seats; candidates <= numberOfCandidates; candidates++) {
      
      final int scope = candidates;
      logger.info("Using scope = " + scope);
      
      ScenarioList scenarioList =
          scenarioFactory.find(candidates, seats, Method.Plurality);
      
      // Save and replay the scenario list for use in other tests
      try {
        scenarioList.writeToFile (SCENARIO_LIST_FILENAME + ".plurality");
      }
      catch (IOException e) {
        logger.severe("Unable to store scenario list, because " + e.getMessage());
      }
      
      for (ElectoralScenario scenario : scenarioList) {
        logger.info(scenario.toString());
        ElectionConfiguration electionConfiguration = createElection(scenario);
        Constituency constituency = electionConfiguration.getConstituency();
        BallotCounting ballotCounting = new BallotCounting();

        ballotCounting.setup(constituency);
        ballotCounting.load(electionConfiguration);
        ballotCounting.count();
        logger.info(ballotCounting.getResults());
        if (!scenario.check(ballotCounting)) {
          logFailure(logger, scenario, electionConfiguration);
        }
      }
    }
  }
}
