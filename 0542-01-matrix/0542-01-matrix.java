class Solution {
    static class Node{
        int i;
        int j;

        Node(int i, int j)
        {
            this.i = i;
            this.j =j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<Node> q = new LinkedList<>();

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Node(i,j));
                    vis[i][j] = true;
                }
            }
        }

        int[][] dir = {{1,0}, {0,1}, {-1,0},{0,-1}};

        while(!q.isEmpty())
        {
            Node node = q.poll();

            int u = node.i;
            int v = node.j;

            for(int di[] : dir)
            {
                int nu = di[0]+u;
                int nv = di[1]+v;

                 if (nu >= 0 && nv >= 0 && nu < n && nv < m && !vis[nu][nv]){

                    mat[nu][nv] = mat[u][v] + 1;

                    vis[nu][nv] = true;
                    q.offer(new Node(nu, nv));
                 }
            }
            
        }

         return mat;
    }
}