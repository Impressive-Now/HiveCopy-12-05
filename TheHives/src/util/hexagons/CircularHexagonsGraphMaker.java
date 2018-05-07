/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.hexagons;

import util.Matrix;
import util.Vector2i;

/**
 *
 * @author Thomas
 * @param <E>
 */
public class CircularHexagonsGraphMaker<E>
{
    public HexagonsGraph<E> make(Matrix<E> matrix, NeighborsOffsetGetter getter)
    {
        Vector2i dim = matrix.dimensions();
        Matrix<Hexagon<E>> hexagons = new Matrix<>(dim.x, dim.y);
        for(int y = 0; y < dim.y; ++y)
        {
            for(int x = 0; x < dim.x; ++x)
            {
                Vector2i pos = new Vector2i(x, y);
                Hexagon<E> h = new Hexagon<>(matrix.getAt(pos));
                hexagons.setAt(pos, h);
                for(HexagonSide side : HexagonSide.values())
                {
                    Vector2i neighbor_pos = (new Vector2i(pos)).add(getter.getOffset(side));
                    h.setNeighbor(side, hexagons.getAt(circular(neighbor_pos, dim)));
                }
            }
        }
        return new HexagonsGraph(hexagons.getAt(dim.x / 2, dim.y / 2));
    }
    
    private Vector2i circular(Vector2i p, Vector2i dim)
    {
        if(p.x < 0)
            p.x += dim.x;
        else if(p.x >= dim.x)
            p.x -= dim.x;
        if(p.y < 0)
            p.y += dim.y;
        else if(p.y >= dim.y)
            p.y -= dim.y;
        return p;
    }
}
