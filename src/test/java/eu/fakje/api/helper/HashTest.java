package eu.fakje.api.helper;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashTest
{
    @Test
    public void test_generating_md5_hash()
    {
        assertThat(Hash.md5("12345"), is("827ccb0eea8a706c4c34a16891f84e7b"));
    }
}
