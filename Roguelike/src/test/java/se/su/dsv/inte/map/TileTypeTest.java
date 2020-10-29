package se.su.dsv.inte.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTypeTest {

    @Test
    public void testTileTypeGrass() {
        assertEquals("Grass", TileType.GRASS.getName());
        assertEquals(2, TileType.GRASS.getTileTypeMovementSpeed());
        assertTrue(TileType.GRASS.getIfTransversive());
    }

    @Test
    public void testTileTypeMountain() {
        assertEquals("Mountain", TileType.MOUNTAIN.getName());
        assertEquals(0, TileType.MOUNTAIN.getTileTypeMovementSpeed());
        assertFalse(TileType.MOUNTAIN.getIfTransversive());
    }

    @Test
    public void testTileTypeSnow() {
        assertEquals("Snow", TileType.SNOW.getName());
        assertEquals(1, TileType.SNOW.getTileTypeMovementSpeed());
        assertTrue(TileType.SNOW.getIfTransversive());
    }
}
