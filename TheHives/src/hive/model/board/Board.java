/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hive.model.board;

import util.Matrix;
import util.hexagons.CircularHexagonsGraph;

/**
 *
 * @author Thomas
 */
public class Board extends CircularHexagonsGraph<TilesStack>
{   
    public Board(Matrix<TilesStack> matrix)
    {
        super(matrix, new HiveNeighborsShifter());
    }
}