package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTypeTest {

    @Test
    public void testTileTypeGrass() {
        assertEquals("Grass", TileType.GRASS.getName());
        assertEquals(2, TileType.GRASS.getTileTypeMovementSpeed());

    }
    @Test
    public void testTileTypeMountain() {
        assertEquals("Mountain", TileType.MOUNTAIN.getName());
        assertEquals(0, TileType.MOUNTAIN.getTileTypeMovementSpeed());

    }
    @Test
    public void testTileTypeSnow() {
        assertEquals("Snow", TileType.SNOW.getName());
        assertEquals(1, TileType.SNOW.getTileTypeMovementSpeed());

    }

}