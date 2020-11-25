package se.su.dsv.inte.map;

import java.util.ArrayList;
import java.util.Random;


//Henrik förslag, implementera hur snabbt man rör sig exempelvis. Movement-point kan spenderas till att ta slut.
//Kö av alla spelpjäser el prioritetskö. Spelare som går olika snabbt men prioritetskö. Timern. Tiden tickas ner.
//Mer tekniskt- generate world. Generera trovärdiga kartor? Norr ut alltid minus 25? För att få bort slump problem.
//Annan variant på kartor, Olika rum, dungeon crawl- inte super...
//Fraktaler, matematiskt koncept. (Mandelbrotmängden) Zoomar in på och en del av den blir kartan. Mandelbrotmängdgenerator, den används för att generera karta.


//Creates the map/world by creating an array of arrays of tiles, worldOfTiles.
public class TileGrid {
//    private final int worldWidth;
//    private final int worldHeight;
//    protected final int MAX_NUMBER_OF_MOUNTAIN_TILES;
    protected int currentNumberOfMountainTiles;
    public Tile[][] worldOfTiles;

    // Image size (rest)
    private final int WIDTH;
    private final int HEIGHT;
    protected int MaxIterationsMandelbrot;
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    ArrayList<TileType> arrayListTileType = new ArrayList<TileType>();




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
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        worldOfTiles = generateWorldByMandelbrot();
    }

    protected Tile[][] generateWorldByMandelbrot() {
        Tile[][] world = new Tile[WIDTH][HEIGHT];
        int whereToStartInArray = generateStartWhereInArray();
        for (int x = 0; x <= (world.length - 1); x++) {
            for (int y = 0; y <= (world[x].length - 1); y++) {

                world[x][y] = new Tile(x * 64, y * 64, returnCorrectTileType(whereToStartInArray));

                System.out.print(world[x][y].getTileType());
                System.out.print(" " + world[x][y].getxPosition()/64);
                System.out.println(" " + world[x][y].getyPosition()/64);

//        TileType t;
//        int y;
//        int iteration = 0;
//        for (int x = 0; x <= (world.length -1) ; x++) {
//            for (y = 0; y <= (world[x].length -1) ; y++) {


//                    double c_re = ((world[x].length -1) - WIDTH / 2.0) * 4.0 / WIDTH;
//                    double c_im = ((world.length -1) - HEIGHT / 2.0) * 4.0 / WIDTH;
//
//                    double xi = 0, yi = 0;
//
//                    while (xi * xi + yi * yi < 4 && iteration < 100) {
//                        double x_new = xi * xi - yi * yi + c_re;
//                        yi = 2 * xi * yi + c_im;
//                        xi = x_new;
//                        iteration++;
//                    }
//
//                    if (iteration >= 100) {
//                        System.out.println("tileType: Grass " + iteration);
//                        t = TileType.GRASS;
//
//                    } else if (iteration < 100 && iteration > 50) {
//                        System.out.println("tileType: Snö " + iteration);
//                        t = TileType.SNOW;
//                    } else {
//                        System.out.println("tileType: Mountain " + iteration);
//                        t = TileType.MOUNTAIN;
//                    }


                //System.out.print(" tiletype: " + t);

               // world[x][y] = new Tile(x * 64, y * 64, generateTilesByMandelbrot(generateMaxNumberForIterationInMandelbrot()) );
                //System.out.print(world[x][y]);
            }

        }

        return world;
        }




    public void metohodforArrayCreation() {

        TileType t = TileType.GRASS;
//        //double yi;
       int iteration = 0;
//
//        if (WIDTH < 1 || HEIGHT < 1)
//            throw new IllegalArgumentException("World size too small");
//        this.WIDTH = WIDTH;
//        this.HEIGHT = HEIGHT;

        //TileType t = TileType.GRASS;

        //int iteration = 0;

        for (int row = 0; row < 20; row++) { //TODO om width och Hight är högre, blir de fler platser i arrayen?
            for (int col = 0; col < 20; col++) { //Här ökar col med 1 upp till 13, sedan ökar rad till 1 och denna ittererar upp till 14

                double c_re = (col - 20 / 2.0) * 4.0 / 20; //Testar 20 istället för width och height
                double c_im = (row - 20 / 2.0) * 4.0 / 20;

                double x = 0, yi = 0;

                while (x * x + yi * yi < 4 && iteration < 200) {
                    double x_new = x * x - yi * yi + c_re;
                    yi = 2 * x * yi + c_im;
                    x = x_new;
                    iteration++;
                }
            //System.out.print(iteration +" kolumn " + col);
                if (iteration >= 200) { //Här ska tile 0,0 bli gräs
                   // System.out.println("tileType: Grass " + iteration + " rad: "+ row);
                    t = TileType.GRASS;

                } else if (iteration < 200 && iteration > 50) {
                    //System.out.println("tileType: Snö " + iteration + " rad: " + row );
                    t = TileType.SNOW;
                } else {
                    //System.out.println("tileType: Mountain " + iteration+ " rad: " + row );
                    t = TileType.MOUNTAIN;
                }
            }

           // System.out.println("Vad händer här " + t + " " + iteration); //Detta måste bli klart, sedan kan t börja skickas
//Här finns massa t,

            arraylist.add((iteration));
            arrayListTileType.add(t);
           //System.out.println("Vad händer här " + t + " " + arrayListTileType);



            }





            //System.out.print(" " + t +" " + iteration); // HÄR ÄR DE BRA; DE BLIR OLIKA TYPER AV TILES JIPPIE
            //return t ; Skapa tiles här och returnera world vid retur?

//            Tile[][] world = new Tile[WIDTH][HEIGHT];
//            int y;
//            for (int x = 0; x <= (world.length - 1); x++) {
//                for (y = 0; y <= (world[x].length - 1); y++) {
//                    world[x][y] = new Tile(x * 64, y * 64, t);
//                    //System.out.println(world[x][y].getTileType());
//
//                }
//
//            }
//            worldOfTiles = world;
            //System.out.print(t);
//
//        }

//        Iterator iter = arraylist.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//
//        }
        //return t;
    }
