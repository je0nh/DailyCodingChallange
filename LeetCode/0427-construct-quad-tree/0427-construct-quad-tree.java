/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return makeQuadTree(grid, 0, 0, grid.length);
    }

    private Node makeQuadTree(int[][] grid, int row, int col, int size) {
        if (check(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        }

        int newSize = size / 2;
        Node topLeft = makeQuadTree(grid, row, col, newSize);
        Node topRight = makeQuadTree(grid, row, col  + newSize, newSize);
        Node bottomLeft = makeQuadTree(grid, row + newSize, col, newSize);
        Node bottomRight = makeQuadTree(grid, row + newSize, col + newSize, newSize);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean check(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for  (int j = col; j < col + size; j++) {
                if (val != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}