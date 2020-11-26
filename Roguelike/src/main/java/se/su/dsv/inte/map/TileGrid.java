package se.su.dsv.inte.map;

import java.util.ArrayList;
import java.util.Random;


//Henrik förslag på REST, välj mellan:
// implementera hur snabbt man rör sig exempelvis. Movement-point kan spenderas till att ta slut.
//Kö av alla spelpjäser el prioritetskö. Spelare som går olika snabbt men prioritetskö. Timern. Tiden tickas ner.
//Mer tekniskt- generate world. Generera trovärdiga kartor? Norr ut alltid minus 25? För att få bort slump problem.
//Fraktaler, matematiskt koncept. (Mandelbrotmängden) Zoomar in på och en del av den blir kartan. Mandelbrotmängdgenerator, den används för att generera karta.


//Creates the map/world by creating an array of arrays of tiles, worldOfTiles.
public class TileGrid {
//    private final int worldWidth;
//    private final int worldHeight;
//    protected final int MAX_NUMBER_OF_MOUNTAIN_TILES;
    protected int currentNumberOfMountainTiles;
    public Tile[][] worldOfTiles;
    private final int WIDTH;
    private final int HEIGHT;
    protected ArrayList<TileType> arraylistTileType = new ArrayList<TileType>();
    private double zoom;



//    public TileGrid(int worldWidth, int worldHeight) {
//        if (worldWidth < 1 || worldHeight < 1)
//            throw new IllegalArgumentException("World size too small");
//        this.worldWidth = worldWidth;
//        this.worldHeight = worldHeight;
//        MAX_NUMBER_OF_MOUNTAIN_TILES = 3;
//        worldOfTiles = generateWorld();
//    }

    //Constructor, creates world by using the Mandelbrot fraction
    public TileGrid(int WIDTH, int HEIGHT) {
        if (WIDTH < 1 || HEIGHT < 1)
            throw new IllegalArgumentException("World size too small");
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        worldOfTiles = generateWorldByMandelbrot();
    }

    protected Tile[][] generateWorldByMandelbrot() {
        Tile[][] world = new Tile[WIDTH][HEIGHT];

        //Map/World gets created from random/indexOfMapCreation in arraylist of Tiletypes created from mandelbrot fraction
        int index = indexOfMapCreation();
        zoom = zoomOfMandelbrot();
        for (int x = 0; x <= (world.length - 1); x++) {
            for (int y = 0; y <= (world[x].length - 1); y++) {

                world[x][y] = new Tile(x * 64, y * 64, getTiletypeFromArraylist(index));

                System.out.print(world[x][y].getTileType());
                System.out.print(" " + world[x][y].getxPosition()/64);
                System.out.print(" " + world[x][y].getyPosition()/64);
                System.out.println(" " + zoom + " " + index);
            }
        }
        System.out.println("Skriver jag ut världen två gg?, Svar ja!");
        //System.out.println("size av arraylist " + arraylistTileType.size() + " höjd och vidd x 2 " + (HEIGHT * WIDTH *2 ) + " index " + indexOfMapCreation);
        return world;
    }

    protected TileType getTiletypeFromArraylist(int indexOfMapCreation){
        addTiletypetoArraylistFromMandelbrot();

        TileType t = arraylistTileType.get(indexOfMapCreation);
        arraylistTileType.remove(indexOfMapCreation);


        return t;
    }


    protected void addTiletypetoArraylistFromMandelbrot() {
        TileType t = TileType.GRASS;
        int iteration = 0;


        //Mandelbrot fraction
        for (int row = 0; row < (HEIGHT * 2); row++) {
            for (int col = 0; col < (WIDTH * 2); col++) {

                double c_re = (col - (WIDTH * 2) / 2.0) * zoom / (WIDTH * 2);
                double c_im = (row - (HEIGHT * 2) / 2.0) * zoom / (WIDTH * 2);

                double x = 0, yi = 0;

                while (x * x + yi * yi < zoom && iteration < 450) {
                    double x_new = x * x - yi * yi + c_re;
                    yi = 2 * x * yi + c_im;
                    x = x_new;
                    iteration++;
                }
                //TileType depends on iterations
                if (iteration >= 450) {
                    t = TileType.GRASS;

                } else if (iteration < 450 && iteration > 150) {
                    t = TileType.SNOW;
                } else {
                    t = TileType.MOUNTAIN;
                }
            }
            //Tiletype gets added in arraylist
            arraylistTileType.add(t);
            }

    }





    public Tile[][] getWorldOfTiles() {
        return worldOfTiles;
    }

//    private Tile[][] generateWorld() {
//        Tile[][] world = new Tile[worldWidth][worldHeight];
//        for (int i = 0; i < world.length; i++) { // Y
//            for (int j = 0; j < world[i].length; j++) { // X
//
//                world[i][j] = new Tile(i * 64, j * 64, makeRandomTileTypesInTheTileGrid(generateRandomNumber()));
//            }
//        }
//        return world;
//    }




    protected int generateRandomNumber() {
        Random randTile = new Random();
        int upperbound = 4;
        return randTile.nextInt(upperbound);
    }

    protected int indexOfMapCreation() {
        Random randStart = new Random();

        int indexOfMapCreation = randStart.nextInt(WIDTH);
        return indexOfMapCreation;
    }


    protected double zoomOfMandelbrot() {
        Random randZoomInt = new Random();
        Random randZoomDouble = new Random();

        double zoomInt = randZoomInt.nextInt(10);
        double zoomDouble = randZoomDouble.nextDouble();
        return (zoomInt + zoomDouble);
    }

    //The worldOfTiles have a greater chance to contain more grass than snow and mountain.
//    protected TileType makeRandomTileTypesInTheTileGrid(int tileType) {
//        switch (tileType) {
//            case 0:
//            case 1:
//                return TileType.GRASS;
//            case 2:
//                return TileType.SNOW;
//            case 3:
//                if (currentNumberOfMountainTiles < MAX_NUMBER_OF_MOUNTAIN_TILES) {
//                    currentNumberOfMountainTiles++;
//                    return TileType.MOUNTAIN;
//                }
//                return TileType.GRASS;
//            default:
//                throw new IllegalArgumentException();
//        }
//    }
    }
