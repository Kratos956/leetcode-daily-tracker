class Pair{
    int a;
    int b;
    Pair(int a ,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    int n;
    int m;
    int[] x_cord={-1,1,0,0};
    int[] y_cord={0,0,-1,1};
    boolean Valid(int i,int j){
        if(i>=0 && i<n && j>=0 && j<m) return true;
        return false;
    }
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    count++;
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    BFS(q,grid,visited);
                }
            }
        }
        boolean[][] secVisited=new boolean[n][m];
        int secCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i > 0 && i < n - 1 && j > 0 && j < m - 1) continue;
                if(grid[i][j]==0 && !secVisited[i][j]){
                    secCount++;
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    secVisited[i][j]=true;
                    BFS(q,grid,secVisited);
                }
            }
        }
        return count-secCount;
    }
    void BFS(Queue<Pair> q,int[][] grid,boolean[][] visited){
        while(!q.isEmpty()){
            Pair u=q.poll();
            int x=u.a;
            int y=u.b;
            for(int i=0;i<4;i++){
                if(Valid(x+x_cord[i],y+y_cord[i]) && grid[x+x_cord[i]][y+y_cord[i]] ==0 && !visited[x+x_cord[i]][y+y_cord[i]]){
                    visited[x+x_cord[i]][y+y_cord[i]]=true;
                    q.add(new Pair(x+x_cord[i],y+y_cord[i]));
                }
            }
        }
    }
}