//        }
//

 //   }
//
public TileType returnCorrectTileType(int whereToStartInArray){
        metohodforArrayCreation();
    TileType t;

    //Randomisera var i arrayen av tiles vi börjar för att kunna få olika världar





    //Iterator iter = arraylist.iterator();
      //  while (iter.hasNext()) {
           // System.out.println(iter.next());
          //  for (int i = 0; i < arrayListTileType.size(); i++) {

//                if (arraylist.get(i) >=200){ //Här ska tile 0,0 bli gräs
//                    // System.out.println("tileType: Grass " + iteration + " rad: "+ row);
//                    t = TileType.GRASS;
//
//                }
//                else if (arraylist.get(i) < 200 && arraylist.get(i) > 50) {
//                    //System.out.println("tileType: Snö " + iteration + " rad: " + row );
//                    t = TileType.SNOW;
//                } else {
//                    //System.out.println("tileType: Mountain " + iteration+ " rad: " + row );
//                    t = TileType.MOUNTAIN;
//                }

                t = arrayListTileType.get(whereToStartInArray);
               arrayListTileType.remove(whereToStartInArray);
     //       }
    return t;

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



    protected int generateMaxNumberForIterationInMandelbrot() {
        Random randInterlval = new Random();

        //Generates a number at atleast 200 intervals, up to a maximum of 400 intervals
        int numberOfIntervals = randInterlval.nextInt(200) + 200;
        return numberOfIntervals;
    }

    protected int generateStartWhereInArray() {
        Random randStart = new Random();

        //Generates a number at atleast 200 intervals, up to a maximum of 400 intervals
        int numberforStart = randStart.nextInt(20);
        return numberforStart;
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
