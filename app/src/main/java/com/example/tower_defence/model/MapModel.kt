package com.example.tower_defence.model

import kotlin.random.Random

class MapModel(val height: Int = 16, val width: Int = 8) {

    var map : Array<Array<Terrain>>
    var directionList = ArrayList<String>()
    var posList = ArrayList<Array<Int>>()


    init {
        this.map = generateMap(this.width, this.height)
    }


    /*fun getLinearMap() : ArrayList<Int> {
        var linearMap  = ArrayList<Int>()
        for (row in this.map) {
            linearMap += row
        }
        return linearMap
    }*/


    fun getLinearPath() : ArrayList<Int> {
        var linPosList = arrayListOf<Int>()
        for (coordinate in posList) {
            linPosList.add(coordinate[0] * this.height + coordinate[1])
        }
        return linPosList
    }


    fun mapLayout() : Array<Array<Int>>{
        val map = arrayOf(
            arrayOf(1,0,1),
            arrayOf(1,0,0),
            arrayOf(1,1,1)
        )
        return map
    }


    fun printMap(array: Array<Array<Int>>) {

        for (i in 0..15) {
            for (j in 0..7) {
                print(" " +array[i][j])
            }
            println()
        }
    }


    private fun generatePath(
        map : Array<Array<Int>>, // the map to edit.
        width : Int = 8, // x ratio of the board
        height : Int = 16, // y ratio of the board
        bounds : Int = 1,
        leftOrRightChance : Int = 30, // chance the path turns
        downChance : Int = 25 // chance the path turns if going horizontal already
    ): Array<Array<Int>>{

        var direction = Direction.DOWN
        var done = false
        var rPos = 0
        var cPos = Random.nextInt(0,width-bounds)
        map[rPos][cPos] = 0
        directionList.add("DOWN")
        posList.add(arrayOf(rPos,cPos))
        rPos += 1

        // Creates Path
        while (!done) {
            // Moves Forward (Whichever direction its currently going,
            // without going out of bounds).
            map[rPos][cPos] = 0

            if (direction == Direction.DOWN && rPos < height-bounds) {
                rPos += 1
                directionList.add("DOWN")
                posList.add(arrayOf(rPos,cPos))
            } else if (direction == Direction.UP && rPos > bounds) {
                rPos -= 1
                directionList.add("UP")
                posList.add(arrayOf(rPos,cPos))
            } else if (direction == Direction.LEFT && cPos > bounds) {
                cPos -= 1
                directionList.add("LEFT")
                posList.add(arrayOf(rPos,cPos))
            } else if (direction == Direction.RIGHT && cPos < width-bounds-1) {
                cPos += 1
                directionList.add("RIGHT")
                posList.add(arrayOf(rPos,cPos))
            }

            // random chance of turning.
            val randomNum = Random.nextInt(0,100)
            if (direction == Direction.DOWN || direction == Direction.UP) {
                // if it is less than chance (0-chance = chance)
                if (randomNum < leftOrRightChance) {
                    direction = Direction.LEFT
                } else if (randomNum > 100-leftOrRightChance) {
                    direction = Direction.RIGHT
                }
            } else if (direction == Direction.RIGHT || direction == Direction.LEFT) {
                if (randomNum < downChance) {
                    direction = Direction.DOWN
                } //else if (randomNum > 100-downChance) {
                //direction = Direction.UP
                //}
            }

            if (rPos >= 15) {
                done = true
            }
        }
        //map[rPos][cPos] = 0
        //rPos += 1
        map[rPos][cPos] = 0
        rPos += 1
        directionList.add("DOWN")
        posList.add(arrayOf(rPos,cPos))

        return map
    }



    private fun  generateWater(
        map : Array<Array<Int>>,
        width : Int = 8, // x ratio of the board
        height : Int = 16, // y ratio of the board
        waterChance : Int = 2 // chance of water spawning per tile
    ):Array<Array<Int>> {
        for (i in 0..height-1) {
            for (j in 0..width-1) {
                if (map[i][j] >= 1){
                    val randomNum = Random.nextInt(0,100)
                    if (randomNum <= waterChance) {
                        map[i][j] = 3
                    }
                    else if(
                        (i-1 >= 0 && map[i-1][j] == 3) ||
                        (i+1 < height && map[i+1][j] == 3) ||
                        (j-1 >= 0 && map[i][j-1] == 3) ||
                        (j+1 < width && map[i][j+1] == 3)
                    ) {
                        if (randomNum >= 50) {
                            map[i][j] = 3
                        }

                    }
                }

            }
        }

        return map
    }


    fun intMapToLandMap(
        oldMap : Array<Array<Int>>,
        width : Int = 8, // x ratio of the board
        height : Int = 16, // y ratio of the board
    ): Array<Array<Terrain>> {
        var newMap : Array<Array<Terrain>> = Array(height) { Array(width){ Terrain() } }

        for (i in 0..height-1) {
            for (j in 0..width-1) {
                var typeOfTerrain = when (oldMap[i][j]) {
                    0 -> Road(j, i)
                    1 -> Grass(j, i)
                    3 -> Water(j, i)
                    else -> Grass(j, i)
                }
                newMap[i][j] = typeOfTerrain
            }
        }
        return newMap

    }

    fun generateMap(
        width : Int = 8, // x ratio of the board
        height : Int = 16, // y ratio of the board
    ): Array<Array<Terrain>> {
        // creates a 16x8 array of grass
        var map : Array<Array<Int>> = Array(height) {Array(width){1}}

        /*       width(8)
                [       ]
                [       ] height(16)
                [       ]
         */

        map = generateWater(map = map)

        map = generatePath(map = map, width = width, height = height)

        val newMap = intMapToLandMap(map)

        return newMap
    }

    enum class Direction {
        UP, DOWN, LEFT, RIGHT
    }

}