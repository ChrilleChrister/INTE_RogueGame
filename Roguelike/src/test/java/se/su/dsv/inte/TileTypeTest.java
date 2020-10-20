package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTypeTest {

    @Test
    public void testTileTypeGrass() {
        assertEquals("Grass", TileType.GRASS.getName());
        assertEquals(1, TileType.GRASS.getxPosition());
        assertEquals(1, TileType.GRASS.getyPosition());
        assertEquals(1, TileType.GRASS.getTileTypeMovementSpeed());

    }

}