/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.generators;

import kotlin.sequences.SequencesKt;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class GeneratorsKtTest
{
    @Test
    public void getSeed()
    {
        Assert.assertEquals(0L, GeneratorsKt.getSeed());
    }

    @Test
    public void setSeed()
    {
        GeneratorsKt.setSeed(123L);
        Assert.assertEquals(123L, GeneratorsKt.getSeed());
    }

    @Test
    public void bools()
    {
        Assert.assertThat(SequencesKt.asIterable(GeneratorsKt.bools()), hasItems(true, false));
    }

    @Test
    public void ints()
    {
        Assert.assertThat(SequencesKt.asIterable(GeneratorsKt.ints()), hasItems(0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

}