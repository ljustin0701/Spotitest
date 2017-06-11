package ljust.com.spotitest.fragments;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpotFragmentTest {

    @Test
    public void testCreateFragment() {
        SpotFragment fragment = SpotFragment.create();

        assertNotNull(fragment);
    }
}