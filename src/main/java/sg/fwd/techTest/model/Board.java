package sg.fwd.techTest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {

    private int numberRows;
    private int numberColumns;

    private Tile[][] tiles;

    public Board(int numberRows, int numberColumns) {
        this.numberColumns = numberColumns;
        this.numberRows = numberRows;

        tiles = new Tile[numberRows][numberColumns];

        for (int rowIndex = 0; rowIndex < numberRows; rowIndex++ ) {
            for (int columnIndex = 0; columnIndex < numberColumns; columnIndex++ ) {
                tiles[ rowIndex ][ columnIndex ] = new Tile( rowIndex, columnIndex );
            }
        }
    }

    /**
     * @param tileId string format "rowId-columnId"
     *
     * @throws NullPointerException if tileId is null
     * @throws ArrayIndexOutOfBoundsException if tileId has an out of bounds rowIndex or columnIndex
     */
    public Tile get( String tileId ) {
        String[] indices = tileId.split( "-" );
        if ( indices.length != 2 ) {
            return null;
        }

        int rowIndex = Integer.valueOf( indices[ 0 ] );
        int columnIndex = Integer.valueOf( indices[ 1 ] );
        return get( rowIndex, columnIndex );
    }


    /**
     * @throws ArrayIndexOutOfBoundsException if rowIndex or columnIndex are out of bounds
     */
    public Tile get( int rowIndex, int columnIndex ) {
        return tiles[ rowIndex ][ columnIndex ];
    }

    public Tile getRandomAvailable() {
        List<Tile> available = new ArrayList<Tile>();

        for ( Tile[] row : tiles ) {
            for ( Tile tile : row ) {
                if ( tile.isEmpty() ) {
                    available.add( tile );
                }
            }
        }

        if ( available.isEmpty() ) {
            return null;
        }

        int randomNum = new Random().nextInt( available.size() );
        return available.get( randomNum );
    }

    public boolean isFull() {
        for ( Tile[] row : tiles ) {
            for ( Tile tile : row ) {
                if( tile.isEmpty() ) {
                    return false;
                }
            }
        }

        return true;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public List<Tile> getRow( int rowIndex ) {
        return Arrays.asList( tiles[ rowIndex ] );
    }

    public List<Tile> getColumn( int columnIndex ) {
        List<Tile> column = new ArrayList<Tile>();

        for ( Tile[] row : tiles ) {
            column.add( row[ columnIndex ] );
        }

        return column;
    }

    public List<Tile> getDiagonalLeftTopBottomRight() {
        return Arrays.asList( get( 0, 0 ), get( 1, 1 ), get( 2, 2 ) );
    }

    public List<Tile> getDiagonalRightTopBottomLeft() {
        return Arrays.asList( get( 0, 2 ), get( 1, 1 ), get( 2, 0 ) );
    }

    public List<List<Tile>> getAllLines() {
        List<List<Tile>> lines = new ArrayList<List<Tile>>();

        for (int i = 0; i < numberRows; i++ ) {
            lines.add( getRow( i ) );
        }

        for (int j = 0; j < numberColumns; j++ ) {
            lines.add( getColumn( j ) );
        }

        lines.add( getDiagonalLeftTopBottomRight() );
        lines.add( getDiagonalRightTopBottomLeft() );

        return lines;
    }

    public void reset() {
        for ( Tile[] row : tiles ) {
            for ( Tile tile : row ) {
                tile.setValue( Tile.Value.EMPTY );
            }
        }
    }
}
