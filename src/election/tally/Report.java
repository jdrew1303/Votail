package election.tally;

/*
 * Copyright (c) 2005-2009 Dermot Cochran
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

/**
 * Latest election results for each constituency.
 *
 * @author Dermot Cochran
 */

/* <BON>
 * class_chart ELECTION_RESULT
 * indexing
 *   author: "Dermot Cochran";
 *   copyright: "2005-2009, Dermot Cochran";
 *   license: "MIT";
 *   modified: "2009-01-21-dc";
 * explanation
 *   "Information and statistics about the current results of the election."
 * query
 *   "How many candidates were elected?",
 *   "How many rounds of counting were performed?",
 *   "Which candidates were elected?",
 *   "In which round of counting was each candidate elected?",
 *   "Is this count now completed?",
 *   "Was the count successful?",
 *   "How many votes did each candidate receive in each round?"
 * constraint
 *   "The number of candidates elected is not less than zero",
 *   "The number of candidates elected is not more than the number of seats",
 *   "The total number of rounds of counting is not less than zero",
 *   "The list of elected candidates contains a valid internal identifier for each candidate",
 *   "The same internal identifier does not appear twice in the list of elected candidates",
 *   "The number of candidates elected at the end of each round is not less than the number of\
 *   \ candidates elected at the end of the previous round"
 *   "Not enough information is revealed to identify any voter"
 *   "Enough information is revealed in order to allow software independent verification of the\
 *   \ count results"
 *   "The results are immutable, once recorded and cannot be tampered with or otherwise modified\
 *   \ after the count is complete"
 * end
 * </BON>
 */

public class Report {
	
	/**
	 * Maximum number of seats in any constituency
	 */
	final static int MAX_SEATS = 5;
	
//@ public invariant 0 <= numberElected;
//@ public invariant numberElected <= MAX_SEATS;
	private /*@ spec_public @*/ int numberElected;

/*@ public invariant (\forall int i;
  @   0 < i && i < numberElected;
  @   0 < electedCandidateIDs[i] &&
  @   electedCandidateIDs[i] != Ballot.NONTRANSFERABLE);
  @ public invariant (\forall int i, j;
  @   0 <= i && i < numberElected &&
  @   0 <= j && j < numberElected && 
  @   i != j;
  @   electedCandidateIDs[i] != electedCandidateIDs[j]); 
  @*/
	private /*@ non_null spec_public @*/ int[] electedCandidateIDs;
	
/**
	 * @return the numberElected
	 */
	public /*@ pure @*/ int getNumberElected() {
		return numberElected;
	}

	/**
	 * @return the electedCandidateIDs
	 */
	public /*@ pure @*/ int[] getElectedCandidateIDs() {
		return electedCandidateIDs;
	}

	//@ public invariant 0 <= totalNumberOfCounts;
	private /*@ spec_public @*/ int totalNumberOfCounts;

	private String[] resultsAtEachCount;
	
	/**
	 * Store the election results for this constituency.
	 * 
	 * @param list The list of internal identifiers for the winner candidates
	 * @param counts The number of rounds of counting 
	 * @param candidates The list of candidates
	 */
	/*@ requires list.length <= MAX_SEATS;
	  @ requires 0 <= counts;
	  @*/
	public Report(/*@ non_null @*/ final int[] list, final int counts, Candidate[] candidates){
		numberElected = list.length;
		electedCandidateIDs = list;
		totalNumberOfCounts = counts;
		resultsAtEachCount = new String[counts];
		for (int i = 0; i < counts && i < Candidate.MAXCOUNT; i++){
			for (int c = 0; c < candidates.length; c++) {
				resultsAtEachCount[i] = "Candidate " + 
						candidates[c].getCandidateID() + " : " +
						candidates[c].getVoteAtCount(i) + "\n";
			}
			} 
		}

	/**
	 * @return the totalNumberOfCounts
	 */
	public /*@ pure @*/ 
	int getTotalNumberOfCounts() {
		return totalNumberOfCounts;
	}

	/**
	 * List the results for auditing.
	 * 
	 * @return The list of candidate IDs and number of rounds
	 */
	public /*@ pure @*/ StringBuffer getResults() {
		StringBuffer results = new StringBuffer();
		results.append("Number of rounds of counting: " + totalNumberOfCounts + "\n");
		results.append("Number of candidates elected: " + numberElected + "\n");
		results.append("List of candidates elected:");
		for (int c = 0; c < numberElected; c++) {
			results.append(" ");
			results.append(electedCandidateIDs[c]);
		}
		results.append("\n");
		for (int i = 0; i < totalNumberOfCounts; i++) {
			results.append("At count number ");
			results.append(i);
			results.append(":\n");
			results.append(resultsAtEachCount[i]);
		}
		return results;
	}
}
