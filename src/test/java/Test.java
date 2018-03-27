import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.*;

import static edu.iis.mto.bsearch.BinarySearch.search;

public class Test {
    private int sequence[] = new int[5];
    private int singleElement[] = new int[1];
    private SearchResult result;

    @Before
    public void initTest() {
        for (int i = 1; i < 5; i++)
        {
            sequence[i]=i+1;
        }
        singleElement[0]=1;

    }

    @org.junit.Test
    public void elementFoundSequenceLen1() {
        SearchResult result = search(1,singleElement);
        assert (result.isFound());
        assert(result.getPosition()==0);
    }

    @org.junit.Test
    public void elementNotFoundSequenceLen1() {
        SearchResult result = search(singleElement[0],singleElement);
        assert (!result.isFound());
        assert(result.getPosition()==-1);
    }

    @org.junit.Test
    public void elementFoundFirstSequenceLenMoreThan1() {
        SearchResult result = search (sequence[0],sequence);
        assert(result.isFound());
        assert(result.getPosition()==0);
    }

    @org.junit.Test
    public void elementFoundLastSequenceLenMoreThan1() {
        SearchResult result = search (sequence[sequence.length-1],sequence);
        assert(result.isFound());
        assert(result.getPosition()==sequence.length-1);
    }

    @org.junit.Test
    public void elementFoundMiddleSequenceLenMoreThan1() {
        SearchResult result = search (sequence[2],sequence);
        assert(result.isFound());
        assert(result.getPosition()==2);
    }

    @org.junit.Test
    public void elementNotFoundSequenceLenMoreThan1() {
        SearchResult result = search (sequence[sequence.length-1],sequence);
        assert(!result.isFound());
        assert(result.getPosition()==-1);
    }
}
