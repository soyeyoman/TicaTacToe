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
      public boolean setPoint(String point,char mark){
          int i = 0;
          int j = 0;
          char one = point.charAt(0);
          char two = point.charAt(1);

          i = one == 'z'?0:one == 'o'?1:one == 't'?2:one == 'h'?3:200;
          j = two == '0'?0:two == '1'?1:two == '2'?2:two == '3'?3:200;
          this.Board[i][j] = mark;
          return isWin(i,j,mark);
      }
      public  boolean isWin(int i,int j,char c){
         return checkVert(i,j,c) || checkHor(i,j,c) || checkDiag(i,j,c);
      }

    private boolean checkDiag(int i,int j,char c) {

        //checking right diagonals

        //if in middle
        if(!((i+1)>3) && !((i-1)<0) && !((j-1)<0) && !((j+1)>3)){
            if(Board[i+1][j-1] == c && Board[i-1][j+1] == c)return true;
        }

        //if in top
        if(!((i+2)>3) && !((j-2)<0) && !((i+1)>3) && !((j-1)<0)){
            if(Board[i+2][j-2] == c && Board[i+1][j-1] == c)return true;
        }

        //if bottom
        if(!((i-1)<0) && !((j+1)>3) && !((i-2)<0) && !((j+2)>3)){
            if(Board[i-1][j+1] == c && Board[i-2][j+2] == c)return true;
        }

        //checking left diagonals

        //if in middle
        if(!((i-1)<0) && !((j-1)<0) && !((i+1)>3) && !((j+1)>3)){
            if(Board[i-1][j-1] == c && Board[i+1][j+1] == c)return true;
        }

        //if in top
        if(!((i+1)>3) && !((j+1)>3) && !((i+2)>3) && !((j+2)>3)){
            if(Board[i+2][j+2] == c && Board[i+1][j+1] == c)return true;
        }

        //if bottom
        if(!((i-1)<0) && !((j-1)<0) && !((i-2)<0) && !((j-2)<0)){
            if(Board[i-1][j-1] == c && Board[i-2][j-2] == c)return true;
        }

        return false;
    }

    private  boolean checkHor(int i,int j,char c) {
        if(!((j+1)>3) && !((j-1)<0)){
            if(Board[i][j+1] == c && Board[i][j-1] == c)
                return true;

        }

        if(!((j+1)>3) && !((j+2)>3)){
            if(Board[i][j+1] == c && Board[i][j+2] == c){
                return true;
            }
        }
        if(!((j-1)<0) && !((j-2)<0)){
            if(Board[i][j-1] == c && Board[i][j-2] == c){
                return true;
            }
        }

        return false;
    }

    private boolean checkVert(int i,int j,char c){
        if(!((i+1)>3) && !((i-1)<0)){
            if(Board[i-1][j] == c && Board[i+1][j] == c){
                return true;
            }
        }

        if(!((i+1)>3) && !((i+2)>3)){
            if(Board[i+1][j] == c && Board[i+2][j] == c){
                return true;
            }
        }
        if(!((i-1)<0) && !((i-2)<0)){
            if(Board[i-1][j] == c && Board[i-2][j] == c){
                return true;
            }
        }

        return false;
    }
}
