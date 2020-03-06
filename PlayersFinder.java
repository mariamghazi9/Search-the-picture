package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder {

	public Point[] p;

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		if(photo==null)
			throw new NullPointerException();

		char[][] arr=new char[photo.length][photo[0].toCharArray().length];
        for(int i=0;i<photo.length;i++){
            arr[i]=photo[i].toCharArray();
        }
        
        char k=(char)('0'+team);
        int[][] temp=new int[arr.length][arr[0].length];
        int i=1;
        for(int y=0;y<arr.length;y++){
            for(int x=0;x<arr[0].length;x++){
                if(checkChain(arr, temp, y, x, i, k)){
                    i++;
                }
            }
        }
        int [] found= new int[i+1];
        
        for(int m=0;m<=i;m++) {
        	found[m]=m;
        	}
        
        int flag=0,count;
        
        for(int m=1; m<=i; m++) {
        	count=0;
        for (int n= 0; n< temp.length; n++) {
                for (int l= 0; l< temp[n].length; l++) {
                    if(temp[n][l]==m){
                    	count++;
                    	}
                    if(flag==1){
                    	if(temp[n][l]==m-1){
                    		temp[n][l]=0;
                    		}
                    	}
                    if(count*4<threshold){
                    	flag=1;
                    	if(m!=i)
                    		found[m]=0;
                    	}
                    else flag=0;
                }
                count=0;
                
                for(m=0;m<i;m++) {
                	if(found[m]!=0)
                		count++;
                	}
                
                for(m=0;m<i;m++) {
                	if(found[m]!=0)
                		count++;
                	}
                }
                int[][]points=new int[count+1][2];
                int index=0;
                for(m=1;m<=i;m++) {
                	
                	if(found[m]==0)
                		continue;
                	
                    int maxX=0,maxY=0,minX=temp[0].length,minY=temp.length;
                    
                    for (int z = 0; z < temp.length; z++) {
                        for (int j = 0; j < temp[z].length; j++) {
                            if(temp[z][j]==m){
                            	
                                if(j>maxX)
                                	maxX=j;
                                if(z>maxY)
                                	maxY=z;
                                if(j<minX)
                                	minX=j;
                                if(z<minY)
                                	minY=z;

                            }
                        }

                    }
                    points[index][0]=minX+maxX+1;
                    points[index][1]=minY+maxY+1;
                    index++;
                }
                int[][]points2=new int[points.length-1][2];
                for(int j=0;j<points2.length;j++){
                    points2[j]=points[j];
                }
                points=points2;
                sort(points);
                Point[] p = new Point[points.length];
                for (int z=0;z<points.length;z++){
                    p[z]=new Point();
                    p[z].x=points[z][0];
                    p[z].y=points[z][1];
                }

            }       
		return p;
        
      }
	public  boolean checkChain(char[][] arr,int[][] temp,int y,int x,int i,char k){
        if(arr[y][x]==k){
            if(temp[y][x]==0){
            	temp[y][x]=i;
                if(y+1<arr.length) {
                	checkChain(arr, temp, y + 1, x, i, k);
                }
                if(y-1>-1) {
                	checkChain(arr, temp, y - 1, x, i, k);
                }
                if(x+1<arr[y].length) {
                	checkChain(arr, temp, y, x+1, i, k);
                }
                if(x-1>-1) {
                	checkChain(arr, temp, y , x-1, i, k);
                }
                return true;
            }
        }
        return false;
    }

    public  void  sort(int a[][]){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j][0]>a[j+1][0]){
                    temp=a[j][0];
                    a[j][0]=a[j+1][0];
                    a[j+1][0]=temp;
                    temp=a[j][1];
                    a[j][1]=a[j+1][1];
                    a[j+1][1]=temp;
                }
                else if(a[j][0]==a[j+1][0]){
                    if(a[j][1]>a[j+1][1]){
                        temp=a[j][0];
                        a[j][0]=a[j+1][0];
                        a[j+1][0]=temp;
                        temp=a[j][1];
                        a[j][1]=a[j+1][1];
                        a[j+1][1]=temp;
                    }
                }
            }
        }
    }

	}


