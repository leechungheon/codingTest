import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer=new int[2];
        int s1=0,s2=0;
        char[][] map=new char[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            map[i]=park[i].toCharArray();
            for(int j=0; j<park[i].length(); j++){
                if(map[i][j]=='S'){
                    s1=i;
                    s2=j;
                }
            }
        }
        for(int i=0; i<routes.length; i++){
            if(routes[i].charAt(0)=='N'){
                boolean possi=true;
                int n=Integer.parseInt(routes[i].substring(2));
                for(int j=1; j<=n; j++){
                    if(s1-j<0 || map[s1-j][s2]=='X')possi=false;
                }
                if(possi)s1=s1-n;
            }
            if(routes[i].charAt(0)=='W'){
                boolean possi=true;
                int n=Integer.parseInt(routes[i].substring(2));
                for(int j=1; j<=n; j++){
                    if(s2-j<0 || map[s1][s2-j]=='X')possi=false;
                }
                if(possi)s2=s2-n;
            }
            if(routes[i].charAt(0)=='S'){
                boolean possi=true;
                int n=Integer.parseInt(routes[i].substring(2));
                for(int j=1; j<=n; j++){
                    if(s1+j>=map.length || map[s1+j][s2]=='X')possi=false;
                }
                if(possi)s1=s1+n;
            }
            if(routes[i].charAt(0)=='E'){
                boolean possi=true;
                int n=Integer.parseInt(routes[i].substring(2));
                for(int j=1; j<=n; j++){
                    if(s2+j>=map[0].length || map[s1][s2+j]=='X')possi=false;
                }
                if(possi)s2=s2+n;
            }
            //System.out.println(s1+" "+s2);
        }
        answer[0]=s1;
        answer[1]=s2;
        return answer;
    }
}