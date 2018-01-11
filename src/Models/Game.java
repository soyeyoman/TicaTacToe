package Models;

/**
 * Created by steve on 3/27/2017.
 */
public class Game
{
      char [][] Board;

      public Game(){
          Board = new char [4][4];
      }


      public boolean isEmpty(int col,int row){
          boolean val = false;
          if (Board[col][row] == ' ') val = true;
          return val;
      }
      public GameResult setPoint(String point,char mark){
          int i = 0;
          int j = 0;
          char one = point.charAt(0);
          char two = point.charAt(1);

          i = one == 'z'?0:one == 'o'?1:one == 't'?2:one == 'h'?3:200;
          j = two == '0'?0:two == '1'?1:two == '2'?2:two == '3'?3:200;
          this.Board[i][j] = mark;
          return isWin(i,j,mark);
      }
      public  GameResult isWin(int i,int j,char c){
          GameResult t = checkDiag(i,j,c);
          if(t.isWin()){
              return t;
          }
          t = checkHor(i,j,c);
          if(t.isWin()){
              return t;
          }
          t = checkVert(i,j,c);
          if(t.isWin()){
              return t;
          }

          return t;
      }

    private GameResult checkDiag(int i,int j,char c) {

        //checking right diagonals

        //if in middle
        if(!((i+1)>3) && !((i-1)<0) && !((j-1)<0) && !((j+1)>3)){
            if(Board[i+1][j-1] == c && Board[i-1][j+1] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i+1,j-1};
                int[] pos3 = {i-1,j+1};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        //if in top
        if(!((i+2)>3) && !((j-2)<0) && !((i+1)>3) && !((j-1)<0)){
            if(Board[i+2][j-2] == c && Board[i+1][j-1] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i+2,j-2};
                int[] pos3 = {i+1,j-1};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        //if bottom
        if(!((i-1)<0) && !((j+1)>3) && !((i-2)<0) && !((j+2)>3)){
            if(Board[i-1][j+1] == c && Board[i-2][j+2] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i-1,j+1};
                int[] pos3 = {i-2,j+2};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        //checking left diagonals

        //if in middle
        if(!((i-1)<0) && !((j-1)<0) && !((i+1)>3) && !((j+1)>3)){
            if(Board[i-1][j-1] == c && Board[i+1][j+1] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i-1,j-1};
                int[] pos3 = {i+1,j+1};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        //if in top
        if(!((i+1)>3) && !((j+1)>3) && !((i+2)>3) && !((j+2)>3)){
            if(Board[i+2][j+2] == c && Board[i+1][j+1] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i+2,j+2};
                int[] pos3 = {i+1,j+1};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        //if bottom
        if(!((i-1)<0) && !((j-1)<0) && !((i-2)<0) && !((j-2)<0)){
            if(Board[i-1][j-1] == c && Board[i-2][j-2] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i-1,j-1};
                int[] pos3 = {i-2,j-2};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        int[] pos1 = {0,0};
        int[] pos2 = {0,0};
        int[] pos3 = {0,0};
        return new GameResult(pos1,pos2,pos3,false);
    }

    private  GameResult checkHor(int i,int j,char c) {
        if(!((j+1)>3) && !((j-1)<0)){
            if(Board[i][j+1] == c && Board[i][j-1] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i,j+1};
                int[] pos3 = {i,j-1};
                return new GameResult(pos1,pos2,pos3,true);
            }

        }

        if(!((j+1)>3) && !((j+2)>3)){
            if(Board[i][j+1] == c && Board[i][j+2] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i,j+1};
                int[] pos3 = {i,j+2};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }
        if(!((j-1)<0) && !((j-2)<0)){
            if(Board[i][j-1] == c && Board[i][j-2] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i,j-1};
                int[] pos3 = {i,j-2};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        int[] pos1 = {0,0};
        int[] pos2 = {0,0};
        int[] pos3 = {0,0};
        return new GameResult(pos1,pos2,pos3,false);
    }

    private GameResult checkVert(int i,int j,char c){
        if(!((i+1)>3) && !((i-1)<0)){
            if(Board[i-1][j] == c && Board[i+1][j] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i-1,j};
                int[] pos3 = {i+1,j};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        if(!((i+1)>3) && !((i+2)>3)){
            if(Board[i+1][j] == c && Board[i+2][j] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i+1,j};
                int[] pos3 = {i+2,j};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }
        if(!((i-1)<0) && !((i-2)<0)){
            if(Board[i-1][j] == c && Board[i-2][j] == c){
                int[] pos1 = {i,j};
                int[] pos2 = {i-1,j};
                int[] pos3 = {i-2,j};
                return new GameResult(pos1,pos2,pos3,true);
            }
        }

        int[] pos1 = {0,0};
        int[] pos2 = {0,0};
        int[] pos3 = {0,0};
        return new GameResult(pos1,pos2,pos3,false);
    }
}
