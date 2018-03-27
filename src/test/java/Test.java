import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.*;

import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test {
    private int sequence[] = new int[5];
    private  int bigSequence[] = new int[300];
    private int singleElement[] = new int[1];
    private int empty[] = new int[0];
    private SearchResult result;

    @Before
    public void initTest() {
        for (int i = 0; i < 5; i++)
        {
            sequence[i]=i+1;
        }
        for (int i = 0; i < 300; i++)
        {
            bigSequence[i]=i+1;
        }
        singleElement[0]=1;

    }

    @org.junit.Test
    public void elementFoundSequenceLen1() {
        SearchResult result = search(singleElement[0],singleElement);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(0));
    }

    @org.junit.Test
    public void elementNotFoundSequenceLen1() {
        SearchResult result = search(99,singleElement);
        assertThat (result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test
    public void elementFoundFirstSequence300() {
        SearchResult result = search(sequence[0],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(0));
    }

    @org.junit.Test
    public void elementFoundLastSequenceLen300() {
        SearchResult result = search(sequence[sequence.length-1],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(sequence.length - 1));
    }

    @org.junit.Test
    public void elementFoundMiddleSequenceLen300() {
        SearchResult result = search(sequence[3],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(3));
    }

    @org.junit.Test
    public void elementNotFoundSequenceLen300() {
        SearchResult result = search(15,sequence);
        assertThat (result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test
    public void elementFoundFirstSequence5() {
        SearchResult result = search(sequence[0],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(0));
    }

    @org.junit.Test
    public void elementFoundLastSequenceLen5() {
        SearchResult result = search(sequence[sequence.length - 1],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(sequence.length - 1));
    }

    @org.junit.Test
    public void elementFoundMiddleSequenceLen5() {
        SearchResult result = search(sequence[3],sequence);
        assertThat (result.isFound(), is(true));
        assertThat(result.getPosition(), is(3));
    }

    @org.junit.Test
    public void elementNotFoundSequenceLen5() {
        SearchResult result = search(15,sequence);
        assertThat (result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test
    public void searchEveryElementInSequence(){
        for (int i = 0; i < sequence.length; i++)
        {
            SearchResult result = search(i+1, sequence);
            assertThat (result.isFound(), is(true));
            assertThat(result.getPosition(), is(i));
        }
    }
}
