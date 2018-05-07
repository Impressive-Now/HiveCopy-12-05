/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.hexagons.iterators;

import util.hexagons.Hexagon;
import util.hexagons.HexagonSide;
import java.util.Iterator;

/**
 * Iterate over all the neighbors of a hexagon (all the neighbors must exist)
 * @author Thomas
 * @param <E>
 */
public class NeighborsIterator<E> implements Iterator<E>
{
    Hexagon<E> center;
    HexagonSide current;
    HexagonSide last;
    
    public NeighborsIterator(Hexagon<E> center)
    {
        this(center, HexagonSide.A);
    }
    
    public NeighborsIterator(Hexagon<E> center, HexagonSide side)
    {
        this.center = center;
        this.current = side;
        this.last = side.getBefore();
    }
    
    @Override
    public boolean hasNext()
    {
        return current != null;
    }
    
    @Override
    public E next()
    {
        assert hasNext();
        E value = center.getNeighbor(current).getValue();
        current = current != last ? current.getAfter() : null;
        return value;
    }
}
