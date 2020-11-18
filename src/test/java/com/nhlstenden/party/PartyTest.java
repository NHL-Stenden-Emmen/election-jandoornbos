package com.nhlstenden.party;

import com.nhlstenden.exception.PositionAlreadyTakenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest
{
    private Party party;
    private Representative markRutte;
    private Representative klaasDijkhoff;
    private Representative andreBosman;

    @BeforeEach
    void beforeEach()
    {
        this.party = new Party("VVD", Orientation.RIGHT);

        this.markRutte = new Representative();
        this.klaasDijkhoff = new Representative();
        this.andreBosman = new Representative();
    }

    @Test
    void addRepresentative_AtFirstSpotInEmptyList()
    {
        this.party.addRepresentative(this.markRutte, 0);

        assertEquals(1, this.party.getRepresentatives().size());
        assertEquals(markRutte, this.party.getRepresentatives().get(2));
    }

    @Test
    void addRepresentative_AtFirstAvailableSpotInNotEmptyList()
    {
        this.party.addRepresentative(this.markRutte, 0);
        this.party.addRepresentative(this.klaasDijkhoff, 0);

        assertEquals(2, this.party.getRepresentatives().size());
        assertEquals(klaasDijkhoff, this.party.getRepresentatives().get(3));
    }

    @Test
    void addRepresentative_AtSpotThatIsAlreadyTaken()
    {
        this.party.addRepresentative(this.markRutte, 0);
        this.party.addRepresentative(this.klaasDijkhoff, 0);

        assertThrows(PositionAlreadyTakenException.class, () -> {
            this.party.addRepresentative(this.andreBosman, 2);
        });
    }
}