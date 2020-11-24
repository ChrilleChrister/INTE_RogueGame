package se.su.dsv.inte.map;

import java.util.Random;

//Henrik förslag, implementera hur snabbt man rör sig exempelvis. Movement-point kan spenderas till att ta slut.
//Kö av alla spelpjäser el prioritetskö. Spelare som går olika snabbt men prioritetskö. Timern. Tiden tickas ner.
//Mer tekniskt- generate world. Generera trovärdiga kartor? Norr ut alltid minus 25? För att få bort slump problem.
//Annan variant på kartor, Olika rum, dungeon crawl- inte super...
//Fraktaler, matematiskt koncept. (Mandelbrotmängden) Zoomar in på och en del av den blir kartan. Mandelbrotmängdgenerator, den används för att generera karta.


//Creates the map/world by creating an array of arrays of tiles, worldOfTiles.
public class TileGrid {
    private final int worldWidth;
    private final int worldHeight;
    protected final int MAX_NUMBER_OF_MOUNTAIN_TILES;
    protected int currentNumberOfMountainTiles;
    public Tile[][] worldOfTiles;

    // Image size (rest)
    private final int WIDTH = 60;
    private final int HEIGHT = 60;
    //Plot window
    private final int RE_START = -2;
    private final int RE_END = 2;
    private final int IM_START = -2;
    private final int IM_END = 2;
    private int xr = 60;
    private int yi = 60;
    //MAX_INT kanske kan vara 10?

//    public TileGrid(int worldWidth, int worldHeight) {
//        if (worldWidth < 1 || worldHeight < 1)
//            throw new IllegalArgumentException("World size too small");
//        this.worldWidth = worldWidth;
//        this.worldHeight = worldHeight;
//        MAX_NUMBER_OF_MOUNTAIN_TILES = 3;
//        worldOfTiles = generateWorld();
//    }

    //Mandelbrotfraction
    public TileGrid(int WIDTH, int HEIGHT) {
        if (WIDTH < 1 || HEIGHT < 1)
            throw new IllegalArgumentException("World size too small");
        this.WIDTH = WIDTH; // WIDTH? samt HEIGHT?
        this.HEIGHT = HEIGHT;
        MAX_NUMBER_OF_MOUNTAIN_TILES = 3;
        worldOfTiles = GenerateWorldByMandelbrot();
    }

    protected Tile[][] GenerateWorldByMandelbrot() {
        Tile[][] world = new Tile[WIDTH][HEIGHT];
        for (int x = 0; x <= world.length; x++) {
            for (int y = 0; y <= world[x].length; y++) {


                world[x][y] = new Tile(x * 64, y * 64, generateNumberMandelbrot());
            }
        }
        return world;
    }


    protected TileType makeTileTypesInTheTileGrid(int iteration) {
        System.out.println("tileType: " + iteration);

        if (iteration < 100) {
                    return TileType.GRASS;
                }
                else return TileType.MOUNTAIN;
            }

    protected TileType generateNumberMandelbrot() {
        int numbersofMountain = 0;
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {

                double c_re = (col - WIDTH / 2.0) * 4.0 / WIDTH;
                double c_im = (row - HEIGHT / 2.0) * 4.0 / WIDTH;


                double x = 0, y = 0;
                int iteration = 0;
                while (x * x + y * y <= 4 && iteration < 100) {
                    double x_new = x * x - y * y + c_re;
                    y = 2 * x * y + c_im;
                    x = x_new;
                    iteration++;
                }
                if (iteration < 100) {
                    //Räknare som adderar, är hälften svarta blir de mountain?

                    numbersofMountain++;
                }

            }

        }
        if (numbersofMountain > (HEIGHT * WIDTH / 2)) {
            return TileType.MOUNTAIN;
        } else
            return TileType.GRASS;
    }





//Om iterationer blir 100 = mountain tiles, om iterationer under något gräs, mellan det snö?


//                while (n <100){
//                    int aa = a * a - b*b;
//                    int bb = 2 * a *b;
//
//                    a = aa + a;
//                    b = bb + b;
//
//                    if (a + b > 16){
//                        break;
//                    }
//                    n ++;
//                }




                //Convert pixel??? coordinate to complex number
//                double c = complex(RE_START + (x / WIDTH) * (RE_END - RE_START),
//                        IM_START + (y / HEIGHT) * (IM_END - IM_START));
//                //Compute the number of iterations
//                int m = mandelbrot(c);
//                //The color? Tiletype depends on the number of iterations
//                world[x][y] = new Tile(x * 64, y * 64, makeTileFromMandelbrot(generateRandomNumber()));
//
//            }
//
//        }
//        return world;
//
//    }

//Tankar, bilden på mandelbrot. varje pixel är ju en färg/komplext tal. Ska jag zooma in till varje pixel och ha karta?
    //Eller om jag skapar karta, de olika tiletyperna är beroende på hur många pixlar inom varje ruta?

    //Kan man ta random nummer av alla iterations och börja där?


    public Tile[][] getWorldOfTiles() {
        return worldOfTiles;
    }

    private Tile[][] generateWorld() {
        Tile[][] world = new Tile[worldWidth][worldHeight];
        for (int i = 0; i < world.length; i++) { // Y
            for (int j = 0; j < world[i].length; j++) { // X

                world[i][j] = new Tile(i * 64, j * 64, makeRandomTileTypesInTheTileGrid(generateRandomNumber()));
            }
        }
        return world;
    }




    protected int generateRandomNumber() {
        Random randTile = new Random();
        int upperbound = 4;
        return randTile.nextInt(upperbound);
    }

    //The worldOfTiles have a greater chance to contain more grass than snow and mountain.
    protected TileType makeRandomTileTypesInTheTileGrid(int tileType) {
        switch (tileType) {
            case 0:
            case 1:
                return TileType.GRASS;
            case 2:
                return TileType.SNOW;
            case 3:
                if (currentNumberOfMountainTiles < MAX_NUMBER_OF_MOUNTAIN_TILES) {
                    currentNumberOfMountainTiles++;
                    return TileType.MOUNTAIN;
                }
                return TileType.GRASS;
            default:
                throw new IllegalArgumentException();
        }
    }
    }
