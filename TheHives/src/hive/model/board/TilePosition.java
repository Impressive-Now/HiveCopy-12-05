/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hive.model.board;

/**
 *
 * @author Thomas
 */
public class TilePosition
{
    public Cell cell;
    public int index;
    
    public TilePosition(Cell cell, int index)
    {
        this.cell = cell;
        this.index = index;
    }
    
}