class Pair{
    int a;
    int b;
    Pair(int a ,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    boolean onboundary=false;
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
                    BFS(i,j,grid,visited);
                    if(onboundary){
                        count--;
                        onboundary=false;
                    }
                }
            }
            
        }
        return count;
    }
    void BFS(int e,int f,int[][] grid,boolean[][] visited){
        if(e == 0 || e == n - 1 || f == 0 || f == m - 1) onboundary=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(e,f));
        visited[e][f]=true;
        while(!q.isEmpty()){
            Pair u=q.poll();
            int x=u.a;
            int y=u.b;
            for(int i=0;i<4;i++){
                
                if(Valid(x+x_cord[i],y+y_cord[i]) && grid[x+x_cord[i]][y+y_cord[i]] ==0 && !visited[x+x_cord[i]][y+y_cord[i]]){
                    if(x + x_cord[i] == 0 ||
                        x + x_cord[i] == n - 1 ||
                        y + y_cord[i] == 0 ||
                        y + y_cord[i] == m - 1) onboundary=true;
                    visited[x+x_cord[i]][y+y_cord[i]]=true;
                    q.add(new Pair(x+x_cord[i],y+y_cord[i]));
                }
            }
        }
    }
}