

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;



public class Maze {
    public static void main(String[] args) {
        //
        JFrame frame = new JFrame();
        frame.setSize(650, 470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mp = new MazePanel();
        frame.add(mp);
        frame.setVisible(true);
    }

    public static class MazePanel extends JPanel {
        private static final long serialVersionUID = -566807999447681130L;
        private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
        private int sizeh, sizew, start, end;

        private int[][] sign = new int[21][31];
        public MazePanel() {
            // Kích thước ma trận
            sizeh = 21; // so dong
            sizew = 31; // so cot
            start = 10;
            end = 0;
            //solve(maze,start,end,sizeh,sizew);
            run();
            repaint(); // vẽ ma trận và lời giải
        }

        /**
         * Implement một phương pháp tìm đường nào đó.
         * <p>
         * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
         * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
         * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
         * <p>
         * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
         * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
         */

        /**
         *
         * @param maz me cung
         * @param x toa do x vi tri hien tai
         * @param y toa do y vi tri hien tai
         * @param m gioi han chieu rong me cung
         * @param n gioi han chieu dai me cung
         * @return
         */
        public boolean solve(int [][]maz , int x, int y, int m, int n) {
            // Hàm này chứa phương pháp tìm đường từ điểm start đến vị
            // trí màu đỏ trên ma trận
            if(x >= m || x < 0 || y >= n || y < 0 ) return false; // neu vuot qua kich thuoc ma tran
            else if(maz[x][y] == 3) return false; // neu diem da di
            else if(maz[x][y] == 2) return true; // den den dich
            else if(maz[x][y] == 1) return false; // neu gap tuong
            else{ // neu max[x][y] = 0
                maz[x][y] = 3;
                if(solve(maz,x+1,y,m,n)) return true; // neu di sang trai duoc
                if(solve(maz,x-1,y,m,n)) return true; // neu di sang phai duoc
                if(solve(maz,x,y+1,m,n)) return true; // neu di len tren duoc
                if(solve(maz,x,y-1,m,n)) return true; // neu di xuong duoi duoc
                // neu ca 4 phia deu khong di duoc thi dat lai maz[x][y] va tra ve false
                maz[x][y] = 0;
                return false;
            }
        }
        public void run(){
            Queue<Integer> q = new LinkedList<Integer>();
            Map<Integer,Integer> truoc = new HashMap<>();
            q.add(10+0*this.sizew);
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            int[][] sign = new  int[22][31];
            sign[10][0] = 1;
            while (!q.isEmpty()){
                int point = q.poll();
                int y = point/this.sizew;
                int x = point %  this.sizew;

                for(int i = 0 ; i < 4; i ++){

                    int xNew = x + dx[i];
                    int yNew = y +dy[i];
                    int pointNew = yNew*this.sizew + xNew;
                    System.out.println(xNew+" " + yNew);
                    if(xNew < this.sizeh && xNew >= 0 && yNew < this.sizew &&
                            yNew >= 0 && this.maze[xNew][yNew] != 1 && sign[xNew][yNew] == 0
                    ){
                        truoc.put(pointNew , point);
                        q.add(pointNew);
                        sign[xNew][yNew] = 1;
                        if(maze[xNew][yNew] == 2){
                            this.end = pointNew;
                            break;
                        }
                    }
                }

            }
            int point = this.end;
            while(truoc.containsKey(point) ){
                point = truoc.get(point);
                int y = point/this.sizew;
                int x = point % this.sizew;
                this.maze[x][y] = 3;
            }
        }

        public void paintComponent(Graphics g) // vẽ ma trận + lời giải
        {
            super.paintComponent(g);
            for (int j = 0; j < sizew; j++)
                for (int i = 0; i < sizeh; i++) {
                    if (i == start && j == end)
                        g.setColor(Color.yellow);
                    else if (maze[i][j] == 0)
                        g.setColor(Color.white);
                    else if (maze[i][j] == 1)
                        g.setColor(Color.black);
                    else if (maze[i][j] == 2)
                        g.setColor(Color.red);
                    else
                        g.setColor(Color.blue); // blue là màu của lời giải
                    g.fillRect(j * 20, i * 20, 20, 20);
                }
        }

    }
}
