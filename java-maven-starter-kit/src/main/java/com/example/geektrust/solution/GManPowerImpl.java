package com.example.geektrust.solution;

import com.example.geektrust.util.GManConstants;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GManPowerImpl implements GManPower{
    private int sourceRow;
    private int sourceCol;
    private String sourceDirection;
    private int destinationRow;
    private int destinationCol;
    private final Queue<GManPositionInfo> positions;
    private final boolean [][][] visited=new boolean[GManConstants.MAX_ROW][GManConstants.MAX_COL][GManConstants.DIRECTION_COUNT];
    Map<String,Integer> m1;

    public GManPowerImpl(String source, String destination){
        String [] initialPosition=source.split(" ");
        String [] destinationPosition=destination.split(" ");
        setSourceRow(Integer.parseInt(initialPosition[1]));
        setSourceCol(Integer.parseInt(initialPosition[2]));
        setSourceDirection(initialPosition[3]);
        setDestinationRow(Integer.parseInt(destinationPosition[1]));
        setDestinationCol(Integer.parseInt(destinationPosition[2]));
        positions=new LinkedList<>();
        m1=new HashMap<>();
        m1.put("N",0);
        m1.put("E",1);
        m1.put("S",2);
        m1.put("W",3);
    }


    @Override
    public int getPower() {
        int ans=0;
        boolean flag=false;
        positions.add(new GManPositionInfo(getSourceRow(),getSourceCol(),GManConstants.power,getSourceDirection()));
        visited[getSourceRow()][getSourceCol()][m1.get(getSourceDirection())]=true;
        while (!positions.isEmpty()) {
                int c=positions.size();
                while(c-->0) {
                    GManPositionInfo positionInfo = positions.poll();
                    if (positionInfo.getRow() == getDestinationRow() && positionInfo.getCol() == getDestinationCol()) {
                        ans = Math.max(ans, positionInfo.getPower());
                        flag=true;
                    }
                    addCoordinatesToGManPosition(positionInfo.getRow(), positionInfo.getCol(), positionInfo.getPower(), positionInfo.getDirection());
                }
                if(flag)
                    break;

        }

        return ans;
    }




    private void addCoordinatesToGManPosition(int sR,int sC,int pow,String dir){
        switch (dir) {
            case GManConstants.NORTH:
                moveNorth(sR,sC,pow,dir);
                break;
            case GManConstants.EAST:
                moveEast(sR,sC,pow,dir);
                break;
            case GManConstants.SOUTH:
                moveSouth(sR,sC,pow,dir);
                break;
            default:
                moveWest(sR,sC,pow,dir);
                break;
        }
    }


    private void moveNorth(int sR,int sC,int pow,String dir){
        if ((sC + 1 < GManConstants.MAX_COL) && (!visited[sR][sC + 1][m1.get(dir)])) {
            positions.add(new GManPositionInfo(sR, sC + 1, pow - GManConstants.NEXT_CELL_MOVE, GManConstants.NORTH));
            visited[sR][sC + 1][0] = true;
        }
        if (!visited[sR][sC][1]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION,GManConstants.EAST));
            visited[sR][sC][1] = true;
        }
        if (!visited[sR][sC][3]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.WEST));
            visited[sR][sC][3] = true;
        }
    }


    private void moveEast(int sR,int sC,int pow,String dir){
        if ((sR + 1 < GManConstants.MAX_ROW) && (!visited[sR + 1][sC][m1.get(dir)])) {
            positions.add(new GManPositionInfo(sR + 1, sC, pow - GManConstants.NEXT_CELL_MOVE, GManConstants.EAST));
            visited[sR + 1][sC][1] = true;
        }
        if (!visited[sR][sC][0]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.NORTH));
            visited[sR][sC][0] = true;
        }
        if (!visited[sR][sC][2]) {
            positions.add(new GManPositionInfo(sR, sC, pow -GManConstants.SAME_CELL_DIRECTION, GManConstants.SOUTH));
            visited[sR][sC][2] = true;
        }
    }

    private void moveSouth(int sR,int sC,int pow,String dir){
        if ((sC - 1 >= GManConstants.MIN_ROW) && (!visited[sR][sC - 1][m1.get(dir)])) {
            positions.add(new GManPositionInfo(sR, sC - 1, pow - GManConstants.NEXT_CELL_MOVE, GManConstants.SOUTH));
            visited[sR][sC - 1][2] = true;
        }
        if (!visited[sR][sC][1]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.EAST));
            visited[sR][sC][1] = true;
        }
        if (!visited[sR][sC][3]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.WEST));
            visited[sR][sC][3] = true;
        }
    }

    private void moveWest(int sR,int sC,int pow,String dir){
        if ((sR - 1 >= GManConstants.MIN_ROW) && (!visited[sR - 1][sC][m1.get(dir)])) {
            positions.add(new GManPositionInfo(sR - 1, sC, pow - GManConstants.NEXT_CELL_MOVE, GManConstants.WEST));
            visited[sR - 1][sC][3] = true;
        }
        if (!visited[sR][sC][0]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.NORTH));
            visited[sR][sC][0] = true;
        }
        if (!visited[sR][sC][2]) {
            positions.add(new GManPositionInfo(sR, sC, pow - GManConstants.SAME_CELL_DIRECTION, GManConstants.SOUTH));
            visited[sR][sC][2] = true;
        }
    }



    public int getSourceRow() {
        return sourceRow;
    }

    public void setSourceRow(int sourceRow) {
        this.sourceRow = sourceRow;
    }

    public int getSourceCol() {
        return sourceCol;
    }

    public void setSourceCol(int sourceCol) {
        this.sourceCol = sourceCol;
    }

    public String getSourceDirection() {
        return sourceDirection;
    }

    public void setSourceDirection(String sourceDirection) {
        this.sourceDirection = sourceDirection;
    }

    public int getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(int destinationRow) {
        this.destinationRow = destinationRow;
    }

    public int getDestinationCol() {
        return destinationCol;
    }

    public void setDestinationCol(int destinationCol) {
        this.destinationCol = destinationCol;
    }
}
