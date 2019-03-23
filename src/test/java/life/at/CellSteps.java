package life.at;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yurap on 23.03.2019.
 */
public class CellSteps {

    private boolean cellIsDead;
    private int numberOfLiveNeighnbouns;

    @Given("a dead cell")
    public void givenADeadCell() {
        this.cellIsDead = true;
    }

    @Given("a live cell")
    public void givenALiveCell() {
        this.cellIsDead = true;
    }

    @Given("the cell has $livecells live neighbours")
    public void givenTheCellHas3LiveNeighbours(int livecells) {
        this.numberOfLiveNeighnbouns = livecells;
    }

    @When("the cell evolves to the next generation")
    public void whenTheCellEvolvesToTheNextGeneration() {
        this.cellIsDead = this.numberOfLiveNeighnbouns > 3;
    }

    @Then("the cell is now alive")
    public void thenTheCellIsNowAlive() {
        assertFalse(this.cellIsDead);
    }

    @Then("the cell is now dead")
    public void thenTheCellIsNowDead() {
        assertTrue(this.cellIsDead);
    }
}
